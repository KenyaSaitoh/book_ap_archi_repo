package jp.mufg.it.mybatis.company.main1;

import org.apache.ibatis.session.SqlSession;

import jp.mufg.it.mybatis.company.common.SqlSessionHolder;
import jp.mufg.it.mybatis.company.dto.Employee;

/*
 * INSERT文
 */
public class InsertMain1 {

    public static void main(String[] args) {
        // SqlSessionを取得する
        SqlSession sqlSession = SqlSessionHolder.getInstance().getSqlSession();

        // 挿入対象のEmployeeインスタンスを生成する
        Employee param = new Employee(10015, "Steve", "企画部", 380000);

        // INSERT文を発行しコミットする
        sqlSession.insert("insertEmployee", param);
        sqlSession.commit();
    }
}