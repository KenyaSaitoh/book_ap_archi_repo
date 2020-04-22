package jp.mufg.it.mybatis.company.main;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import jp.mufg.it.mybatis.company.common.SqlSessionHolder;
import jp.mufg.it.mybatis.company.dto.Employee;
import jp.mufg.it.mybatis.company.mapper.EmployeeMapper;
import jp.mufg.it.mybatis.company.util.ResultUtil;

/*
 * SELECT文、複数条件検索（IN句展開）
 */
public class SelectMain2 {

    public static void main(String[] args) {
        // SqlSessionを取得する
        SqlSession sqlSession = SqlSessionHolder.getInstance().getSqlSession();

        // Mapperを取得する
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        // パラメータとなるリストを生成する
        List<String> departmentNameList = new ArrayList<String>();
        departmentNameList.add("企画部");
        departmentNameList.add("商品開発部");

        // SELECT文を発行し結果を表示する
        List<Employee> resultList = mapper
                .selectVariousDepartment(departmentNameList);
        ResultUtil.showEmployeeList(resultList);
    }
}