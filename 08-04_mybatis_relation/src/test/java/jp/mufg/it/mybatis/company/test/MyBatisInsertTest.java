package jp.mufg.it.mybatis.company.test;

import java.util.Date;

import org.junit.Test;

import jp.mufg.it.mybatis.company.dto.Department;
import jp.mufg.it.mybatis.company.dto.Employee;
import jp.mufg.it.mybatis.company.test.base.MyBatisTestBase;
import jp.mufg.it.mybatis.company.type.JobType;

public class MyBatisInsertTest extends MyBatisTestBase {
    // INSERT
    @Test
    public void test1() {
        System.out.println("[ test1 ] Start");
        Department department = new Department();
        department.setDepartmentId(3);
        Employee employee = new Employee(20001, "AAA", department, new Date(),
                JobType.CHIEF, 500000, 0L);
        sqlSession.insert("insertEmployee", employee);
        sqlSession.commit();
        System.out.println("[ test1 ] End\n");
    }
}