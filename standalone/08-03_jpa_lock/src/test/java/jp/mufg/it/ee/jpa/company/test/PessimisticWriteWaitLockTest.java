package jp.mufg.it.ee.jpa.company.test;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.LockModeType;

import org.junit.Test;

import jp.mufg.it.ee.jpa.company.entity.Employee;
import jp.mufg.it.ee.jpa.company.test.base.JpaTestBase;
import jp.mufg.it.ee.jpa.company.util.ResultUtil;

public class PessimisticWriteWaitLockTest extends JpaTestBase {

    @Test
    public void test1() {
        System.out.println("[ test1 ] Start");

        Map<String, Object> props = new HashMap<String, Object>();
        props.put("javax.persistence.lock.timeout", 3000);

        Employee employee = em.find(Employee.class, 10001,
                LockModeType.PESSIMISTIC_WRITE, props);
        employee.setSalary(employee.getSalary() + 2000);
        commit();

        ResultUtil.showEmployee(employee);
        System.out.println("[ test1 ] End\n");
    }
}