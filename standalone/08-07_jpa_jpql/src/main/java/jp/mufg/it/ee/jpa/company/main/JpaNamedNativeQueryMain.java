package jp.mufg.it.ee.jpa.company.main;

import java.util.List;

import javax.persistence.Query;

import org.junit.Test;
import jp.mufg.it.ee.jpa.company.entity.EmployeeQueryResult1;
import jp.mufg.it.ee.jpa.company.entity.EmployeeQueryResult2;
import jp.mufg.it.ee.jpa.company.test.base.JpaTestBase;

import jp.mufg.it.ee.jpa.company.entity.Employee;


// 名前付きクエリのテスト
public class JpaNamedNativeQueryMain extends JpaTestBase {

    // 名前付きクエリで結果クラスを使用
    @Test
    public void test1() {
        System.out.println("[ test1 ] Start");
        Query query = entityManager.createNamedQuery("findEmployeesByDepartmentId1")
                .setParameter(1, 10006); // EMPLOYEE_IDに10006をセットする
        EmployeeQueryResult1 employee =
                (EmployeeQueryResult1)query.getSingleResult();
        System.out.println("employeeId ---> " + employee.getEmployeeId());
        System.out.println("employeeName ---> "
                + employee.getEmployeeName());
        System.out.println("departmentName ---> "
                + employee.getDepartmentName());
        System.out.println("[ test1 End ]");
    }

    // 名前付きクエリで結果セットマッピングを使用
    @Test
    public void test2() {
        System.out.println("[ test2 ] Start");
        Query query = entityManager.createNamedQuery("findEmployeesByDepartmentId2")
                .setParameter(1, 10006); // EMPLOYEE_IDに10006をセットする
        EmployeeQueryResult2 employee =
                (EmployeeQueryResult2)query.getSingleResult();
        System.out.println("employeeId ---> " + employee.getEmployeeId());
        System.out.println("employeeName ---> "
                + employee.getEmployeeName());
        System.out.println("departmentName ---> "
                + employee.getDepartmentName());
        System.out.println("[ test2 End ]");
    }

    private static void showEmployeeList(List<Employee> resultList) {
        for (Employee employee : resultList) {
            System.out.println(employee);
        }
    }
}