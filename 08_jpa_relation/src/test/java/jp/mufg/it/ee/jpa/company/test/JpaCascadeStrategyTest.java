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
                new Department(7, "人事部", "日本橋第一ビル", 10, employees, 0);
        Employee employee =
                new Employee(10051, "てらだ てっぺい", department, new Date(),
                        JobType.MANAGER, 270000, 0);
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
                new Department(8, "管理部", "大手町ビル", 10, employees, 0);
        Employee employee =
                new Employee(10061, "おざき ゆういち", department, new Date(),
                        JobType.MANAGER, 270000, 0);
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
        Employee employee = em.find(Employee.class, 10014);
        Department department = employee.getDepartment();
        em.clear();  // mergeのテストのために、取得したエンティティオブジェクトを意図的にDETACHED状態にする
        employee.setMonthlySalary(500000);
        department.setBuildingName("日本橋第一ビル"); // もともとは日本橋第二ビル
        employee.setDepartment(department);
        em.merge(employee);
        commit();
        System.out.println("[ test5 ] End\n");
    }

    // refresh操作
    @Test
    public void test6() {
        System.out.println("[ test6 ] Start");
        Employee employee = em.find(Employee.class, 10016);
        Department department = employee.getDepartment();
        employee.setMonthlySalary(999999);
        department.setFloor(19);
        em.refresh(employee);
        commit();
        System.out.println("[ test6 ] End\n");
    }
}