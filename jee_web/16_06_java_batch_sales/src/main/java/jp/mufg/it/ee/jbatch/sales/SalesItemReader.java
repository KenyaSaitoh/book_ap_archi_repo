package jp.mufg.it.ee.jbatch.sales;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.batch.api.chunk.ItemReader;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

@Named
@Dependent
public class SalesItemReader implements ItemReader {
    @Resource(lookup = "jdbc/MySQLSalesDS")
    private DataSource ds;
    @Inject
    private JobContext context;

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rset;

    @Override
    public void open(Serializable checkpoint) throws Exception {
        System.out.println("[ SalesItemReader#open ]");
        Connection conn = ds.getConnection();
        pstmt = conn.prepareStatement(
                "SELECT SALES_ID FROM SALES_TRAN " +
                "WHERE SALES_DATE = ? " +
                "AND UPDATE_STOCK_FLAG = 0");
        String salesDate = context.getProperties().getProperty("salesDate");
        pstmt.setDate(1, Date.valueOf(salesDate));
        rset = pstmt.executeQuery();
    }

    @Override
    public void close() throws Exception {
        System.out.println("[ SalesItemReader#close ]");
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
    public Object readItem() throws Exception {
        System.out.println("[ SalesItemReader#readItem ]");
        if (! rset.next()) {
            return null;
        }
        Integer salesId = rset.getInt(1);
        System.out.println("salesId => " + salesId);
        return salesId;
    }

    @Override
    public Serializable checkpointInfo() throws Exception {
        return null;
    }
}