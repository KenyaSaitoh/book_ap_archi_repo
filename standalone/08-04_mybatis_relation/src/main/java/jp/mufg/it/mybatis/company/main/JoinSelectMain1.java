package jp.mufg.it.mybatis.company.main;

import org.apache.ibatis.session.SqlSession;

import jp.mufg.it.mybatis.company.common.SqlSessionHolder;
import jp.mufg.it.mybatis.company.dto.Employee;
import jp.mufg.it.mybatis.company.mapper.EmpDeptJoinMapper;

/*
 * ジョインセレクトによって構造化オブジェクトを取得する
 * （ここではMany-to-OneのMany側、すなわちEmployeeを取得）
 */
public class JoinSelectMain1 {

    public static void main(String[] args) {
        // SqlSessionを取得する
        SqlSession sqlSession = SqlSessionHolder.getInstance().getSqlSession();

        // Mapperを取得する
        EmpDeptJoinMapper mapper = sqlSession.getMapper(EmpDeptJoinMapper.class);

        // SELECT文を発行し、単一のMany側（Employeeオブジェクト）を取得する
        Employee employee = mapper.selectEmployee(10001);
        System.out.println(employee); // 検索結果を表示
    }
}