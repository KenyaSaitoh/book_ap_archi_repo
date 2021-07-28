package jp.mufg.it.ee.jpa.company.main;

import java.util.List;

import javax.persistence.Query;

import org.junit.Test;
import jp.mufg.it.ee.jpa.company.test.base.JpaTestBase;
import jp.mufg.it.ee.jpa.company.test.util.ResultUtil;

import jp.mufg.it.ee.jpa.company.entity.Employee;


// 内部結合のテスト
@SuppressWarnings("unchecked")
public class JpaInnerJoinMain extends JpaTestBase {

    // SINGLE RESULT
    @Test
    public void test1() {
        System.out.println("[ test1 ] Start");
        Query query = entityManager.createQuery(
                "SELECT e.employeeId, e.employeeName, d.departmentName " +
                "FROM Employee AS e INNER JOIN e.department AS d " +
                "WHERE e.employeeId = :employeeId")
                .setParameter("employeeId", 10005);
        Object[] objs = (Object[])query.getSingleResult();
        showObjectArray(objs);
        System.out.println("[ test1 End ]");
    }

    // LIST RESULT 1
    @Test
    public void test2() {
        System.out.println("[ test2 ] Start");
        Query query = entityManager.createQuery(
                "SELECT e.employeeId, e.employeeName, d.departmentName " +
                "FROM Employee AS e INNER JOIN e.department AS d " +
                "WHERE d.departmentId = :departmentId")
                .setParameter("departmentId", 2);
        List resultList = query.getResultList();
        showObjectArrayList(resultList);
        System.out.println("[ test2 End ]");
    }

    // LIST RESULT 2
    @Test
    public void test3() {
        System.out.println("[ test3 ] Start");
        Query query = entityManager.createQuery(
                "SELECT e.employeeId, e.employeeName, d.departmentName " +
                "FROM Department AS d INNER JOIN d.employees AS e " +
                "WHERE d.departmentId = :departmentId")
                .setParameter("departmentId", 2);
        List resultList = query.getResultList();
        showObjectArrayList(resultList);
        System.out.println("[ test3 End ]");
    }

    // IN OPERATOR
    // Hibernateではエラーになる。
    @Test
    public void test4() {
        System.out.println("[ test4 ] Start");
        Query query = entityManager.createQuery(
                "SELECT e.employeeId, e.employeeName, d.departmentName " +
                "FROM Department AS d, IN (d.employees) AS e " +
                "WHERE d.departmentId = :departmentId")
                .setParameter("departmentId", 2);
        List resultList = query.getResultList();
        showObjectArrayList(resultList);
        System.out.println("[ test4 End ]");
    }

    private static void showEmployeeList(List<Employee> resultList) {
        for (Employee employee : resultList) {
            System.out.println(employee);
        }
    }
}