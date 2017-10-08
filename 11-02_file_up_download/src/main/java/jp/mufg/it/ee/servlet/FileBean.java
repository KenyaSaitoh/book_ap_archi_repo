package jp.mufg.it.ee.servlet;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.servlet.http.Part;
import javax.sql.DataSource;

@RequestScoped
@Named("fileBean")
public class FileBean {
    // インジェクションポイント
    @Resource(lookup = "jdbc/DerbyDS")
    private DataSource ds;

    // "何らかの値"
    private String something;

    // アップロードされたファイル
    private Part filePart;

    // アップロードされたファイル名
    private String fileName;

    // アクセサ
    public String getSomething() {
        return something;
    }

    public void setSomething(String something) {
        this.something = something;
    }

    public Part getFilePart() {
        return filePart;
    }

    public void setFilePart(Part filePart) {
        this.filePart = filePart;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    // アクションメソッド
    public void uploadFile() {
        fileName = extractFileName(filePart);
        byte[] fileBinary = extractFileBinary(filePart);

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ds.getConnection();
            conn.setAutoCommit(false);
            String sqlStr = "INSERT INTO FILE_STORE(FILE_NAME, FILE) VALUES(?, ?)";
            pstmt = conn.prepareStatement(sqlStr);
            pstmt.setString(1, fileName);
            pstmt.setBytes(2, fileBinary);
            pstmt.execute();
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);

        } finally {
            // リソースをクローズする。
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException sqle) {
                    // Connectionをクローズさせるために、意図的に例外を握る。
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException sqle) {
                    throw new RuntimeException(sqle);
                }
            }
        }
    }

    // アクションメソッド
    public String execute() {
        System.out.println("something ---> " + something);
        uploadFile();
        return "FileUploadOutputPage";
    }

    private byte[] extractFileBinary(Part part) {
        ByteArrayOutputStream baos = null;
        BufferedInputStream bis = null;
        try {
            baos = new ByteArrayOutputStream();
            bis = new BufferedInputStream(filePart.getInputStream());
            byte[] buf = new byte[50];
            int size = -1;
            while ((size = bis.read(buf, 0, buf.length)) != -1) {
                baos.write(buf, 0, size);
            }
            return baos.toByteArray();

        } catch(IOException ioe) {
            throw new RuntimeException(ioe);

        } finally {
            try {
                baos.close();
                bis.close();
            } catch(IOException ioe) {
                throw new RuntimeException(ioe);
            }
        }
    }

    private String extractFileName(Part part) {
        String partHeader = part.getHeader("content-disposition");
        for (String cd : partHeader.split(";")) {
            if (cd.trim().startsWith("filename")) {
                String tmpFileName = cd.substring(cd.indexOf('=') + 1).trim()
                        .replace("\"", "");
                // for MSIE
                String fileName =
                        tmpFileName.substring(tmpFileName.lastIndexOf('/') + 1)
                        .substring(tmpFileName.lastIndexOf('\\') + 1);
                return fileName;
            }
        }
        return null;
    }
}