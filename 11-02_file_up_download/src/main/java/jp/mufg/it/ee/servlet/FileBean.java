package jp.mufg.it.ee.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.sql.DataSource;

@RequestScoped
@Named("fileBean")
public class FileBean {
    // インジェクションポイント
    @Resource(lookup = "jdbc/DerbyDS")
    private DataSource ds;

    // アクションメソッド
    public void uploadFile(String fileName, String contentType, byte[] file) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ds.getConnection();
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement("INSERT INTO FILE_STORE("
                    + "FILE_NAME, CONTENT_TYPE, FILE) VALUES(?, ?, ?)");
            pstmt.setString(1, fileName);
            pstmt.setString(2, contentType);
            pstmt.setBytes(3, file);
            pstmt.execute();
            conn.commit();

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