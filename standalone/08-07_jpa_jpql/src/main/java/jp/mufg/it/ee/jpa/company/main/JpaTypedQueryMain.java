package jp.mufg.it.ee.jpa.company.main;

import java.util.Calendar;
import java.util.List;

import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import org.junit.Test;
import jp.mufg.it.ee.jpa.company.test.base.JpaTestBase;
import jp.mufg.it.ee.jpa.company.test.util.ResultUtil;

import jp.mufg.it.ee.jpa.company.entity.Department;
import jp.mufg.it.ee.jpa.company.entity.Employee;

// クエリのテスト
public class JpaTypedQueryMain extends JpaTestBase {

    // 全カラムを指定
    @Test
    public void test1() {
        System.out.println("[ test1 ] Start");
        TypedQuery<Employee> query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "WHERE :lower <= e.salary AND e.salary <= :upper",
                Employee.class)
                .setParameter("lower", 300000)
                .setParameter("upper", 400000);
        List<Employee> resultList = query.getResultList();
        showEmployeeList(resultList);

        System.out.println("[ test1 End ]");
    }

    // カラムを限定
    @Test
    public void test2() {
        System.out.println("[ test2 ] Start");
        TypedQuery<Object[]> query = entityManager.createQuery(
                "SELECT e.employeeId, e.employeeName, e.salary " +
                "FROM Employee AS e " +
                "WHERE :lower <= e.salary AND e.salary <= :upper",
                Object[].class)
                .setParameter("lower", 300000)
                .setParameter("upper", 400000);
        List<Object[]> resultList = query.getResultList();
        showObjectArrayList(resultList);
        System.out.println("[ test2 End ]");
    }

    // 関連を持っている別のエンティティオブジェクトを条件に指定
    @Test
    public void test3() {
        System.out.println("[ test3 ] Start");
        Department department = entityManager.find(Department.class, 3);
        TypedQuery<Employee> query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "WHERE e.department = :department",
                Employee.class)
                .setParameter("department", department);
        List<Employee> resultList = query.getResultList();
        showEmployeeList(resultList);
        System.out.println("[ test3 End ]");
    }

    // 時間型の永続フィールドを条件に指定
    @Test
    public void test4() {
        System.out.println("[ test4 ] Start");
        Calendar entranceDate = Calendar.getInstance();
        entranceDate.set(2003, 3, 1);
        TypedQuery<Employee> query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "WHERE e.entranceDate = :entranceDate", Employee.class)
                .setParameter("entranceDate", entranceDate, TemporalType.DATE);
        List<Employee> resultList = query.getResultList();
        showEmployeeList(resultList);
        System.out.println("[ test4 End ]");
    }

    private static void showEmployeeList(List<Employee> resultList) {
        for (Employee employee : resultList) {
            System.out.println(employee);
        }
    }
}