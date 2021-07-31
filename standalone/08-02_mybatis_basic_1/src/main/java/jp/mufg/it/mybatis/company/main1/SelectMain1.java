package jp.mufg.it.mybatis.company.main1;

import org.apache.ibatis.session.SqlSession;

import jp.mufg.it.mybatis.company.common.SqlSessionHolder;
import jp.mufg.it.mybatis.company.dto.Employee;

/*
 * SELECT文、主キー検索、ResultMapによる結果マッピング
 */
public class SelectMain1 {

    public static void main(String[] args) {
        // SqlSessionを取得する
        SqlSession sqlSession = SqlSessionHolder.getInstance().getSqlSession();

        // SELECT文を発行する
        Employee result = sqlSession.selectOne("selectEmployee", 10005);
        System.out.println(result); // 検索結果を表示

        // SELECT文を発行する
        // Employeeを単独で受け取るメソッドの場合、ヒットしない場合はnullが返される
        Employee result2 = sqlSession.selectOne("selectEmployee", 99999);
        System.out.println(result2 == null); // 検索結果がNULLかどうかを表示
    }
}