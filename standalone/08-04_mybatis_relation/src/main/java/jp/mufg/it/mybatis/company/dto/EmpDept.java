package jp.mufg.it.mybatis.company.dto;

import java.io.Serializable;
import java.util.Date;

import jp.mufg.it.mybatis.company.type.JobType;

public class EmpDept implements Serializable {
    private Integer employeeId;
    private String employeeName;
    private Date entranceDate;
    private JobType jobType;
    private Integer salary;
    private Integer departmentId;
    private String departmentName;
    private String location;

    // 引数なしのコンストラクタ
    public EmpDept() {
    }

    // コンストラクタ
    public EmpDept(Integer employeeId, String employeeName,
            Date entranceDate, JobType jobType, Integer salary,
            Integer departmentId, String departmentName, String location) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.entranceDate = entranceDate;
        this.jobType = jobType;
        this.salary = salary;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.location = location;
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

    // 入社年月日へのアクセサメソッド
    public Date getEntranceDate() {
        return entranceDate;
    }

    public void setEntranceDate(Date entranceDate) {
        this.entranceDate = entranceDate;
    }

    // 役職種別へのアクセサメソッド
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

    // 部門IDへのアクセサメソッド
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    // 部門名へのアクセサメソッド
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    // 所在地のアクセサメソッド
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "EmployeeDepartment [employeeId=" + employeeId
                + ", employeeName=" + employeeName + ", entranceDate="
                + entranceDate + ", jobType=" + jobType + ", salary=" + salary
                + ", departmentId=" + departmentId + ", departmentName="
                + departmentName + ", location=" + location + "]";
    }
}