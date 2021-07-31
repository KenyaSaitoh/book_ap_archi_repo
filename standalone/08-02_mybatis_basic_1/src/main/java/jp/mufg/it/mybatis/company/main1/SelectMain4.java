package jp.mufg.it.mybatis.company.main1;

import org.apache.ibatis.session.SqlSession;

import jp.mufg.it.mybatis.company.common.SqlSessionHolder;
import jp.mufg.it.mybatis.company.dto.Employee;

/*
 * SELECT文、主キー検索、SQLフラグメント利用
 */
public class SelectMain4 {

    public static void main(String[] args) {
        // SqlSessionを取得する
        SqlSession sqlSession = SqlSessionHolder.getInstance().getSqlSession();

        // SELECT文を発行する
        Employee result = sqlSession.selectOne("selectEmployeeWithSqlFragment",
                10005);
        System.out.println(result); // 検索結果を表示
    }
}