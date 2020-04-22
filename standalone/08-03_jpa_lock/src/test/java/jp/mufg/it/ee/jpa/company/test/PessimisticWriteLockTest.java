package jp.mufg.it.ee.jpa.company.test;

import javax.persistence.LockModeType;

import org.junit.Test;

import jp.mufg.it.ee.jpa.company.entity.Employee;
import jp.mufg.it.ee.jpa.company.test.base.JpaTestBase;
import jp.mufg.it.ee.jpa.company.util.ResultUtil;

public class PessimisticWriteLockTest extends JpaTestBase {

    @Test
    public void test1() {
        System.out.println("[ test1 ] Start");

        Employee employee = em.find(Employee.class, 10001,
                LockModeType.PESSIMISTIC_WRITE);
        // 以下のようにして、後からロックをかけることもできる
        /*
        Employee employee = em.find(Employee.class, 10001);
        em.lock(employee, LockModeType.PESSIMISTIC_WRITE);
        */
        employee.setSalary(employee.getSalary() + 2000);
        commit();

        ResultUtil.showEmployee(employee);
        System.out.println("[ test1 ] End\n");
    }
}