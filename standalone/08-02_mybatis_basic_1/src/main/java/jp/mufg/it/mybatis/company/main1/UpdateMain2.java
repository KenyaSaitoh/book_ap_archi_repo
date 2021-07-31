package jp.mufg.it.mybatis.company.main1;

import org.apache.ibatis.session.SqlSession;

import jp.mufg.it.mybatis.company.common.SqlSessionHolder;
import jp.mufg.it.mybatis.company.dto.EmployeeSalaryParam;

/*
 * UPDATE文、一括更新（パラメータ専用DTO）
 */
public class UpdateMain2 {

    public static void main(String[] args) {
        // SqlSessionを取得する
        SqlSession sqlSession = SqlSessionHolder.getInstance().getSqlSession();

        // UPDATE文を発行する
        EmployeeSalaryParam param = new EmployeeSalaryParam(350000, 1000);
        sqlSession.update("subtractSalaryWithParam", param);

        // コミットする
        sqlSession.commit();
    }
}