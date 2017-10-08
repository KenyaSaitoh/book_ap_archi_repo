package jp.mufg.it.ee.jpa.company.test;

import javax.persistence.LockModeType;

import org.junit.Test;

import jp.mufg.it.ee.jpa.company.entity.Employee;
import jp.mufg.it.ee.jpa.company.test.base.JpaTestBase;
import jp.mufg.it.ee.jpa.company.util.ResultUtil;

public class PessimisticReadLockTest extends JpaTestBase {

    @Test
    public void test1() {
        System.out.println("[ test1 ] Start");

        Employee employee = em.find(Employee.class, 10001,
                LockModeType.PESSIMISTIC_READ);
        System.out.println(employee);
        commit();

        ResultUtil.showEmployee(employee);
        System.out.println("[ test1 ] End\n");
    }
}