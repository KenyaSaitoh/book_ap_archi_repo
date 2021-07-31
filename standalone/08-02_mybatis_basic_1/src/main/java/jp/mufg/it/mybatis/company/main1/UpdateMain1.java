package jp.mufg.it.mybatis.company.main1;

import org.apache.ibatis.session.SqlSession;

import jp.mufg.it.mybatis.company.common.SqlSessionHolder;
import jp.mufg.it.mybatis.company.dto.Employee;

/*
 * UPDATE文、主キー特定カラム更新
 */
public class UpdateMain1 {

    public static void main(String[] args) {
        // SqlSessionを取得する
        SqlSession sqlSession = SqlSessionHolder.getInstance().getSqlSession();

        // SELECT文を発行する
        Employee employee = sqlSession.selectOne("selectEmployee", 10005);

        // UPDATE文を発行する
        employee.setSalary(employee.getSalary() + 3333);
        sqlSession.update("updateEmployee", employee);

        // コミットする
        sqlSession.commit();
    }
}