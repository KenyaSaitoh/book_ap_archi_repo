package jp.mufg.it.mybatis.company.main;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import jp.mufg.it.mybatis.company.common.SqlSessionHolder;
import jp.mufg.it.mybatis.company.dto.Employee;
import jp.mufg.it.mybatis.company.dto.EmployeeSalaryParam;

public class MyBatisUpdateMain {

    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionHolder.getInstance().getSqlSession();

        //
        Employee param1 = new Employee(10002, null, null, null, null, 666666);
        sqlSession.update("updateEmployeeSalary", param1);
        sqlSession.commit();

        //
        EmployeeSalaryParam param2 = new EmployeeSalaryParam(300000, 1000);
        sqlSession.update("subtractEmployeeSalary", param2);
        sqlSession.commit();

        //
        Map<String, Object> param3 = new HashMap<String, Object>();
        param3.put("salary", 350000);
        param3.put("payCut", 3000);
        sqlSession.update("subtractEmployeeSalaryWithMap", param3);
        sqlSession.commit();
    }
}