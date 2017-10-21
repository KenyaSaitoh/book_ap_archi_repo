package jp.mufg.it.ee.servlet.tagfile;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.sql.DataSource;

@RequestScoped
@Named("departmentBean")
public class DepartmentBean {

    @Resource(lookup = "jdbc/DerbyDS")
    private DataSource ds;

    public List<String> getDepartmentNameList() {
        System.out.println("############## getDepartmentNameList #################");
        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;
        List<String> departmentNameList = new ArrayList<String>();
        try {
            conn = ds.getConnection();
            stmt = conn.createStatement();
            String sqlStr = "SELECT DEPARTMENT_NAME FROM DEPARTMENT";
            rset = stmt.executeQuery(sqlStr);
            while(rset.next()) {
                String departmentName = rset.getString(1);
                departmentNameList.add(departmentName);
            }
            return departmentNameList;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqle) {
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