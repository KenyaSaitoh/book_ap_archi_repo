package jp.mufg.it.mybatis.company.test;

import java.util.List;

import org.junit.Test;

import jp.mufg.it.mybatis.company.dto.Employee;
import jp.mufg.it.mybatis.company.test.base.MyBatisTestBase;

public class MyBatisSingleObjectTest extends MyBatisTestBase {
    // JOIN SELECT＋単一オブジェクト
    @Test
    public void test2() {
        System.out.println("[ test1 ] Start");
        List<Employee> result = sqlSession.selectList(
                "selectEmployeesByDepartmentName", "基盤技術部");
        System.out.println(result);
        System.out.println("[ test1 ] End\n");
    }
}