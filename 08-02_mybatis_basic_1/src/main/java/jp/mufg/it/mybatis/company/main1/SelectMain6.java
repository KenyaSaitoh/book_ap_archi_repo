package jp.mufg.it.mybatis.company.main1;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import jp.mufg.it.mybatis.company.common.SqlSessionHolder;
import jp.mufg.it.mybatis.company.dto.Employee;
import jp.mufg.it.mybatis.company.util.ResultUtil;

/*
 * SELECT文、条件検索（DTOパラメータ使用）、複数件ヒット
 */
public class SelectMain6 {

    public static void main(String[] args) {
        // SqlSessionを取得する
        SqlSession sqlSession = SqlSessionHolder.getInstance().getSqlSession();

        // パラメータとなるEmployeeインスタンスを生成する
        Employee param1 = new Employee(null, null, "営業部", 300000);

        // SELECT文を発行し結果を表示する
        List<Employee> result1 = sqlSession.selectList("selectEmployeesWithParam",
                param1);
        ResultUtil.showEmployeeList(result1);

        // パラメータとなるEmployeeインスタンスを生成する
        Employee param2 = new Employee(null, null, "企画部", 470000);

        // SELECT文を発行し結果を表示する
        // Employeeをリストで受け取るメソッドの場合、ヒットしない場合は空のリストが返される
        List<Employee> result2 = sqlSession.selectList("selectEmployeesWithParam",
                param2);
        System.out.println(result2 != null);
        System.out.println(result2.size());
    }
}