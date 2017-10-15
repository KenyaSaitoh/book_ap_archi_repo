package jp.mufg.it.ee.rs.employee;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.ws.rs.PathParam;

@Entity
@Table(name = "EMPLOYEE")
// @XmlRootElement(name = "employee") // JSON形式で返すときはこのアノテーションは不要
public class Employee implements Serializable {

    @PathParam("employeeId")
    private Integer employeeId;
    private String employeeName;
    private String departmentName;
    private Integer salary;

    // 引数なしのコンストラクタ
    public Employee() {
    }

    // コンストラクタ
    public Employee(String employeeName, String departmentName,
            Integer salary) {
        this.employeeName = employeeName;
        this.departmentName = departmentName;
        this.salary = salary;
    }

    // 社員IDへのアクセサメソッド
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEE_ID")
    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
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
    @Column(name = "SALARY")
    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", employeeName="
                + employeeName + ", departmentName=" + departmentName
                + ", salary=" + salary + "]";
    }
}