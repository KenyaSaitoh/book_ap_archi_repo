package jp.mufg.it.ee.jpa.company.test;

import javax.persistence.LockModeType;
import javax.persistence.OptimisticLockException;

import org.junit.Test;

import jp.mufg.it.ee.jpa.company.entity.Employee;
import jp.mufg.it.ee.jpa.company.test.base.JpaTestBase;

// 楽観的ロックのテスト
public class JpaOptimisticLockModeTypeTest extends JpaTestBase {

    @Test
    public void test1() {
        System.out.println("[ test1 ] Start");

        // 以下のいずれは、どれも同じ動きをする模様
        // Employee employee = em.find(Employee.class, 10016);
        Employee employee = em.find(Employee.class, 10010,
                LockModeType.OPTIMISTIC);
        // Employee employee = em.find(Employee.class, 10016,
        //        LockModeType.OPTIMISTIC_FORCE_INCREMENT);

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