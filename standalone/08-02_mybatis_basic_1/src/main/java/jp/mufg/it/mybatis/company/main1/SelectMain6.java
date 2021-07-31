package jp.mufg.it.mybatis.company.main1;

import static jp.mufg.it.mybatis.company.util.ResultUtil.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import jp.mufg.it.mybatis.company.common.SqlSessionHolder;
import jp.mufg.it.mybatis.company.dto.Employee;

/*
 * SELECT文、条件検索（DTOパラメータ使用）、複数件ヒット
 */
public class SelectMain6 {

    public static void main(String[] args) {
        // SqlSessionを取得する
        SqlSession sqlSession = SqlSessionHolder.getInstance().getSqlSession();

        // パラメータとなるEmployeeインスタンスを生成する
        Employee param1 = new Employee(null, null, "営業部", 300000);

        // SELECT文を発行する
        List<Employee> resultList1 = sqlSession
                .selectList("selectEmployeesWithParam", param1);
        showEmployeeList(resultList1); // 検索結果を表示

        // パラメータとなるEmployeeインスタンスを生成する
        Employee param2 = new Employee(null, null, "企画部", 470000);

        // SELECT文を発行する
        // Employeeをリストで受け取るメソッドの場合、ヒットしない場合は空のリストが返される
        List<Employee> resultList2 = sqlSession
                .selectList("selectEmployeesWithParam", param2);
        System.out.println(resultList2.size()); // 検索結果のサイズを表示
    }
}