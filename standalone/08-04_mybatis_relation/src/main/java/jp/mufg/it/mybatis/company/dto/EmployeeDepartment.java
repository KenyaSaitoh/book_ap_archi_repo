package jp.mufg.it.mybatis.company.dto;

import java.io.Serializable;

public class EmployeeDepartment implements Serializable {
    private Integer employeeId;
    private String employeeName;
    private int salary;
    private int departmentId;
    private String departmentName;
    private String buildingName;
    private Integer floor;

    // 引数なしのコンストラクタ
    public EmployeeDepartment() {
    }

    // コンストラクタ
    public EmployeeDepartment(Integer employeeId, String employeeName, int salary,
            int departmentId) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
        this.departmentId = departmentId;
    }

    // 従業員番号へのアクセサメソッド
    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    // 従業員名へのアクセサメソッド
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    // 月給へのアクセサメソッド
    public int getsalary() {
        return salary;
    }

    public void setsalary(int salary) {
        this.salary = salary;
    }

    // 部門番号へのアクセサメソッド
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

    // ビル名へのアクセサメソッド
    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    // 階数へのアクセサメソッド
    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "EmployeeTO [employeeId=" + employeeId + ", employeeName="
                + employeeName + ", salary=" + salary
                + ", departmentId=" + departmentId + ", departmentName="
                + departmentName + ", buildingName=" + buildingName + ", floor="
                + floor + "]";
    }
}