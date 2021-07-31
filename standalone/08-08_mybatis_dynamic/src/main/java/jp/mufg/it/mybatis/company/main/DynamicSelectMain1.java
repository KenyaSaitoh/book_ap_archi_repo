package jp.mufg.it.mybatis.company.main;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import jp.mufg.it.mybatis.company.common.SqlSessionHolder;
import jp.mufg.it.mybatis.company.dto.Employee;
import jp.mufg.it.mybatis.company.dto.EmployeeDynamicParam;
import jp.mufg.it.mybatis.company.mapper.EmployeeMapper;
import jp.mufg.it.mybatis.company.util.ResultUtil;

/*
 * 動的クエリ(1)
 */
public class DynamicSelectMain1 {

    public static void main(String[] args) {
        // SqlSessionを取得する
        SqlSession sqlSession = SqlSessionHolder.getInstance().getSqlSession();

        // Mapperを取得する
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        // パラメータとなるEmployeeDynamicParamインスタンスを生成する
        EmployeeDynamicParam paramEmployee =
                new EmployeeDynamicParam("営業部", 250000, 300000);

        // SELECT文を発行する
        List<Employee> resultList = mapper
                .selectDynamicEmployees(paramEmployee);
        ResultUtil.showEmployeeList(resultList);
    }
}