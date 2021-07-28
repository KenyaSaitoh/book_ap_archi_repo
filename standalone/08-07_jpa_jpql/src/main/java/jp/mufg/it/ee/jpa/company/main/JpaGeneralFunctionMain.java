package jp.mufg.it.ee.jpa.company.main;

import java.util.List;

import javax.persistence.Query;

import org.junit.Test;
import jp.mufg.it.ee.jpa.company.test.base.JpaTestBase;
import jp.mufg.it.ee.jpa.company.test.util.ResultUtil;

import jp.mufg.it.ee.jpa.company.entity.Department;
import jp.mufg.it.ee.jpa.company.entity.Employee;


// 機能関数のテスト
@SuppressWarnings("unchecked")
public class JpaGeneralFunctionMain extends JpaTestBase {

    // LENGTH
    @Test
    public void test1() {
        System.out.println("[ test1 ] Start");
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "WHERE 8 < LENGTH(e.employeeName)");
        List<Employee> resultList = query.getResultList();
        showEmployeeList(resultList);
        System.out.println("[ test1 End ]");
    }

    // SIZE
    @Test
    public void test2() {
        System.out.println("[ test2 ] Start");
        Query query = entityManager.createQuery(
                "SELECT d FROM Department AS d " +
                "WHERE SIZE(d.employees) = 3");
        List<Department> resultList = query.getResultList();
        showDepartmentList(resultList);
        System.out.println("[ test2 End ]");
    }

    // SUBSTRING
    @Test
    public void test3() {
        System.out.println("[ test3 ] Start");
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "WHERE SUBSTRING(e.employeeName, 2, 1) = 'か'");
        List<Employee> resultList = query.getResultList();
        showEmployeeList(resultList);
        System.out.println("[ test3 End ]");
    }

    private static void showEmployeeList(List<Employee> resultList) {
        for (Employee employee : resultList) {
            System.out.println(employee);
        }
    }
}