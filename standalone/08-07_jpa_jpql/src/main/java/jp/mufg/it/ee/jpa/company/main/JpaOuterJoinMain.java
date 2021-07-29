package jp.mufg.it.ee.jpa.company.main;

import java.util.List;

import javax.persistence.Query;

import org.junit.Test;
import jp.mufg.it.ee.jpa.company.test.base.JpaTestBase;
import jp.mufg.it.ee.jpa.company.test.util.ResultUtil;

import jp.mufg.it.ee.jpa.company.entity.Employee;


//外部結合（アウタージョイン）のテスト
@SuppressWarnings("unchecked")
public class JpaOuterJoinMain extends JpaTestBase {

    // 外部結合（アウタージョイン）1
    @Test
    public void test1() {
        System.out.println("===== TEST1 START =====");
        Query query = entityManager.createQuery(
                "SELECT e.employeeId, e.employeeName, d.departmentName " +
                "FROM Employee AS e LEFT OUTER JOIN e.department AS d");
        List<Object[]> resultList = query.getResultList();
        showObjectArrayList(resultList);
        System.out.println("===== TEST1 END =====\n");
    }

    // 外部結合（アウタージョイン）2
    @Test
    public void test2() {
        System.out.println("===== TEST2 START =====");
        Query query = entityManager.createQuery(
                "SELECT e.employeeId, e.employeeName, d.departmentName " +
                "FROM Department AS d LEFT OUTER JOIN d.employees AS e");
        List<Object[]> resultList = query.getResultList();
        showObjectArrayList(resultList);
        System.out.println("===== TEST2 END =====\n");
    }

    private static void showEmployeeList(List<Employee> resultList) {
        for (Employee employee : resultList) {
            System.out.println(employee);
        }
    }
}