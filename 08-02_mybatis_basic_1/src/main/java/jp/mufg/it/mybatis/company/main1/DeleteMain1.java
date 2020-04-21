package jp.mufg.it.mybatis.company.main1;

import org.apache.ibatis.session.SqlSession;

import jp.mufg.it.mybatis.company.common.SqlSessionHolder;

/*
 * DELETE文、主キー削除
 */
public class DeleteMain1 {

    public static void main(String[] args) {
        // SqlSessionを取得する
        SqlSession sqlSession = SqlSessionHolder.getInstance().getSqlSession();

        // DELETE文を発行しコミットする
        sqlSession.delete("deleteEmployee", 10002);
        sqlSession.commit();
    }
}