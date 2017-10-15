package jp.mufg.it.mybatis.company.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import jp.mufg.it.mybatis.company.dto.Employee;
import jp.mufg.it.mybatis.company.test.base.MyBatisTestBase;

public class MyBatisVariousConditionTest extends MyBatisTestBase {

    @Test
    public void test1() {
        System.out.println("[ test1 ] Start");
        List<String> departmentNameList = new ArrayList<String>();
        departmentNameList.add("企画部");
        departmentNameList.add("ネットワーク管理部");
        List<Employee> resultList = sqlSession.selectList(
                "selectVariousDepartment", departmentNameList);
        System.out.println("[ test1 ] End\n");
    }
}