package jp.mufg.it.ee.jpa.company.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "DEPARTMENT")
public class Department {
    private Integer departmentId;
    private String departmentName;
    private String buildingName;
    private Integer floor;
    private List<Employee> employees = new ArrayList<Employee>();
    private long version;

    // 引数なしのコンストラクタ
    public Department() {
    }

    // コンストラクタ
    public Department(Integer departmentId, String departmentName,
            String buildingName, Integer floor, List<Employee> employees,
            long version) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.buildingName = buildingName;
        this.floor = floor;
        this.employees = employees;
        this.version = version;
    }

    // 部署番号へのアクセサメソッド
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
            mappedBy = "department",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    // バージョン（楽観的ロックで使用）へのアクセサメソッド
    @Column(name = "VERSION")
    @Version
    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}