package jp.mufg.it.mybatis.company.main;

import org.apache.ibatis.session.SqlSession;

import jp.mufg.it.mybatis.company.common.SqlSessionHolder;
import jp.mufg.it.mybatis.company.dto.Employee;

public class MyBatisInsertMain_MySQL {

    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionHolder.getInstance().getSqlSession();
        Employee param = new Employee("AAA", "BBB", 350000);
        sqlSession.insert("insertEmployeeWithMySQL", param);
        sqlSession.commit();
        System.out.println("employeeId ---> " + param.getEmployeeId());
    }
}