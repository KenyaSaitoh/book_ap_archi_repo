package jp.mufg.it.mybatis.company.main;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import jp.mufg.it.mybatis.company.common.SqlSessionHolder;
import jp.mufg.it.mybatis.company.dto.Employee;
import jp.mufg.it.mybatis.company.type.JobType;

public class MyBatisSelectMain {

    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionHolder.getInstance().getSqlSession();
        //
        Employee result1 = sqlSession.selectOne("selectEmployee", 10005);
        ResultUtil.showEmployee(result1);

        //
        Employee result2 = sqlSession.selectOne("selectEmployeeWithResultMap", 10005);
        ResultUtil.showEmployee(result2);

        //
        Employee result3 = sqlSession.selectOne("selectEmployeeWithAutoMapping", 10005);
        ResultUtil.showEmployee(result3);

        //
        Employee result4 = sqlSession.selectOne("selectEmployeeWithSqlFragment", 10005);
        ResultUtil.showEmployee(result4);

        //
        Long result5 = sqlSession.selectOne("selectEmpCountByDept", "情報システム部");
        System.out.println(result5);

        //
        // 挿入対象のEmployeeクラスのインスタンスを生成する
        Calendar cal = Calendar.getInstance();
        cal.set(2017, 11, 1);
        Employee param1 = new Employee(10021, "Steve", "総務部",
                new Date(cal.getTimeInMillis()),JobType.LEADER, 380000);
        List<Employee> result6 = sqlSession.selectList("selectEmployees",
                param1);
        ResultUtil.showEmployeeList(result6);

        Map<String, Object> param2 = new HashMap<String, Object>();
        param2.put("lowersalary", 300000);
        param2.put("uppersalary", 400000);
        List<Employee> result7 = sqlSession.selectList("selectEmployeesWithMap",
                param2);
        ResultUtil.showEmployeeList(result7);

        // Employeeを単独で受け取るメソッドの場合、ヒットしない場合はnullが返される
        Employee result8 = sqlSession.selectOne("selectEmployee", 99999);
        System.out.println(result8 == null);

        // Employeeをリストで受け取るメソッドの場合、ヒットしない場合は空のリストが返される
        Employee param3 = new Employee(null, null, "総務部", null, null, 300000);
        List<Employee> result9 = sqlSession.selectList("selectEmployees",
                param3);
        System.out.println(result9 == null);
        System.out.println(result9.size() == 0);
    }
}