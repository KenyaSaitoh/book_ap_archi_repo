package jp.mufg.it.mybatis.company.test;

import java.util.List;

import org.junit.Test;

import jp.mufg.it.mybatis.company.dto.Employee;
import jp.mufg.it.mybatis.company.dto.EmployeeDynamicParam;
import jp.mufg.it.mybatis.company.test.base.MyBatisTestBase;

public class MyBatisDynamicSqlTest extends MyBatisTestBase {

    @Test
    public void test1() {
        System.out.println("[ test1 ] Start");
        EmployeeDynamicParam paramEmployee =
                new EmployeeDynamicParam("基盤技術部", null, null);
        List<Employee> resultList = sqlSession.selectList(
                "selectDynamicEmployees", paramEmployee);
        System.out.println("[ test1 ] End\n");
    }

    @Test
    public void test2() {
        System.out.println("[ test2 ] Start");
        EmployeeDynamicParam paramEmployee =
                new EmployeeDynamicParam("基盤技術部", 300000, null);
        List<Employee> resultList = sqlSession.selectList(
                "selectDynamicEmployees", paramEmployee);
        System.out.println("[ test2 ] End\n");
    }

    @Test
    public void test3() {
        System.out.println("[ test3 ] Start");
        EmployeeDynamicParam paramEmployee =
                new EmployeeDynamicParam("基盤技術部", 350000, 400000);
        List<Employee> resultList = sqlSession.selectList(
                "selectDynamicEmployees", paramEmployee);
        System.out.println("[ test3 ] End\n");
    }

    @Test
    public void test4() {
        System.out.println("[ test4 ] Start");
        EmployeeDynamicParam paramEmployee =
                new EmployeeDynamicParam(null, 300000, 400000);
        List<Employee> resultList = sqlSession.selectList(
                "selectDynamicEmployees", paramEmployee);
        System.out.println("[ test4 ] End\n");
    }
}