package jp.mufg.it.mybatis.company.main;

import java.util.Calendar;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;

import jp.mufg.it.mybatis.company.common.SqlSessionHolder;
import jp.mufg.it.mybatis.company.dto.Employee;
import jp.mufg.it.mybatis.company.type.JobType;

public class MyBatisInsertMain_MySQL {

    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionHolder.getInstance().getSqlSession();

        // 挿入対象のEmployeeクラスのインスタンスを生成する
        Calendar cal = Calendar.getInstance();
        cal.set(2017, 11, 1);
        Employee param = new Employee(10021, "Steve", "総務部",
                new Date(cal.getTimeInMillis()),JobType.LEADER, 380000);

        sqlSession.insert("insertEmployeeWithMySQL", param);
        sqlSession.commit();
        System.out.println("employeeId ---> " + param.getEmployeeId());
    }
}