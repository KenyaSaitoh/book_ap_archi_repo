package jp.mufg.it.ee.jpa.company.main;

import java.util.List;

import javax.persistence.Query;

import org.junit.Test;
import jp.mufg.it.ee.jpa.company.test.base.JpaTestBase;
import jp.mufg.it.ee.jpa.company.test.util.ResultUtil;

import jp.mufg.it.ee.jpa.company.entity.Employee;


// 副問い合わせとEXISTS式のテスト
@SuppressWarnings("unchecked")
public class JpaSubQueryMain extends JpaTestBase {

    // 副問い合わせ
    @Test
    public void test1() {
        System.out.println("[ test1 ] Start");
        Query query = entityManager.createQuery(
                "SELECT e1 FROM Employee AS e1 " +
                "WHERE e1.salary >= " +
                "(SELECT AVG(e2.salary) FROM Employee AS e2)");
        List<Employee> resultList = query.getResultList();
        showEmployeeNameList(resultList);
        System.out.println("[ test1 End ]");
    }

    // 副問い合わせ + EXISTS式 1
    @Test
    public void test2() {
        System.out.println("[ test2 ] Start");
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "WHERE EXISTS " +
                "(SELECT d FROM Department AS d " +
                "WHERE d.employees = e AND d.departmentId = 5)");
        List<Employee> resultList = query.getResultList();
        showEmployeeNameList(resultList);
        System.out.println("[ test2 End ]");
    }

    // 副問い合わせ + EXISTS式 2
    @Test
    public void test3() {
        System.out.println("[ test3 ] Start");
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "WHERE EXISTS " +
                "(SELECT d FROM e.department AS d " +
                "WHERE d.departmentId = 5)");
        List<Employee> resultList = query.getResultList();
        showEmployeeNameList(resultList);
        System.out.println("[ test3 End ]");
    }

    // 副問い合わせ + NOT EXISTS式 1
    @Test
    public void test4() {
        System.out.println("[ test4 ] Start");
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "WHERE NOT EXISTS " +
                "(SELECT d FROM Department AS d " +
                "WHERE d.employees = e AND d.departmentId = 5)");
        List<Employee> resultList = query.getResultList();
        showEmployeeNameList(resultList);
        System.out.println("[ test4 End ]");
    }

    // 副問い合わせ + NOT EXISTS式 2
    @Test
    public void test5() {
        System.out.println("[ test5 ] Start");
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "WHERE NOT EXISTS " +
                "(SELECT d FROM e.department AS d " +
                "WHERE d.departmentId = 5)");
        List<Employee> resultList = query.getResultList();
        showEmployeeNameList(resultList);
        System.out.println("[ test5 End ]");
    }

    private static void showEmployeeList(List<Employee> resultList) {
        for (Employee employee : resultList) {
            System.out.println(employee);
        }
    }
}