package jp.mufg.it.jdbc.sales;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.mufg.it.jdbc.util.PropertyUtil;

public class JdbcBatchMain {

    public static void main(String[] args) {
        // プロパティファイルよりデータベース情報を取得する。
        String driver = PropertyUtil.getValue("jdbc.driver");
        String url = PropertyUtil.getValue("jdbc.url");
        String user = PropertyUtil.getValue("jdbc.user");
        String password = PropertyUtil.getValue("jdbc.password");

        try {
            // JDBCドライバをロードする。
            Class.forName(driver);
        } catch(ClassNotFoundException cnfe) {
            throw new RuntimeException(cnfe);
        }

        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        ResultSet rset = null;
        try {
            // データベースに接続し、トランザクション用コネクションを取得する。
            conn = DriverManager.getConnection(url, user, password);

            // トランザクションを開始する。
            conn.setAutoCommit(false);

            // ステートメントを生成する。
            pstmt1 = conn.prepareStatement(
                    "SELECT SALES_ID FROM SALES_TRAN " +
                    "WHERE SALES_DATE = ? " +
                    "AND UPDATE_STOCK_FLAG = 0");
            pstmt1.setDate(1, Date.valueOf("2015-09-10"));
            rset = pstmt1.executeQuery();

            // 更新用のプリペアードステートメントは、whileループの外側で宣言すること！
            pstmt2 = conn.prepareStatement(
                    "UPDATE STOCK_PRODUCT SP " +
                    "INNER JOIN (SALES_TRAN ST INNER JOIN SALES_DETAIL SD " +
                    "ON ST.SALES_ID = SD.SALES_ID) " +
                    "ON SP.PRODUCT_ID = SD.PRODUCT_ID " +
                    "SET SP.QUANTITY = SP.QUANTITY - SD.SALES_COUNT, " +
                    "ST.UPDATE_STOCK_FLAG = 1 " +
                    "WHERE ST.SALES_ID = ?");

            int i = 0;
            while (rset.next()) {
                i++;
                Integer salesId = rset.getInt(1);
                pstmt2.setInt(1, salesId);
                pstmt2.addBatch();
                if (i % 10 == 0) {
                    pstmt2.executeBatch();
                    conn.commit();
                }
            }
            pstmt2.executeBatch();
            conn.commit();

        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);

        } finally {
            // リソースをクローズする。
            if (rset != null) {
                try {
                    rset.close();
                } catch (SQLException sqle) {
                    // Connectionをクローズさせるために、意図的に例外を握る。
                }
            }
            if (pstmt1 != null) {
                try {
                    pstmt1.close();
                } catch (SQLException sqle) {
                    // Connectionをクローズさせるために、意図的に例外を握る。
                }
            }
            if (pstmt2 != null) {
                try {
                    pstmt2.close();
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
}