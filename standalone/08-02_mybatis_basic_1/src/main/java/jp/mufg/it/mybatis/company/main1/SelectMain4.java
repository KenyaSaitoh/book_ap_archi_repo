package jp.mufg.it.mybatis.company.main1;

import org.apache.ibatis.session.SqlSession;

import jp.mufg.it.mybatis.company.common.SqlSessionHolder;
import jp.mufg.it.mybatis.company.dto.Employee;
import jp.mufg.it.mybatis.company.util.ResultUtil;

/*
 * SELECT文、主キー検索、SQLフラグメント利用
 */
public class SelectMain4 {

    public static void main(String[] args) {
        // SqlSessionを取得する
        SqlSession sqlSession = SqlSessionHolder.getInstance().getSqlSession();

        // SELECT文を発行し結果を表示する
        Employee result = sqlSession.selectOne("selectEmployeeWithSqlFragment", 10005);
        ResultUtil.showEmployee(result);
    }
}