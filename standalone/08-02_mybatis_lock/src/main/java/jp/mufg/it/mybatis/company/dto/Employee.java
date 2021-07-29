package jp.mufg.it.mybatis.company.dto;

import java.util.Date;

import jp.mufg.it.mybatis.company.type.JobType;

public class Employee {
    private Integer employeeId;
    private String employeeName;
    private String departmentName;
    private Date entranceDate;
    private JobType jobType;
    private Integer salary;
    private Long version;

    // 引数なしのコンストラクタ
    public Employee() {
    }

    // コンストラクタ
    public Employee(Integer employeeId, String employeeName,
            String departmentName, Date entranceDate, JobType jobType,
            Integer salary, Long version) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.departmentName = departmentName;
        this.entranceDate = entranceDate;
        this.jobType = jobType;
        this.salary = salary;
        this.version = version;
    }

    public Employee(String employeeName, String departmentName,
            Date entranceDate, JobType jobType, Integer salary, Long version) {
        this.employeeName = employeeName;
        this.departmentName = departmentName;
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

    // 部署名へのアクセサメソッド
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    // 月給へのアクセサメソッド
    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
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

    // バージョンへのアクセサメソッド
    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Employee [" + employeeId + ", " + employeeName + ", "
                + departmentName + ", " + entranceDate + ", " + jobType + ", "
                + salary + ", " + version + "]";
    }
}