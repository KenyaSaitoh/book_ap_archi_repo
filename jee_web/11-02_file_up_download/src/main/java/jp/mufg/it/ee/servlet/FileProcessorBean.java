package jp.mufg.it.ee.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.sql.DataSource;

@RequestScoped
@Named("fileBean")
public class FileProcessorBean {
    // インジェクションポイント
    @Resource(lookup = "jdbc/MySQLDS")
    private DataSource ds;

    public int uploadFile(String fileName, String contentType, byte[] file) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement("INSERT INTO FILE_STORE("
                    + "FILE_NAME, CONTENT_TYPE, FILE) VALUES(?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, fileName);
            pstmt.setString(2, contentType);
            pstmt.setBytes(3, file);
            pstmt.execute();

            ResultSet rset = pstmt.getGeneratedKeys();
            rset.next();
            return rset.getInt(1);

        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);

        } finally {
            // リソースをクローズする
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException sqle) {
                    // Connectionをクローズさせるために、意図的に例外を握る
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

    public FileInfo downloadFile(int fileId) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement("SELECT FILE_NAME, CONTENT_TYPE,"
                    + "FILE FROM FILE_STORE WHERE FILE_ID = ?");
            pstmt.setInt(1, fileId);
            ResultSet rset = pstmt.executeQuery();
            rset.next();
            String fileName = rset.getString(1);
            String contentType = rset.getString(2);
            byte[] file = rset.getBytes(3);
            return new FileInfo(fileId, fileName, contentType, file);

        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);

        } finally {
            // リソースをクローズする
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException sqle) {
                    // Connectionをクローズさせるために、意図的に例外を握る
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
}