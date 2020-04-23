package jp.mufg.it.mybatis.company.main;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import jp.mufg.it.mybatis.company.common.SqlSessionHolder;
import jp.mufg.it.mybatis.company.dto.Department;
import jp.mufg.it.mybatis.company.dto.Employee;
import jp.mufg.it.mybatis.company.mapper.EmpDeptNestMapper;
import jp.mufg.it.mybatis.company.util.ResultUtil;

/*
 * ネストセレクトによって構造化オブジェクトを取得する
 * （ここではOne-to-manyのOne側、すなわちDepartmentを取得）
 */
public class NestSelectMain2 {

    public static void main(String[] args) {
        // SqlSessionを取得する
        SqlSession sqlSession = SqlSessionHolder.getInstance().getSqlSession();

        // Mapperを取得する
        EmpDeptNestMapper mapper = sqlSession.getMapper(EmpDeptNestMapper.class);

        // SELECT文を発行し、One側（Departmentオブジェクト）を取得する
        Department department = mapper.selectDepartment(3);

        // Departmentオブジェクトに関連を持つEmployeeのリストを取得して表示する
        List<Employee> resultList = department.getEmployees();
        ResultUtil.showEmployeeList(resultList);
    }
}