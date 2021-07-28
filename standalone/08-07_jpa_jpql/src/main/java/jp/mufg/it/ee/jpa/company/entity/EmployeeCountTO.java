package jp.mufg.it.ee.jpa.company.entity;

public class EmployeeCountTO {
    private int departmentId;
    private Long employeeCount;

    // 引数なしのコンストラクタ
    public EmployeeCountTO() {
    }

    // コンストラクタ
    public EmployeeCountTO(int departmentId, Long employeeCount) {
        this.departmentId = departmentId;
        this.employeeCount = employeeCount;
    }

    // 部署名へのアクセサメソッド
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    // 所属社員数へのアクセサメソッド
    public Long getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(Long employeeCount) {
        this.employeeCount = employeeCount;
    }
}