package jp.mufg.it.ee.jpa.company.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import jp.mufg.it.ee.jpa.company.type.JobType;

@Entity
@Table(name = "FULLTIMER")
@DiscriminatorValue(value = "1")
public class Fulltimer extends Employee {
    @Column(name = "JOB_ID")
    @Enumerated(EnumType.ORDINAL)
    private JobType jobType;

    @Column(name = "SALARY")
    private Integer salary;

    // 引数なしのコンストラクタ
    public Fulltimer() {
        super();
    }

    // コンストラクタ
    public Fulltimer(Integer employeeId, String employeeName,
            Department department, Date entranceDate, JobType jobType,
            Integer salary) {
        super(employeeId, employeeName, department, entranceDate);
        this.jobType = jobType;
        this.salary = salary;
    }

    // 役職名へのアクセサメソッド
    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    // 月給（社員）へのアクセサメソッド
    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Fulltimer [" + getEmployeeId() + ", " + getEmployeeName() + ", "
                + getDepartment() + ", " +
                new SimpleDateFormat("yyyy/MM/dd").format(getEntranceDate()) +
                ", " + jobType + ", " + salary + "]";
    }
}