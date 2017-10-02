package jp.mufg.it.ee.jpa.company.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "2")
public class Parttimer extends Employee {
    private Integer parttimerPayment;

    // 引数なしのコンストラクタ
    public Parttimer() {
        super();
    }

    // コンストラクタ
    public Parttimer(Integer employeeId, String employeeName, Department department,
            Date entranceDate, Integer parttimerPayment) {
        super(employeeId, employeeName, department, entranceDate);
        this.parttimerPayment = parttimerPayment;
    }

    // 時給（パート）へのアクセサメソッド
    @Column(name = "PARTTIMER_PAYMENT")
    public Integer getParttimerPayment() {
        return parttimerPayment;
    }

    public void setParttimerPayment(Integer parttimerPayment) {
        this.parttimerPayment = parttimerPayment;
    }
}