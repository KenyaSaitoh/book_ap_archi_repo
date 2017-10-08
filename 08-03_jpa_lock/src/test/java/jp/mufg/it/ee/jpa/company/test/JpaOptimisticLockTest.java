package jp.mufg.it.ee.jpa.company.test;

import javax.persistence.OptimisticLockException;

import org.junit.Test;

import jp.mufg.it.ee.jpa.company.entity.Employee;
import jp.mufg.it.ee.jpa.company.test.base.JpaTestBase;

// 楽観的ロックのテスト
public class JpaOptimisticLockTest extends JpaTestBase {

    @Test
    public void test1() {
        System.out.println("[ test1 ] Start");
        Employee employee = em.find(Employee.class, 10010);
        employee.setSalary(employee.getSalary() + 10000);
        try {
            Thread.sleep(20000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            em.flush();
        } catch(OptimisticLockException ole) {
            throw ole;
            // リカバリ
        }
        commit();
        System.out.println("[ test1 ] End\n");
    }
}