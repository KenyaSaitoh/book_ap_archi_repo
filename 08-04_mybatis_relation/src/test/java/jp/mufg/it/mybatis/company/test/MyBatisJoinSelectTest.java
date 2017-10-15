package jp.mufg.it.mybatis.company.test;

import java.util.List;

import org.junit.Test;

import jp.mufg.it.mybatis.company.dto.Department;
import jp.mufg.it.mybatis.company.dto.Employee;
import jp.mufg.it.mybatis.company.test.base.MyBatisTestBase;

public class MyBatisJoinSelectTest extends MyBatisTestBase {

    // JOIN SELECT＋構造化オブジェクト＋One-to-many
    @Test
    public void test1() {
        System.out.println("[ test1 ] Start");
        Department department = sqlSession.selectOne(
                "org.study.mybatis.company.join.selectDepartment", 3);
        List<Employee> list = department.getEmployees();
        System.out.println("[ test1 ] End\n");
    }

    // JOIN SELECT＋構造化オブジェクト＋Many-to-one
    @Test
    public void test2() {
        System.out.println("[ test2 ] Start");
        Employee employee = sqlSession.selectOne(
                "org.study.mybatis.company.join.selectEmployee", 10001);
        System.out.println("[ test2 ] End\n");
    }
}