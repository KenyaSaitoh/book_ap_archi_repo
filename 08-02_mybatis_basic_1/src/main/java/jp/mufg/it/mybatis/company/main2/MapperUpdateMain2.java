package jp.mufg.it.mybatis.company.main2;

import org.apache.ibatis.session.SqlSession;

import jp.mufg.it.mybatis.company.common.SqlSessionHolder;
import jp.mufg.it.mybatis.company.mapper.EmployeeMapper;

/*
 * UPDATE文、一括更新
 */
public class MapperUpdateMain2 {

    public static void main(String[] args) {
        // SqlSessionを取得する
        SqlSession sqlSession = SqlSessionHolder.getInstance().getSqlSession();

        // Mapperを取得する
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        // UPDATE文を発行しコミットする
        mapper.subtractSalaryWithParam(350000, 1000);
        sqlSession.commit();
    }
}