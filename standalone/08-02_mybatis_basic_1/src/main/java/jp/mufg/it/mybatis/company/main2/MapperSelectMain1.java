package jp.mufg.it.mybatis.company.main2;

import org.apache.ibatis.session.SqlSession;

import jp.mufg.it.mybatis.company.common.SqlSessionHolder;
import jp.mufg.it.mybatis.company.dto.Employee;
import jp.mufg.it.mybatis.company.mapper.EmployeeMapper;

/*
 * SELECT文、主キー検索、ResultMapによる結果マッピング
 */
public class MapperSelectMain1 {

    public static void main(String[] args) {
        // SqlSessionを取得する
        SqlSession sqlSession = SqlSessionHolder.getInstance().getSqlSession();

        // Mapperを取得する
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        // SELECT文を発行する
        Employee result = mapper.selectEmployee(10005);
        System.out.println(result); // 検索結果を表示
    }
}