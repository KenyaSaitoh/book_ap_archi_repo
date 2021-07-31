package jp.mufg.it.mybatis.company.main2;

import static jp.mufg.it.mybatis.company.util.ResultUtil.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import jp.mufg.it.mybatis.company.common.SqlSessionHolder;
import jp.mufg.it.mybatis.company.dto.Employee;
import jp.mufg.it.mybatis.company.mapper.EmployeeMapper;

/*
 * SELECT文、条件検索（Mapパラメータ使用）、複数件ヒット
 */
public class MapperSelectMain2 {

    public static void main(String[] args) {
        // SqlSessionを取得する
        SqlSession sqlSession = SqlSessionHolder.getInstance().getSqlSession();

        // Mapperを取得する
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        // SELECT文を発行する
        List<Employee> resultList = mapper.selectEmployees("営業部", 300000);
        showEmployeeList(resultList); // 検索結果を表示
    }
}