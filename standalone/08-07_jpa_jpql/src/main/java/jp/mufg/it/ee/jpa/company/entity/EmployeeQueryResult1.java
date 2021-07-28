package jp.mufg.it.ee.jpa.company.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;

@Entity
@NamedNativeQuery(name = "findEmployeesByDepartmentId1",
        query = "SELECT e.EMPLOYEE_ID AS E_EMPLOYEE_ID, " +
                "e.EMPLOYEE_NAME AS E_EMPLOYEE_NAME, " +
                "d.DEPARTMENT_NAME AS D_DEPARTMENT_NAME " +
                "FROM EMPLOYEE e, DEPARTMENT d " +
                "WHERE e.DEPARTMENT_ID = d.DEPARTMENT_ID " +
                "AND e.EMPLOYEE_ID = ?1",
        resultClass = EmployeeQueryResult1.class)
public class EmployeeQueryResult1 {
    @Id
    @Column(name = "E_EMPLOYEE_ID")
    private int employeeId;

    @Column(name = "E_EMPLOYEE_NAME")
    private String employeeName;

    @Column(name = "D_DEPARTMENT_NAME")
    private String departmentName;

    // 引数なしのコンストラクタ
    public EmployeeQueryResult1() {
    }

    // コンストラクタ
    public EmployeeQueryResult1(int employeeId, String employeeName,
            String departmentName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.departmentName = departmentName;
    }

    // 社員番号へのアクセサメソッド
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    // 社員名へのアクセサメソッド
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    // 部署名へのアクセサメソッド
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "EmployeeQueryResult1 [employeeId=" + employeeId
                + ", employeeName=" + employeeName + ", departmentName="
                + departmentName + "]";
    }
}