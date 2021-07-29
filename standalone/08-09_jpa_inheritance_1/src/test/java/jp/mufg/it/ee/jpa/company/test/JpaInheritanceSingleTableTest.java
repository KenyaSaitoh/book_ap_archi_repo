package jp.mufg.it.ee.jpa.company.test;

import java.util.Calendar;
import java.util.Date;
import org.junit.Test;

import jp.mufg.it.ee.jpa.company.entity.Department;
import jp.mufg.it.ee.jpa.company.entity.Fulltimer;
import jp.mufg.it.ee.jpa.company.entity.Parttimer;
import jp.mufg.it.ee.jpa.company.test.base.JpaTestBase;
import jp.mufg.it.ee.jpa.company.test.util.ResultUtil;

// Single Table per Class Hierarchy戦略のテスト
public class JpaInheritanceSingleTableTest extends JpaTestBase {

    // フルタイマーを検索 → 更新
    @Test
    public void test1() {
        System.out.println("===== TEST1 START =====");
        Fulltimer fulltimer = entityManager.find(Fulltimer.class, 10015);
        fulltimer.setsalary(fulltimer.getsalary() + 5000);
        commit();
        ResultUtil.showStaff(fulltimer);
        System.out.println("===== TEST1 ]");
    }

    // パートタイマーを検索 → 更新
    @Test
    public void test2() {
        System.out.println("===== TEST2 START =====");
        Parttimer parttimer = entityManager.find(Parttimer.class, 20004);
        parttimer.setParttimerPayment(parttimer.getParttimerPayment() + 200);
        commit();
        ResultUtil.showParttimer(parttimer);
        System.out.println("===== TEST2 ]");
    }

    // パートタイマーを挿入
    @Test
    public void test3() {
        System.out.println("===== TEST3 START =====");
        Department department = entityManager.find(Department.class, 5);
        Calendar cal = Calendar.getInstance();
        cal.set(2009, 3, 1);
        Parttimer parttimer = new Parttimer(20011, "まつだ あゆみ", department,
                new Date(cal.getTimeInMillis()), 1500);
        entityManager.persist(parttimer);
        commit();
        ResultUtil.showParttimer(parttimer);
        System.out.println("===== TEST3 ]");
    }
}