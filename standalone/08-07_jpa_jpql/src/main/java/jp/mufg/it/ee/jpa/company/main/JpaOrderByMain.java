package jp.mufg.it.ee.jpa.company.main;

import java.util.List;

import javax.persistence.Query;

import org.junit.Test;
import jp.mufg.it.ee.jpa.company.test.base.JpaTestBase;
import jp.mufg.it.ee.jpa.company.test.util.ResultUtil;

import jp.mufg.it.ee.jpa.company.entity.Employee;


// ソート（ORDER BY）のテスト
@SuppressWarnings("unchecked")
public class JpaOrderByMain extends JpaTestBase {

    // ソート（ORDER BY） 1
    @Test
    public void test1() {
        System.out.println("[ test1 ] Start");
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "ORDER BY e.department.departmentId");
        List<Employee> resultList = query.getResultList();
        showEmployeeList2(resultList);
        System.out.println("[ test1 End ]");
    }

    // ソート（ORDER BY） 2
    @Test
    public void test2() {
        System.out.println("[ test2 ] Start");
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "ORDER BY e.department.departmentId, e.salary");
        List<Employee> resultList = query.getResultList();
        showEmployeeList2(resultList);
        System.out.println("[ test2 End ]");
    }

    // ソート（ORDER BY） 3
    @Test
    public void test3() {
        System.out.println("[ test3 ] Start");
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "ORDER BY e.salary DESC")
                .setFirstResult(4)
                .setMaxResults(3);
        List<Employee> resultList = query.getResultList();
        showEmployeeList2(resultList);
        System.out.println("[ test3 End ]");
    }

    private static void showEmployeeList(List<Employee> resultList) {
        for (Employee employee : resultList) {
            System.out.println(employee);
        }
    }
}