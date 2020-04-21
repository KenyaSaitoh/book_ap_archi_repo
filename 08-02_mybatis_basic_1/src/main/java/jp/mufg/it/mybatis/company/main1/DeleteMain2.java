package jp.mufg.it.mybatis.company.main1;

import org.apache.ibatis.session.SqlSession;

import jp.mufg.it.mybatis.company.common.SqlSessionHolder;
import jp.mufg.it.mybatis.company.dto.Employee;

/*
 * DELETE文、一括削除（DTOパラメータ使用）
 */
public class DeleteMain2 {

    public static void main(String[] args) {
        // SqlSessionを取得する
        SqlSession sqlSession = SqlSessionHolder.getInstance().getSqlSession();

        // DELETE文を発行しコミットする
        Employee param = new Employee(null, null, "商品開発部", 400000);
        sqlSession.delete("deleteEmployees", param);
        sqlSession.commit();
    }
}