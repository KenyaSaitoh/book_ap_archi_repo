package jp.mufg.it.mybatis.company.main;

import java.util.Calendar;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;

import jp.mufg.it.mybatis.company.common.SqlSessionHolder;
import jp.mufg.it.mybatis.company.dto.Employee;
import jp.mufg.it.mybatis.company.mapper.EmployeeMapper;
import jp.mufg.it.mybatis.company.type.JobType;

public class InsertMain1 {

    public static void main(String[] args) {
        // SqlSessionを取得する
        SqlSession sqlSession = SqlSessionHolder.getInstance().getSqlSession();

        // Mapperを取得する
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        // 挿入対象のEmployeeインスタンスを生成する
        Calendar cal = Calendar.getInstance();
        cal.set(2017, 11, 1);
        Employee param = new Employee(10021, "Steve", null,
                new Date(cal.getTimeInMillis()), JobType.LEADER, 380000, 0L);

        // INSERT文を発行しコミットする
        mapper.insertEmployee(param);
        sqlSession.commit();
    }
}