package jp.mufg.it.ee.jpa.company.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "FULLTIMER")
@DiscriminatorValue(value = "1")
public class Fulltimer extends Employee {
    private String jobName;
    private Integer monthlySalary;

    // 引数なしのコンストラクタ
    public Fulltimer() {
        super();
    }

    // コンストラクタ
    public Fulltimer(Integer employeeId, String employeeName, Department department,
            Integer employeeType, Date entranceDate, String jobName,
            Integer monthlySalary) {
        super(employeeId, employeeName, department, employeeType, entranceDate);
        this.jobName = jobName;
        this.monthlySalary = monthlySalary;
    }

    // 役職名へのアクセサメソッド
    @Column(name = "JOB_NAME")
    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    // 月給（社員）へのアクセサメソッド
    @Column(name = "MONTHLY_SALARY")
    public Integer getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(Integer monthlySalary) {
        this.monthlySalary = monthlySalary;
    }
}