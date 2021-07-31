package jp.mufg.it.mybatis.company.main;

import java.util.Calendar;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;

import jp.mufg.it.mybatis.company.common.SqlSessionHolder;
import jp.mufg.it.mybatis.company.dto.Employee;
import jp.mufg.it.mybatis.company.mapper.EmployeeMapper;
import jp.mufg.it.mybatis.company.type.JobType;

public class InsertMain2 {

    public static void main(String[] args) {
        // SqlSessionを取得する
        SqlSession sqlSession = SqlSessionHolder.getInstance().getSqlSession();

        // Mapperを取得する
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        // 挿入対象のEmployeeインスタンスを生成する
        Calendar cal = Calendar.getInstance();
        cal.set(2017, 11, 1);
        Employee param = new Employee("Trent", "商品開発部",
                new Date(cal.getTimeInMillis()), JobType.CHIEF, 310000, 0L);

        // INSERT文を発行しコミットする
        mapper.insertEmployeeWithKeyGen(param);
        sqlSession.commit();

        // 自動採番されたキーを表示する
        System.out.println("employeeId => " + param.getEmployeeId());
    }
}