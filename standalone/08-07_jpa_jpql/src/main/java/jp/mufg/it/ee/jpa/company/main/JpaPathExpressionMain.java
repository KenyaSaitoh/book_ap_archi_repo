package jp.mufg.it.ee.jpa.company.main;

import java.util.List;

import javax.persistence.Query;

import org.junit.Test;
import jp.mufg.it.ee.jpa.company.test.base.JpaTestBase;
import jp.mufg.it.ee.jpa.company.test.util.ResultUtil;

import jp.mufg.it.ee.jpa.company.entity.Employee;


// パス式のテスト
public class JpaPathExpressionMain extends JpaTestBase {

    // パス式
    @Test
    public void test1() {
        System.out.println("===== TEST1 START =====");
        Query query = entityManager.createQuery(
                "SELECT e.employeeId, e.employeeName, " +
                "e.department.departmentName " +
                "FROM Employee AS e " +
                "WHERE e.employeeId = :employeeId")
                .setParameter("employeeId", 10006);
        Object[] objs = (Object[])query.getSingleResult();
        showObjectArray(objs);
        System.out.println("===== TEST1 END =====\n");
    }

    private static void showEmployeeList(List<Employee> resultList) {
        for (Employee employee : resultList) {
            System.out.println(employee);
        }
    }
}