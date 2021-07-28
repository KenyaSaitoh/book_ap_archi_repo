package jp.mufg.it.mybatis.company.main1;

import org.apache.ibatis.session.SqlSession;

import jp.mufg.it.mybatis.company.common.SqlSessionHolder;
import jp.mufg.it.mybatis.company.dto.Employee;

/*
 * SELECT文、主キー検索、ネーミングルールによる自動結果マッピング
 */
public class SelectMain3 {

    public static void main(String[] args) {
        // SqlSessionを取得する
        SqlSession sqlSession = SqlSessionHolder.getInstance().getSqlSession();

        // SELECT文を発行し結果を表示する
        Employee result = sqlSession.selectOne("selectEmployee3", 10005);
        System.out.println(result);
    }
}