package org.study.ee.rs.server.employee;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "EMPLOYEE")
// @XmlRootElement(name = "employee") // JSON形式で返すときはこのアノテーションは不要
public class Employee implements Serializable {

    @PathParam("employeeId")
    private int employeeId;
    private String employeeName;
    private String departmentName;
    private int monthlySalary;

    // 引数なしのコンストラクタ
    public Employee() {
    }

    // コンストラクタ
    public Employee(String employeeName, String departmentName,
            int monthlySalary) {
        this.employeeName = employeeName;
        this.departmentName = departmentName;
        this.monthlySalary = monthlySalary;
    }

    // 社員番号へのアクセサメソッド
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEE_ID")
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    // 社員名へのアクセサメソッド
    @Column(name = "EMPLOYEE_NAME")
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    // 部門名へのアクセサメソッド
    @Column(name = "DEPARTMENT_NAME")
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    // 月給へのアクセサメソッド
    @Column(name = "MONTHLY_SALARY")
    public int getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", employeeName="
                + employeeName + ", departmentName=" + departmentName
                + ", monthlySalary=" + monthlySalary + "]";
    }
}