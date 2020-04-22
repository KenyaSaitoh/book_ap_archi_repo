package jp.mufg.it.mybatis.company.dto;

import java.io.Serializable;

public class EmployeeDynamicParam implements Serializable {

    private String departmentName;
    private Integer lowerSalary;
    private Integer upperSalary;

    public EmployeeDynamicParam() {
    }

    public EmployeeDynamicParam(String departmentName, Integer lowerSalary,
            Integer upperSalary) {
        this.departmentName = departmentName;
        this.lowerSalary = lowerSalary;
        this.upperSalary = upperSalary;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getLowerSalary() {
        return lowerSalary;
    }

    public void setLowerSalary(Integer lowerSalary) {
        this.lowerSalary = lowerSalary;
    }

    public Integer getUpperSalary() {
        return upperSalary;
    }

    public void setUpperSalary(Integer upperSalary) {
        this.upperSalary = upperSalary;
    }
}