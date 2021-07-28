package jp.mufg.it.ee.jpa.company.main;

import java.util.List;

import javax.persistence.FlushModeType;
import javax.persistence.Query;

import org.junit.Test;

import jp.mufg.it.ee.jpa.company.entity.Department;
import jp.mufg.it.ee.jpa.company.entity.Employee;

// フラッシュモードのテスト
@SuppressWarnings("unchecked")
public class JpaFlashModeMain extends JpaTestBase {

    // FlushModeType.AUTO
    @Test
    public void test1() {
        System.out.println("[ test1 ] Start");
        entityManager.setFlushMode(FlushModeType.AUTO);
        Employee employee = entityManager.find(Employee.class, 10013);
        Department department = entityManager.find(Department.class, 1);
        employee.setDepartment(department);
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "WHERE e.department.departmentId = 1");
        List<Employee> resultList = query.getResultList();
        commit();
        showEmployeeList(resultList);
        System.out.println("[ test1 End ]");
    }

    // FlushModeType.COMMIT
    @Test
    public void test2() {
        System.out.println("[ test2 ] Start");
        entityManager.setFlushMode(FlushModeType.COMMIT);
        Employee employee = entityManager.find(Employee.class, 10014);
        Department department = entityManager.find(Department.class, 2);
        employee.setDepartment(department);
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "WHERE e.department.departmentId = 2");
        List<Employee> resultList = query.getResultList();
        commit();
        showEmployeeList(resultList);
        System.out.println("[ test2 End ]");
    }

    private static void showEmployeeList(List<Employee> resultList) {
        for (Employee employee : resultList) {
            System.out.println(employee);
        }
    }
}