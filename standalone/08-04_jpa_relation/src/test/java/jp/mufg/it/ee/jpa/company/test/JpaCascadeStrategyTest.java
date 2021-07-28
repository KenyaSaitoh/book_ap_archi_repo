package jp.mufg.it.ee.jpa.company.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.Test;

import jp.mufg.it.ee.jpa.company.entity.Department;
import jp.mufg.it.ee.jpa.company.entity.Employee;
import jp.mufg.it.ee.jpa.company.test.base.JpaTestBase;
import jp.mufg.it.ee.jpa.company.type.JobType;

// カスケードのテスト
public class JpaCascadeStrategyTest extends JpaTestBase {

    // persist操作（INSERT）、Many側からカスケード
    @Test
    public void test1() {
        System.out.println("[ test1 ] Start");
        List<Employee> employees = new ArrayList<Employee>();
        Department department = new Department(5, "総務部", "東京本社",
                employees, 0L);
        Calendar cal = Calendar.getInstance();
        cal.set(2017, 10, 1);
        Employee employee = new Employee(10015, "Steve", department,
                new Date(cal.getTimeInMillis()),  JobType.LEADER, 380000, 0L);
        department.getEmployees().add(employee);
        entityManager.persist(employee);
        commit();
        System.out.println("[ test1 ]");
    }

    // persist操作（INSERT）、One側からカスケード
    @Test
    public void test2() {
        System.out.println("[ test2 ] Start");
        List<Employee> employees = new ArrayList<Employee>();
        Department department = new Department(6, "品質管理部", "東京本社",
                employees, 0L);
        Calendar cal = Calendar.getInstance();
        cal.set(2017, 11, 1);
        Employee employee = new Employee(10022, "Trent", department,
                new Date(cal.getTimeInMillis()), JobType.CHIEF, 310000, 0L);
        department.getEmployees().add(employee);
        entityManager.persist(department);
        commit();
        System.out.println("[ test2 ]");
    }

    // remove操作（DELETE）
    @Test
    public void test3() {
        System.out.println("[ test3 ] Start");
        Department department = entityManager.find(Department.class, 5);
        entityManager.remove(department);
        commit();
        System.out.println("[ test3 ]");
    }

    // remove操作（DELETE）
    @Test
    public void test4() {
        System.out.println("[ test4 ] Start");
        Employee employee = entityManager.find(Employee.class, 10001);
        entityManager.remove(employee);
        commit();
        System.out.println("[ test4 ]");
    }

    // merge操作（UPDATE）
    @Test
    public void test5() {
        System.out.println("[ test5 ] Start");
        Employee employee = entityManager.find(Employee.class, 10012);
        Department department = employee.getDepartment();
        entityManager.clear();  // mergeのテストのために、取得したエンティティオブジェクトを意図的にDETACHED状態にする
        employee.setSalary(500000);
        department.setLocation("品川支社"); // もともとは東京本社
        employee.setDepartment(department);
        entityManager.merge(employee);
        commit();
        System.out.println("[ test5 ]");
    }

    // refresh操作
    @Test
    public void test6() {
        System.out.println("[ test6 ] Start");
        Employee employee = entityManager.find(Employee.class, 10002);
        Department department = employee.getDepartment();
        employee.setSalary(999999);
        department.setDepartmentName("経営企画部"); // もともとは企画部
        entityManager.refresh(employee);
        commit();
        System.out.println("[ test6 ]");
    }
}