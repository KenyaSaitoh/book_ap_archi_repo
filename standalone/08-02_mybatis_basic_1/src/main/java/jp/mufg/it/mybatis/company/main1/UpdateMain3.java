package jp.mufg.it.mybatis.company.main1;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import jp.mufg.it.mybatis.company.common.SqlSessionHolder;

/*
 * UPDATE文、一括更新（Mapパラメータ使用）
 */
public class UpdateMain3 {

    public static void main(String[] args) {
        // SqlSessionを取得する
        SqlSession sqlSession = SqlSessionHolder.getInstance().getSqlSession();

        // UPDATE文を発行する
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("salary", 400000);
        param.put("payCut", 3000);
        sqlSession.update("subtractSalaryWithMap", param);

        // コミットする
        sqlSession.commit();
    }
}