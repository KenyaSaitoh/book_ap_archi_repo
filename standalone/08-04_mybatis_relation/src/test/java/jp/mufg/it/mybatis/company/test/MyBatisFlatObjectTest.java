package jp.mufg.it.mybatis.company.test;

import org.junit.Test;

import jp.mufg.it.mybatis.company.dto.EmployeeDepartment;
import jp.mufg.it.mybatis.company.test.base.MyBatisTestBase;

public class MyBatisFlatObjectTest extends MyBatisTestBase {

    // JOIN SELECT＋フラットオブジェクト
    @Test
    public void test1() {
        System.out.println("[ test1 ] Start");
        EmployeeDepartment result = sqlSession.selectOne("selectEmployeeTO", 10007);
        System.out.println("[ test1 ] End\n");
    }
}