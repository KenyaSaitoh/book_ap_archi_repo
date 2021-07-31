package jp.mufg.it.mybatis.company.main1;

import org.apache.ibatis.session.SqlSession;

import jp.mufg.it.mybatis.company.common.SqlSessionHolder;

/*
 * SELECT COUNT文
 */
public class SelectMain5 {

    public static void main(String[] args) {
        // SqlSessionを取得する
        SqlSession sqlSession = SqlSessionHolder.getInstance().getSqlSession();

        // SELECT文を発行する
        Long result = sqlSession.selectOne("selectEmpCountByDept", "企画部");
        System.out.println(result); // 検索結果を表示
    }
}