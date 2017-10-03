package jp.mufg.it.mybatis.company.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jp.mufg.it.mybatis.company.dto.Employee;

public class ResultUtil {

    public static void showEmployee(Employee employee) {
        System.out.print(employee.getEmployeeId() + " / ");
        System.out.print(employee.getEmployeeName() + " / ");
        System.out.print(employee.getDepartmentName() + " / ");
        System.out.println(employee.getMonthlySalary());
    }

    public static void showEmployeeList(List<Employee> list) {
        Iterator<Employee> i = list.iterator();
        while (i.hasNext()) {
            Employee employee = i.next();
            showEmployee(employee);
        }
    }

    public static void showEmployeeList2(List<Object> list) {
        Iterator<Object> i = list.iterator();
        while (i.hasNext()) {
            Employee employee = (Employee)i.next();
            showEmployee(employee);
        }
    }

    public static void showEmployeeMap(Map<Integer, Employee> map) {
        Iterator<Integer> i = map.keySet().iterator();
        while (i.hasNext()) {
            Integer employeeId = i.next();
            System.out.print(employeeId + " ---> ");
            showEmployee((Employee)map.get(employeeId));
        }
    }

    public static void showObjectArray(Object[] objs) {
        for (int i = 0; i < objs.length; i++) {
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

    public static void showEmployeeFromDatabase(int employeeId) {
        String driver = PropertyUtil.getValue("jdbc.driver");
        String user = PropertyUtil.getValue("jdbc.user");
        String password = PropertyUtil.getValue("jdbc.password");
        String url = PropertyUtil.getValue("jdbc.url");
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID = ?");
            pstmt.setInt(1, employeeId);
            ResultSet rset = pstmt.executeQuery();
            while (rset.next()) {
                System.out.println(rset.getInt(1) + " / " + rset.getString(2) +
                " / " + rset.getString(3) + " / " + rset.getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}