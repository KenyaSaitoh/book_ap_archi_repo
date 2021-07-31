package jp.mufg.it.ee.jpa.company.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PARTTIMER")
@DiscriminatorValue(value = "2")
public class Parttimer extends Employee {
    @Column(name = "WAGE")
    private Integer wage;

    // 引数なしのコンストラクタ
    public Parttimer() {
        super();
    }

    // コンストラクタ
    public Parttimer(Integer employeeId, String employeeName,
            Department department, Date entranceDate, Integer wage) {
        super(employeeId, employeeName, department, entranceDate);
        this.wage = wage;
    }

    // 時給（パート）へのアクセサメソッド
    public Integer getWage() {
        return wage;
    }

    public void setWage(Integer wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        return "Parttimer [" + getEmployeeId() + ", " + getEmployeeName() + ", "
                + getDepartment() + ", " +
                new SimpleDateFormat("yyyy/MM/dd").format(getEntranceDate()) +
                ", " + wage + "]";
    }
}