package jp.mufg.it.ee.jbatch.sales;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.batch.api.chunk.ItemWriter;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.sql.DataSource;

@Named
@Dependent
public class SalesItemWriter implements ItemWriter {

    @Resource(lookup = "jdbc/MySQLSalesDS")
    private DataSource ds;

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rset;

    @Override
    public void open(Serializable checkpoint) throws Exception {
        System.out.println("[ SalesItemWriter#open ]");
    }

    @Override
    public void close() throws Exception {
        System.out.println("[ SalesItemWriter#close ]");
        if (rset != null) {
            try {
                rset.close();
            } catch (SQLException sqle) {
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException sqle) {
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException sqle) {
            }
        }
    }

    @Override
    public void writeItems(List<Object> items) throws Exception {
        System.out.println("[ SalesItemWriter#writeItems ]");
        Connection conn = ds.getConnection();
        for (Object obj : items) {
            Integer salesId = (Integer)obj;
            System.out.println("salesId ---> " + salesId);
            pstmt = conn.prepareStatement(
                    "UPDATE STOCK_PRODUCT SP " +
                    "INNER JOIN (SALES_TRAN ST INNER JOIN SALES_DETAIL SD " +
                    "ON ST.SALES_ID = SD.SALES_ID) " +
                    "ON SP.PRODUCT_ID = SD.PRODUCT_ID " +
                    "SET SP.QUANTITY = SP.QUANTITY - SD.SALES_COUNT, " +
                    "ST.UPDATE_STOCK_FLAG = 1 " +
                    "WHERE ST.SALES_ID = ?");
            pstmt.setInt(1, salesId);
            pstmt.executeUpdate();
        }
        conn.commit();
        conn.close(); // これを呼ばないとコネクションプールが枯渇する。
    }

    @Override
    public Serializable checkpointInfo() throws Exception {
        return null;
    }
}
