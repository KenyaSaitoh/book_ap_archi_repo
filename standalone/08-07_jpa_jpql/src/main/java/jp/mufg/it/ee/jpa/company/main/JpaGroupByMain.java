package jp.mufg.it.ee.jpa.company.main;

import java.util.List;

import javax.persistence.Query;

import org.junit.Test;
import jp.mufg.it.ee.jpa.company.entity.EmployeeCountTO;
import jp.mufg.it.ee.jpa.company.test.base.JpaTestBase;
import jp.mufg.it.ee.jpa.company.test.util.ResultUtil;

import jp.mufg.it.ee.jpa.company.entity.Employee;


// グルーピングのテスト
@SuppressWarnings("unchecked")
public class JpaGroupByMain extends JpaTestBase {

    // グルーピング 1
    @Test
    public void test1() {
        System.out.println("[ test1 ] Start");
        Query query = entityManager.createQuery(
                "SELECT e.department, COUNT(e) " +
                "FROM Employee AS e " +
                "GROUP BY e.department");
        List<Object[]> resultList = query.getResultList();
        showObjectArrayList(resultList);
        System.out.println("[ test1 End ]");
    }

    //  グルーピング 2
    @Test
    public void test2() {
        System.out.println("[ test2 ] Start");
        Query query = entityManager.createQuery(
                "SELECT e.department.departmentId, COUNT(e) " +
                "FROM Employee AS e " +
                "GROUP BY e.department.departmentId");
        List<Object[]> resultList = query.getResultList();
        showObjectArrayList(resultList);
        System.out.println("[ test2 End ]");
    }

    // グルーピング 3
    // Hibernateではエラーになる。
    @Test
    public void test3() {
        System.out.println("[ test3 ] Start");
        Query query = entityManager.createQuery(
                "SELECT NEW jp.mufg.it.ee.jpa.company.entity.EmployeeCountTO" +
                "(e.department.departmentId, COUNT(e)) " +
                "FROM Employee AS e " +
                "GROUP BY e.department.departmentId " +
                "HAVING COUNT(e.department.departmentId) <= 3");
        List<EmployeeCountTO> resultList = query.getResultList();
        showEmployeeCountTOList(resultList);
        System.out.println("[ test3 End ]");
    }

    // グルーピング 4
    @Test
    public void test4() {
        System.out.println("[ test4 ] Start");
        Query query = entityManager.createQuery(
                "SELECT e.department.departmentId, COUNT(e) " +
                "FROM Employee AS e " +
                "GROUP BY e.department.departmentId " +
                "HAVING COUNT(e.department.departmentId) <= 3");
        List<Object[]> resultList = query.getResultList();
        showObjectArrayList(resultList);
        System.out.println("[ test4 End ]");
    }

    private static void showEmployeeList(List<Employee> resultList) {
        for (Employee employee : resultList) {
            System.out.println(employee);
        }
    }
}