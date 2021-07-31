package jp.mufg.it.ee.jpa.company.entity;

public class EmpDept {
    private Integer employeeId;
    private String employeeName;
    private Integer salary;
    private Integer departmentId;
    private String departmentName;
    private String location;

    // 引数なしのコンストラクタ
    public EmpDept() {
    }

    // コンストラクタ
    public EmpDept(int employeeId, String employeeName,
            int salary, int departmentId, String departmentName,
            String location) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.location = location;
    }

    // 社員番号へのアクセサメソッド
    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    // 社員名へのアクセサメソッド
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    // 月給へのアクセサメソッド
    public Integer getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    // 部署番号へのアクセサメソッド
    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    // 部署名へのアクセサメソッド
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    // 所在地へのアクセサメソッド
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "EmployeeDepartment [" + employeeId + ", " + employeeName + ", "
                + salary + ", " + departmentId + ", " + departmentName + ", "
                + location + "]";
    }
}