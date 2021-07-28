package jp.mufg.it.ee.jpa.company.entity;

import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;

@Entity
@SqlResultSetMappings(value = {
@SqlResultSetMapping(name = "NativeQueryResult1",
        entities = {
            @EntityResult(
                    entityClass = EmployeeQueryResult2.class,
                    fields = {
                        @FieldResult(name = "employeeId",
                                column = "E_EMPLOYEE_ID"),
                        @FieldResult(name = "employeeName",
                                column = "E_EMPLOYEE_NAME"),
                        @FieldResult(name = "departmentName",
                                column = "D_DEPARTMENT_NAME")
                    }
            )
        }
),
@SqlResultSetMapping(name = "NativeQueryResult2",
        columns = {
            @ColumnResult(name = "E_MONTHLY_SALARY"),
            @ColumnResult(name = "D_BUILDING_NAME")
        }
),
@SqlResultSetMapping(name = "NativeQueryResult3",
        entities = {
            @EntityResult(
                    entityClass = EmployeeQueryResult2.class,
                    fields = {
                        @FieldResult(name = "employeeId",
                                column = "E_EMPLOYEE_ID"),
                        @FieldResult(name = "employeeName",
                                column = "E_EMPLOYEE_NAME"),
                        @FieldResult(name = "departmentName",
                                column = "D_DEPARTMENT_NAME")
                    }
            )
        },
        columns = {
            @ColumnResult(name = "E_MONTHLY_SALARY"),
            @ColumnResult(name = "D_BUILDING_NAME")
        }
)
})
@NamedNativeQuery(name = "findEmployeesByDepartmentId2",
        query = "SELECT e.EMPLOYEE_ID AS E_EMPLOYEE_ID, " +
                "e.EMPLOYEE_NAME AS E_EMPLOYEE_NAME, " +
                "d.DEPARTMENT_NAME AS D_DEPARTMENT_NAME, " +
                "e.MONTHLY_SALARY AS E_MONTHLY_SALARY, " +
                "d.BUILDING_NAME AS D_BUILDING_NAME " +
                "FROM EMPLOYEE e, DEPARTMENT d " +
                "WHERE e.DEPARTMENT_ID = d.DEPARTMENT_ID " +
                "AND e.EMPLOYEE_ID = ?1",
        resultSetMapping = "NativeQueryResult1")
public class EmployeeQueryResult2 {
    @Id
    private int employeeId;
    private String employeeName;
    private String departmentName;

    // 引数なしのコンストラクタ
    public EmployeeQueryResult2() {
    }

    // コンストラクタ
    public EmployeeQueryResult2(int employeeId, String employeeName,
            String departmentName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.departmentName = departmentName;
    }

    // 社員番号へのアクセサメソッド
    public int getEmployeeId() {
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
        return "EmployeeQueryResult2 [employeeId=" + employeeId
                + ", employeeName=" + employeeName + ", departmentName="
                + departmentName + "]";
    }
}