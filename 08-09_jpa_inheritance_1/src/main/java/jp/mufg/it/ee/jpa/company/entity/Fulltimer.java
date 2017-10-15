package jp.mufg.it.ee.jpa.company.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "1")
public class Fulltimer extends Employee {
    private String jobName;
    private Integer salary;

    // 引数なしのコンストラクタ
    public Fulltimer() {
        super();
    }

    // コンストラクタ
    public Fulltimer(Integer employeeId, String employeeName, Department department,
            Date entranceDate, String jobName, Integer salary) {
        super(employeeId, employeeName, department, entranceDate);
        this.jobName = jobName;
        this.salary = salary;
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
    @Column(name = "SALARY")
    public Integer getsalary() {
        return salary;
    }

    public void setsalary(Integer salary) {
        this.salary = salary;
    }
}