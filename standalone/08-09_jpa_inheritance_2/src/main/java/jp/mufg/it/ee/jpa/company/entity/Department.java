package jp.mufg.it.ee.jpa.company.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTMENT")
public class Department {
    private Integer departmentId;
    private String departmentName;
    private String buildingName;
    private Integer floor;
    private List<Employee> employees = new ArrayList<Employee>();

    // 引数なしのコンストラクタ
    public Department() {
    }

    // コンストラクタ
    public Department(Integer departmentId, String departmentName,
            String buildingName, Integer floor, List<Employee> employees) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.buildingName = buildingName;
        this.floor = floor;
        this.employees = employees;
    }

    // 部署IDへのアクセサメソッド
    @Id
    @Column(name = "DEPARTMENT_ID")
    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    // 部署名へのアクセサメソッド
    @Column(name = "DEPARTMENT_NAME")
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    // ビル名へのアクセサメソッド
    @Column(name = "BUILDING_NAME")
    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    // 階数へのアクセサメソッド
    @Column(name = "FLOOR")
    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    // 社員のリストへのアクセサメソッド
    @OneToMany(targetEntity = Employee.class,
            mappedBy = "department")
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department [departmentId=" + departmentId + ", departmentName="
                + departmentName + ", buildingName=" + buildingName + ", floor="
                + floor + ", employees=" + employees + "]";
    }
}