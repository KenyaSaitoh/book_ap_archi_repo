package jp.mufg.it.ee.jpa.company.test;

import java.util.Calendar;
import java.util.Date;
import org.junit.Test;

import jp.mufg.it.ee.jpa.company.entity.Department;
import jp.mufg.it.ee.jpa.company.entity.Fulltimer;
import jp.mufg.it.ee.jpa.company.entity.Parttimer;
import jp.mufg.it.ee.jpa.company.test.base.JpaTestBase;
import jp.mufg.it.ee.jpa.company.test.util.ResultUtil;

// Joined Subclass戦略のテスト
public class JpaInheritanceJoinedTest extends JpaTestBase {

    // フルタイマーを検索 → 更新
    @Test
    public void test1() {
        System.out.println("[ test1 ] Start");
        Fulltimer fulltimer = em.find(Fulltimer.class, 10015);
        fulltimer.setsalary(fulltimer.getsalary() + 5000);
        commit();
        ResultUtil.showStaff(fulltimer);
        System.out.println("[ test1 ] End\n");
    }

    // パートタイマーを検索 → 更新
    @Test
    public void test2() {
        System.out.println("[ test2 ] Start");
        Parttimer parttimer = em.find(Parttimer.class, 20004);
        parttimer.setParttimerPayment(parttimer.getParttimerPayment() + 200);
        commit();
        ResultUtil.showParttimer(parttimer);
        System.out.println("[ test2 ] End\n");
    }

    // パートタイマーを挿入
    @Test
    public void test3() {
        System.out.println("[ test3 ] Start");
        Department department = em.find(Department.class, 5);
        Calendar cal = Calendar.getInstance();
        cal.set(2009, 3, 1);
        Parttimer parttimer = new Parttimer(20011, "まつだ あゆみ", department,
                2, new Date(cal.getTimeInMillis()), 1500);
        em.persist(parttimer);
        commit();
        ResultUtil.showParttimer(parttimer);
        System.out.println("[ test3 ] End\n");
    }
}