package jp.mufg.it.mybatis.company.main;

import org.apache.ibatis.session.SqlSession;

import jp.mufg.it.mybatis.company.common.SqlSessionHolder;
import jp.mufg.it.mybatis.company.dto.Employee;

public class MyBatisInsertMain {

    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionHolder.getInstance().getSqlSession();
        // 挿入対象のEmployeeクラスのインスタンスを生成する
        Employee param = new Employee(10021, "Steve", "総務部", 380000);
        sqlSession.insert("insertEmployee", param);
        sqlSession.commit();
    }
}