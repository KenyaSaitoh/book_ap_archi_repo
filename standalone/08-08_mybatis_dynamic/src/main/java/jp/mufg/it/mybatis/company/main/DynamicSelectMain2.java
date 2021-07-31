package jp.mufg.it.mybatis.company.main;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import jp.mufg.it.mybatis.company.common.SqlSessionHolder;
import jp.mufg.it.mybatis.company.dto.Employee;
import jp.mufg.it.mybatis.company.dto.EmployeeDynamicParam;
import jp.mufg.it.mybatis.company.mapper.EmployeeMapper;
import jp.mufg.it.mybatis.company.util.ResultUtil;

/*
 * 動的クエリ(2)
 */
public class DynamicSelectMain2 {

    public static void main(String[] args) {
        // SqlSessionを取得する
        SqlSession sqlSession = SqlSessionHolder.getInstance().getSqlSession();

        // Mapperを取得する
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        // パラメータとなるEmployeeDynamicParamインスタンスを生成する
        EmployeeDynamicParam paramEmployee =
                new EmployeeDynamicParam(null, 300000, 400000);

        // SELECT文を発行する
        List<Employee> resultList = mapper
                .selectDynamicEmployees(paramEmployee);
        ResultUtil.showEmployeeList(resultList);
    }
}