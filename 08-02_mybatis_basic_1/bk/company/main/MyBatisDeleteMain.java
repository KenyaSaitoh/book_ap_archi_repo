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
        Employee param = new Employee(0, "",  "情報システム部", 300000);
        sqlSession.delete("deleteEmployees", param);
        sqlSession.commit();
    }
}