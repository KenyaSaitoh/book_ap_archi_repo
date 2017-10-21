package jp.mufg.it.ee.jpa.company.test;

import org.junit.Test;

import jp.mufg.it.ee.jpa.company.entity.Employee;
import jp.mufg.it.ee.jpa.company.test.base.JpaTestBase;
import jp.mufg.it.ee.jpa.company.util.ResultUtil;

public class PessimisticWriteLockForceIncrementTest extends JpaTestBase {

    @Test
    public void test1() {
        System.out.println("[ test1 ] Start");

        Employee employee = em.find(Employee.class, 10001);

        // スリープしている間に、以下のいずれかを実行する
        // ①：PessimisticWriteLockConflicter
        // この場合は、単なる読み込みでありバージョン番号は更新されないため、このテストは成功する
        // ②：PessimisticWriteLockForceIncrementConflicter
        // この場合は、単なる読み込みであるにも関わらずバージョン番号が更新されるため、このテストは失敗（楽観的ロックエラー）する
        try {
            Thread.sleep(20000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        employee.setSalary(employee.getSalary() + 2000);
        commit();

        ResultUtil.showEmployee(employee);
        System.out.println("[ test1 ] End\n");
    }
}