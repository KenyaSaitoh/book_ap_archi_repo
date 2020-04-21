package jp.mufg.it.mybatis.company.main2;

import org.apache.ibatis.session.SqlSession;

import jp.mufg.it.mybatis.company.common.SqlSessionHolder;
import jp.mufg.it.mybatis.company.mapper.EmployeeMapper;

/*
 * DELETE文、主キー削除
 */
public class MapperDeleteMain1 {

    public static void main(String[] args) {
        // SqlSessionを取得する
        SqlSession sqlSession = SqlSessionHolder.getInstance().getSqlSession();

        // Mapperを取得する
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        // DELETE文を発行しコミットする
        mapper.deleteEmployee(10002);
        sqlSession.commit();
    }
}