package jp.mufg.it.mybatis.company.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import jp.mufg.it.mybatis.company.dto.Employee;
import jp.mufg.it.mybatis.company.dto.EmployeeDepartment;

public class ResultUtil {

    public static void showEmployeeTO(EmployeeDepartment employee) {
        System.out.print(employee.getEmployeeId() + " / ");
        System.out.print(employee.getEmployeeName() + " / ");
        System.out.print(employee.getDepartmentName() + " / ");
        System.out.print(employee.getsalary() + " / ");
        System.out.println(employee.getBuildingName());
    }

    public static void showEmployee(Employee employee) {
        if (employee != null) {
            System.out.print(employee.getEmployeeId() + " / ");
            System.out.print(employee.getEmployeeName() + " / ");
            if (employee.getDepartment() != null)
                System.out.print(employee.getDepartment().getDepartmentName()
                        + " / ");
            else
                System.out.print("null" + " / ");
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(employee.getEntranceDate().getTime());
            String entranceDate =
                    cal.get(Calendar.YEAR) + "年"
                            + (cal.get(Calendar.MONTH) + 1) + "月"
                            + cal.get(Calendar.DATE) + "日";
            System.out.print(entranceDate + " / ");
            System.out.print(employee.getJobType().toString() + " / ");
            System.out.print(employee.getSalary() + " / ");
            System.out.println(employee.getVersion());
        }
    }


    public static void showObjectArray(Object[] objs) {
        for (Integer i = 0; i < objs.length; i++) {
            System.out.print(objs[i] + " / ");
        }
        System.out.println();
    }

    public static void showObjectArrayList(List<Object[]> resultList) {
        Iterator<Object[]> i = resultList.iterator();
        while (i.hasNext()) {
            Object[] objs = i.next();
            showObjectArray(objs);
        }
    }

    public static void showEmployeeFromDatabase(Integer employeeId) {
        String driver = PropertyUtil.getValue("jdbc.driver");
        String url = PropertyUtil.getValue("jdbc.url");
        String user = PropertyUtil.getValue("jdbc.user");
        String password = PropertyUtil.getValue("jdbc.password");
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID = ?");
            pstmt.setInt(1, employeeId);
            ResultSet rset = pstmt.executeQuery();
            while (rset.next()) {
                System.out.println(rset.getInt(1) + " / " + rset.getString(2)
                        + " / " + rset.getInt(3) + " / " + rset.getDate(4)
                        + " / " + rset.getInt(5) + " / " + rset.getInt(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showDepartmentFromDatabase(Integer departmentId) {
        String driver = PropertyUtil.getValue("jdbc.driver");
        String url = PropertyUtil.getValue("jdbc.url");
        String user = PropertyUtil.getValue("jdbc.user");
        String password = PropertyUtil.getValue("jdbc.password");
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT * FROM DEPARTMENT WHERE DEPARTMENT_ID = ?");
            pstmt.setInt(1, departmentId);
            ResultSet rset = pstmt.executeQuery();
            while (rset.next()) {
                System.out.println(rset.getInt(1) + " / " + rset.getString(2)
                        + " / " + rset.getString(3) + " / " + rset.getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}