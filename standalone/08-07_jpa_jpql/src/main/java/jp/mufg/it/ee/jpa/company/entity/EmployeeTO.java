package jp.mufg.it.ee.jpa.company.entity;

public class EmployeeTO {
    private Integer employeeId;
    private String employeeName;
    private String departmentName;

    // 引数なしのコンストラクタ
    public EmployeeTO() {
    }

    // コンストラクタ
    public EmployeeTO(int employeeId, String employeeName,
            String departmentName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.departmentName = departmentName;
    }

    // 社員番号へのアクセサメソッド
    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    // 社員名へのアクセサメソッド
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    // 部署名へのアクセサメソッド
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "EmployeeTO [" + employeeId + ", " + employeeName + ", "
                + departmentName + "]";
    }
}