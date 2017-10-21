package jp.mufg.it.dao.company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.mufg.it.dao.company.entity.Employee;

public class EmployeeDAO {
    private Connection conn;

    // コンストラクタ
    public EmployeeDAO(Connection conn) {
        this.conn = conn;
    }

    // 検索（主キーから）
    public Employee findEmployee(int employeeId) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        try {
            String sqlStr = "SELECT EMPLOYEE_ID, EMPLOYEE_NAME, "
                    + "DEPARTMENT_NAME, MONTHLY_SALARY "
                    + "FROM EMPLOYEE WHERE EMPLOYEE_ID=?";
            pstmt = conn.prepareStatement(sqlStr);
            pstmt.setInt(1, employeeId);
            rset = pstmt.executeQuery();
            Employee employee = null;
            if (rset.next()) {
                employee = new Employee(employeeId,
                        rset.getString("EMPLOYEE_NAME"),
                        rset.getString("DEPARTMENT_NAME"),
                        rset.getInt("SALARY"));
            }
            return employee;
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException sqle) {
                    throw new RuntimeException(sqle);
                }
            }
        }
    }

    // 検索（月給の範囲で検索）
    public List<Employee> findEmployeesBySalary(int lowerSalary,
            int upperSalary) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        try {
            String sqlStr = "SELECT EMPLOYEE_ID, EMPLOYEE_NAME, "
                    + "DEPARTMENT_NAME, MONTHLY_SALARY FROM EMPLOYEE "
                    + "WHERE ? <= SALARY AND SALARY <= ?";
            pstmt = conn.prepareStatement(sqlStr);
            pstmt.setInt(1, lowerSalary);
            pstmt.setInt(2, upperSalary);
            rset = pstmt.executeQuery();
            List<Employee> list = new ArrayList<Employee>();
            while (rset.next()) {
                Integer employeeId = rset.getInt("EMPLOYEE_ID");
                String employeeName = rset.getString("EMPLOYEE_NAME");
                String departmentName = rset.getString("DEPARTMENT_NAME");
                Integer salary = rset.getInt("SALARY");
                Employee employee = new Employee();
                employee.setEmployeeId(employeeId);
                employee.setEmployeeName(employeeName);
                employee.setDepartmentName(departmentName);
                employee.setSalary(salary);
                list.add(employee);
            }
            return list;
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException sqle) {
                    throw new RuntimeException(sqle);
                }
            }
        }
    }

    // 挿入
    public void createEmployee(Employee employee) {
        PreparedStatement pstmt = null;
        Integer employeeId = employee.getEmployeeId();
        String employeeName = employee.getEmployeeName();
        String departmentName = employee.getDepartmentName();
        Integer salary = employee.getSalary();
        try {
            String sqlStr = "INSERT INTO EMPLOYEE VALUES(?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sqlStr);
            pstmt.setInt(1, employeeId);
            pstmt.setString(2, employeeName);
            pstmt.setString(3, departmentName);
            pstmt.setInt(4, salary);
            pstmt.executeUpdate();
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException sqle) {
                    throw new RuntimeException(sqle);
                }
            }
        }
    }
}