package jp.mufg.it.ee.jpa.company.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import jp.mufg.it.ee.jpa.company.type.JobType;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @Column(name = "EMPLOYEE_ID")
    private Integer employeeId;

    @Column(name = "EMPLOYEE_NAME")
    private String employeeName;

    @ManyToOne(targetEntity = Department.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "DEPARTMENT_ID",
            referencedColumnName = "DEPARTMENT_ID")
    private Department department;

    @Column(name = "ENTRANCE_DATE")
    @Temporal(TemporalType.DATE)
    private Date entranceDate;

    @Column(name = "JOB_ID")
    @Enumerated(EnumType.ORDINAL)
    private JobType jobType;

    @Column(name = "SALARY")
    private Integer salary;

    @Version
    private Long version;

    // 引数なしのコンストラクタ
    public Employee() {
    }

    // コンストラクタ
    public Employee(Integer employeeId, String employeeName,
            Department department, Date entranceDate, JobType jobType,
            Integer salary, Long version) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
        this.entranceDate = entranceDate;
        this.jobType = jobType;
        this.salary = salary;
        this.version = version;
    }

    // 社員IDへのアクセサメソッド
    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    // 社員名へのアクセサメソッド
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    // 部署へのアクセサメソッド
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    // 入社年月日へのアクセサメソッド
    public Date getEntranceDate() {
        return entranceDate;
    }

    public void setEntranceDate(Date entranceDate) {
        this.entranceDate = entranceDate;
    }

    // 役職名へのアクセサメソッド
    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    // 月給へのアクセサメソッド
    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    // バージョン（楽観的ロックで使用）へのアクセサメソッド
    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Employee [" + employeeId + ", " + employeeName + ", "
                + department + ", " +
                new SimpleDateFormat("yyyy/MM/dd").format(entranceDate) + ", " +
                jobType + ", " + salary + ", " + version + "]";
    }
}