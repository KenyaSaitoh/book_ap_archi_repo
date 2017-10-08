package jp.mufg.it.mybatis.company.dto;

import java.io.Serializable;

public class EmployeeSalaryParam implements Serializable {
    private int monthlySalary;
    private int payCut;

    public EmployeeSalaryParam(int monthlySalary, int payCut) {
        super();
        this.monthlySalary = monthlySalary;
        this.payCut = payCut;
    }

    public int getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public int getPayCut() {
        return payCut;
    }

    public void setPayCut(int payCut) {
        this.payCut = payCut;
    }
}