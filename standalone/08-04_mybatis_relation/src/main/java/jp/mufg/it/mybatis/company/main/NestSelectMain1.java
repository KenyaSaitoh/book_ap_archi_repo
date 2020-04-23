package jp.mufg.it.mybatis.company.main;

import org.apache.ibatis.session.SqlSession;

import jp.mufg.it.mybatis.company.common.SqlSessionHolder;
import jp.mufg.it.mybatis.company.dto.Employee;
import jp.mufg.it.mybatis.company.mapper.EmpDeptNestMapper;
import jp.mufg.it.mybatis.company.util.ResultUtil;

/*
 * ネストセレクトによって構造化オブジェクトを取得する
 * （ここではMany-to-OneのMany側、すなわちEmployeeを取得）
 */
public class NestSelectMain1 {

    public static void main(String[] args) {
        // SqlSessionを取得する
        SqlSession sqlSession = SqlSessionHolder.getInstance().getSqlSession();

        // Mapperを取得する
        EmpDeptNestMapper mapper = sqlSession.getMapper(EmpDeptNestMapper.class);

        // SELECT文を発行し、単一のMany側（Employeeオブジェクト）を取得する
        Employee employee = mapper.selectEmployee(10001);

        // 結果を表示する
        ResultUtil.showEmployee(employee);
    }
}