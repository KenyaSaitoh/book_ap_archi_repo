package jp.mufg.it.ee.jpa.company.test;

import java.util.List;

import javax.persistence.OptimisticLockException;

import org.junit.Test;

import jp.mufg.it.ee.jpa.company.entity.Department;
import jp.mufg.it.ee.jpa.company.entity.Employee;
import jp.mufg.it.ee.jpa.company.test.base.JpaTestBase;

public class JpaCascadeOptimisticLockTest extends JpaTestBase {

    @Test
    public void test1() {
        System.out.println("##### TEST1 START #####");

        Department department = entityManager.find(Department.class, 1);
        List<Employee> employees = department.getEmployees();
        Employee employee = employees.get(0);
        employee.setSalary(510000);

        entityManager.clear();
        entityManager.merge(department);

        try {
            Thread.sleep(20000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            // 親をマージした場合、カスケードされて子が更新されると、
            // 子の楽観ロックは有効に作用する
            entityManager.flush();
        } catch(OptimisticLockException ole) {
            throw ole;
            // リカバリ
        }
        commit();
        System.out.println("##### TEST1 ]");
    }
}