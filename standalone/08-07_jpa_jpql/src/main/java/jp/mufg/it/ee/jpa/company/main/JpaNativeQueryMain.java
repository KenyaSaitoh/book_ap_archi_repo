package jp.mufg.it.ee.jpa.company.main;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.persistence.Query;

import org.junit.Test;
import jp.mufg.it.ee.jpa.company.entity.EmployeeQueryResult1;
import jp.mufg.it.ee.jpa.company.entity.EmployeeQueryResult2;
import jp.mufg.it.ee.jpa.company.test.base.JpaTestBase;

import jp.mufg.it.ee.jpa.company.entity.Employee;


// ネイティブクエリのテスト
@SuppressWarnings("unchecked")
public class JpaNativeQueryMain extends JpaTestBase {

    // NATIVE QUERY 1
    @Test
    public void test1() {
        System.out.println("[ test1 ] Start");
        Query query = entityManager.createNativeQuery(
                "SELECT EMPLOYEE_NAME FROM EMPLOYEE " +
                "WHERE EMPLOYEE_ID = ?1")
                .setParameter(1, 10001);
        Object obj = (Object)query.getSingleResult();
        System.out.println(obj);
        System.out.println("[ test1 End ]");
    }

    // NATIVE QUERY 2
    @Test
    public void test2() {
        System.out.println("[ test2 ] Start");
        Query query = entityManager.createNativeQuery(
                "SELECT EMPLOYEE_NAME FROM EMPLOYEE " +
                "WHERE DEPARTMENT_ID = ?1")
                .setParameter(1, 2);
        List<Object> resultList = (List<Object>)query.getResultList();
        Iterator<Object> i = resultList.iterator();
        while (i.hasNext()) {
            Object obj = i.next();
            System.out.println(obj);
        }
        System.out.println("[ test2 End ]");
    }

    // NATIVE QUERY 3
    @Test
    public void test3() {
        System.out.println("[ test3 ] Start");
        Query query = entityManager.createNativeQuery(
                "SELECT EMPLOYEE_NAME, MONTHLY_SALARY FROM EMPLOYEE " +
                "WHERE EMPLOYEE_ID = ?1")
                .setParameter(1, 10001);
        Object value = query.getSingleResult();
        if (value instanceof Vector) {
            // EclipseLinkの場合
            Vector vec = (Vector)value;
            System.out.println(vec.get(0) + " / " + vec.get(1));
        } else {
            // Hibernateの場合
            Object[] objs = (Object[])value;
            System.out.println(objs[0] + " / " + objs[1]);
        }
        System.out.println("[ test3 End ]");
    }

    // NATIVE QUERY 4
    @Test
    public void test4() {
        System.out.println("[ test4 ] Start");
        Query query = entityManager.createNativeQuery(
                "SELECT EMPLOYEE_NAME, MONTHLY_SALARY FROM EMPLOYEE " +
                "WHERE DEPARTMENT_ID = ?1")
                .setParameter(1, 2);
        List resultList = (List)query.getResultList();
        Iterator i = resultList.iterator();
        while (i.hasNext()) {
            Object value = i.next();
            if (value instanceof Vector) {
                // EclipseLinkの場合
                Vector vec = (Vector)value;
                System.out.println(vec.get(0) + " / " + vec.get(1));
            } else {
                // Hibernateの場合
                Object[] objs = (Object[])value;
                System.out.println(objs[0] + " / " + objs[1]);
            }
        }
        System.out.println("[ test4 End ]");
    }

    // NATIVE QUERY 5
    @Test
    public void test5() {
        System.out.println("[ test5 ] Start");
        Query query = entityManager.createNativeQuery(
                "UPDATE EMPLOYEE " +
                "SET MONTHLY_SALARY = MONTHLY_SALARY + ?3 " +
                "WHERE DEPARTMENT_ID = ?1")
                .setParameter(3, 2000)
                .setParameter(1, 2);
        int updateCount = query.executeUpdate();
        System.out.println("ヒット件数 ---> " + updateCount);
        System.out.println("[ test5 End ]");
    }

    // SQL RESULT CLASS
    @Test
    public void test6() {
        System.out.println("[ test6 ] Start");
        Query query = entityManager.createNativeQuery(
                "SELECT e.EMPLOYEE_ID AS E_EMPLOYEE_ID, " +
                "e.EMPLOYEE_NAME AS E_EMPLOYEE_NAME, " +
                "d.DEPARTMENT_NAME AS D_DEPARTMENT_NAME " +
                "FROM EMPLOYEE e, DEPARTMENT d " +
                "WHERE e.DEPARTMENT_ID = d.DEPARTMENT_ID " +
                "AND e.EMPLOYEE_ID = ?1",
                EmployeeQueryResult1.class)
                .setParameter(1, 10006);
        List<EmployeeQueryResult1> resultList = query.getResultList();
        // 検索結果を標準出力する
        Iterator i = resultList.iterator();
        EmployeeQueryResult1 employee = (EmployeeQueryResult1)i.next();
        System.out.println("employeeId ---> " + employee.getEmployeeId());
        System.out.println("employeeName ---> "
                + employee.getEmployeeName());
        System.out.println("departmentName ---> "
                + employee.getDepartmentName());
        System.out.println("[ test6 End ]");
    }

    // SQL RESULT SET MAPPING 1
    @Test
    public void test7() {
        System.out.println("[ test7 ] Start");
        // ネイティブクエリを生成する
        Query query = entityManager.createNativeQuery(
                "SELECT e.EMPLOYEE_ID AS E_EMPLOYEE_ID, " +
                "e.EMPLOYEE_NAME AS E_EMPLOYEE_NAME, " +
                "d.DEPARTMENT_NAME AS D_DEPARTMENT_NAME, " +
                "e.MONTHLY_SALARY AS E_MONTHLY_SALARY, " +
                "d.BUILDING_NAME AS D_BUILDING_NAME " +
                "FROM EMPLOYEE e, DEPARTMENT d " +
                "WHERE e.DEPARTMENT_ID = d.DEPARTMENT_ID " +
                "AND e.EMPLOYEE_ID = ?1",
                "NativeQueryResult1")
                .setParameter(1, 10006); // EMPLOYEE_IDに10006をセットする
        List<Object[]> resultList = (List<Object[]>)query.getResultList();
        // 検索結果を標準出力する
        Iterator i = resultList.iterator();
        EmployeeQueryResult2 employee = (EmployeeQueryResult2)i.next();
        System.out.println("employeeId ---> " + employee.getEmployeeId());
        System.out.println("employeeName ---> "
                + employee.getEmployeeName());
        System.out.println("departmentName ---> "
                + employee.getDepartmentName());
        System.out.println("[ test7 End ]");
    }

    // SQL RESULT SET MAPPING 2
    @Test
    public void test8() {
        System.out.println("[ test8 ] Start");
        // ネイティブクエリを生成する
        Query query = entityManager.createNativeQuery(
                "SELECT e.MONTHLY_SALARY AS E_MONTHLY_SALARY, " +
                "d.BUILDING_NAME AS D_BUILDING_NAME " +
                "FROM EMPLOYEE e, DEPARTMENT d " +
                "WHERE e.DEPARTMENT_ID = d.DEPARTMENT_ID " +
                "AND e.EMPLOYEE_ID = ?1",
                "NativeQueryResult2")
                .setParameter(1, 10006);  // EMPLOYEE_IDに10006をセットする
        List<Object[]> resultList = (List<Object[]>)query.getResultList();
        // 検索結果を標準出力する
        Iterator i = resultList.iterator();
        Object[] objs = (Object[])i.next();
        System.out.println("salary ---> " + objs[0]);
        System.out.println("buildingName ---> " + objs[1]);
        System.out.println("[ test8 End ]");
    }

    // SQL RESULT SET MAPPING 3
    @Test
    public void test9() {
        System.out.println("[ test9 ] Start");
        // ネイティブクエリを生成する
        Query query = entityManager.createNativeQuery(
                "SELECT e.EMPLOYEE_ID AS E_EMPLOYEE_ID, " +
                "e.EMPLOYEE_NAME AS E_EMPLOYEE_NAME, " +
                "d.DEPARTMENT_NAME AS D_DEPARTMENT_NAME, " +
                "e.MONTHLY_SALARY AS E_MONTHLY_SALARY, " +
                "d.BUILDING_NAME AS D_BUILDING_NAME " +
                "FROM EMPLOYEE e, DEPARTMENT d " +
                "WHERE e.DEPARTMENT_ID = d.DEPARTMENT_ID " +
                "AND e.EMPLOYEE_ID = ?1",
                "NativeQueryResult3")
                .setParameter(1, 10006);  // EMPLOYEE_IDに10006をセットする
        List<Object[]> resultList = (List<Object[]>)query.getResultList();
        // 検索結果を標準出力する
        Iterator i = resultList.iterator();
        while (i.hasNext()) {
            Object[] objs = (Object[])i.next();
            EmployeeQueryResult2 employee = (EmployeeQueryResult2)objs[0];
            System.out.println("employeeId ---> " + employee.getEmployeeId());
            System.out.println("employeeName ---> "
                    + employee.getEmployeeName());
            System.out.println("departmentName ---> "
                    + employee.getDepartmentName());
            System.out.println("salary ---> " + objs[1]);
            System.out.println("buildingName ---> " + objs[2]);
        }
        System.out.println("[ test9 End ]");
    }

    private static void showEmployeeList(List<Employee> resultList) {
        for (Employee employee : resultList) {
            System.out.println(employee);
        }
    }
}