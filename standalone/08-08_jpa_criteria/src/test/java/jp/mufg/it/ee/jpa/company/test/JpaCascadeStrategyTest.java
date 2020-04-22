package jp.mufg.it.ee.jpa.company.test;

import java.util.ArrayList;
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
        Department department =
                new Department(5, "総務部", "東京本社",  employees, 0L);
        Employee employee =
                new Employee(10051, "Steve", department, new Date(),
                        JobType.LEADER, 380000, 0L);
        department.getEmployees().add(employee);
        em.persist(employee);
        commit();
        System.out.println("[ test1 ] End\n");
    }

    // persist操作（INSERT）、One側からカスケード
    @Test
    public void test2() {
        System.out.println("[ test2 ] Start");
        List<Employee> employees = new ArrayList<Employee>();
        Department department =
                new Department(6, "管理部", "東京本社", employees, 0L);
        Employee employee =
                new Employee(10052, "Trent", department, new Date(),
                        JobType.CHIEF, 310000, 0L);
        department.getEmployees().add(employee);
        em.persist(department);
        commit();
        System.out.println("[ test2 ] End\n");
    }

    // remove操作（DELETE）
    @Test
    public void test3() {
        System.out.println("[ test3 ] Start");
        Department department = em.find(Department.class, 5);
        em.remove(department);
        commit();
        System.out.println("[ test3 ] End\n");
    }

    // remove操作（DELETE）
    @Test
    public void test4() {
        System.out.println("[ test4 ] Start");
        Employee employee = em.find(Employee.class, 10001);
        em.remove(employee);
        commit();
        System.out.println("[ test4 ] End\n");
    }

    // merge操作（UPDATE）
    @Test
    public void test5() {
        System.out.println("[ test5 ] Start");
        Employee employee = em.find(Employee.class, 10012);
        Department department = employee.getDepartment();
        em.clear();  // mergeのテストのために、取得したエンティティオブジェクトを意図的にDETACHED状態にする
        employee.setSalary(500000);
        department.setLocation("品川支社"); // もともとは東京本社
        employee.setDepartment(department);
        em.merge(employee);
        commit();
        System.out.println("[ test5 ] End\n");
    }

    // refresh操作
    @Test
    public void test6() {
        System.out.println("[ test6 ] Start");
        Employee employee = em.find(Employee.class, 10002);
        Department department = employee.getDepartment();
        employee.setSalary(999999);
        department.setDepartmentName("経営企画部"); // もともとは企画部
        em.refresh(employee);
        commit();
        System.out.println("[ test6 ] End\n");
    }
}