package jp.mufg.it.mybatis.company.main;

import org.apache.ibatis.session.SqlSession;

import jp.mufg.it.mybatis.company.common.SqlSessionHolder;
import jp.mufg.it.mybatis.company.dto.Employee;

public class MyBatisDeleteMain {

    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionHolder.getInstance().getSqlSession();

        //
        sqlSession.delete("deleteEmployee", 10002);
        sqlSession.commit();

        //
        Employee param1 = new Employee(10002, null, "企画部", null, null, 666666);
        sqlSession.delete("deleteEmployees", param1);
        sqlSession.commit();
    }
}