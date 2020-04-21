package jp.mufg.it.mybatis.company.dto;

import java.io.Serializable;

public class EmployeeSalaryParam implements Serializable {
    private int salary;
    private int payCut;

    public EmployeeSalaryParam(int salary, int payCut) {
        super();
        this.salary = salary;
        this.payCut = payCut;
    }

    public int getsalary() {
        return salary;
    }

    public void setsalary(int salary) {
        this.salary = salary;
    }

    public int getPayCut() {
        return payCut;
    }

    public void setPayCut(int payCut) {
        this.payCut = payCut;
    }
}