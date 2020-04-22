package jp.mufg.it.mybatis.company.test;

import org.junit.Test;

import jp.mufg.it.mybatis.company.dto.Department;
import jp.mufg.it.mybatis.company.dto.Employee;
import jp.mufg.it.mybatis.company.test.base.MyBatisTestBase;
import jp.mufg.it.mybatis.company.type.JobType;

public class MyBatisUpdateTest extends MyBatisTestBase {
    // UPDATE
    @Test
    public void test1() {
        System.out.println("[ test1 ] Start");
        Employee employee = sqlSession.selectOne(
                "jp.mufg.it.mybatis.company.join.selectEmployee", 10001);
        employee.setSalary(510000);
        employee.setJobType(JobType.LEADER);
        employee.getDepartment().setDepartmentId(3); // これがポイント!
        sqlSession.update("updateEmployee", employee);
        sqlSession.commit();
        System.out.println("[ test1 ] End\n");
    }

    // UPDATE
    @Test
    public void test2() {
        System.out.println("[ test2 ] Start");
        Department department = sqlSession.selectOne(
                "jp.mufg.it.mybatis.company.join.selectDepartment", 3);

        // メモリ上で更新
        department.setLocation("日本橋");
        for (Employee employee : department.getEmployees()) {
            employee.setSalary(employee.getSalary() + 1000);
        }

        // One側でSQL発行
        sqlSession.update("updateDepartment", department); // これだけで自動的にEmployeeも更新されるわけではない！

        // Many側もこのように手動でSQL発行が必要（自分でカスケードする）
        for (Employee employee : department.getEmployees()) {
            sqlSession.update("updateEmployee", employee);
        }

        sqlSession.commit();
        System.out.println("[ test2 ] End\n");
    }
}