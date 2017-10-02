package jp.mufg.it.ee.jpa.company.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "EMPLOYEE_TYPE",
        discriminatorType = DiscriminatorType.STRING)
public class Employee {
    private Integer employeeId;
    private String employeeName;
    private Department department;
    private Integer employeeType;
    private Date entranceDate;

    // 引数なしのコンストラクタ
    public Employee() {
    }

    public Employee(Integer employeeId, String employeeName, Department department,
            Integer employeeType, Date entranceDate) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
        this.employeeType = employeeType;
        this.entranceDate = entranceDate;
    }

    // 社員番号へのアクセサメソッド
    @Id
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

    // 部署へのアクセサメソッド
    @ManyToOne(targetEntity = Department.class)
    @JoinColumn(name = "DEPARTMENT_ID",
            referencedColumnName = "DEPARTMENT_ID")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    // 社員種別へのアクセサメソッド
    @Column(name = "EMPLOYEE_TYPE")
    public Integer getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(Integer employeeType) {
        this.employeeType = employeeType;
    }

    // 入社年月日へのアクセサメソッド
    @Column(name = "ENTRANCE_DATE")
    @Temporal(value = TemporalType.DATE)
    public Date getEntranceDate() {
        return entranceDate;
    }

    public void setEntranceDate(Date entranceDate) {
        this.entranceDate = entranceDate;
    }
}