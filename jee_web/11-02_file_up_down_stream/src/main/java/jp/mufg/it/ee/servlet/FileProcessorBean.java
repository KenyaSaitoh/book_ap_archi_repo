package jp.mufg.it.ee.servlet;

import java.io.InputStream;
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

    public int uploadFile(String fileName, String contentType, InputStream is) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmt2 = null;

        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement("INSERT INTO FILE_STORE("
                    + "FILE_NAME, CONTENT_TYPE) VALUES(?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, fileName);
            pstmt.setString(2, contentType);
            pstmt.execute();

            ResultSet rset = pstmt.getGeneratedKeys();
            rset.next();
            Integer fileId = rset.getInt(1);

            pstmt2 = conn.prepareStatement("UPDATE FILE_STORE SET FILE = ? "
                    + "WHERE FILE_ID = ?");
            pstmt2.setBinaryStream(1, is); // isは入力ストリーム
            pstmt2.setInt(2, fileId);
            pstmt2.executeUpdate();

            return fileId;

        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);

        } finally {
            // リソースをクローズする
            if (pstmt2 != null) {
                try {
                    pstmt2.close();
                } catch (SQLException sqle) {
                    // Connectionをクローズさせるために、意図的に例外を握る
                }
            }
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
        PreparedStatement pstmt2 = null;

        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement("SELECT FILE_NAME, CONTENT_TYPE,"
                    + "FILE FROM FILE_STORE WHERE FILE_ID = ?");
            pstmt.setInt(1, fileId);
            ResultSet rset = pstmt.executeQuery();
            rset.next();
            String fileName = rset.getString(1);
            String contentType = rset.getString(2);

            pstmt2 = conn.prepareStatement("SELECT FILE FROM FILE_STORE "
                    + "WHERE FILE_ID = ?");
            pstmt2.setInt(1, fileId);
            ResultSet rset2 = pstmt2.executeQuery();
            rset2.next();
            InputStream is = rset2.getBlob(1).getBinaryStream(); // 入力ストリームを取得
            return new FileInfo(fileId, fileName, contentType, is);

        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);

        } finally {
            // リソースをクローズする
            if (pstmt2 != null) {
                try {
                    pstmt2.close();
                } catch (SQLException sqle) {
                    // Connectionをクローズさせるために、意図的に例外を握る
                }
            }
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