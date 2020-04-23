package jp.mufg.it.mybatis.company.main;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;

import jp.mufg.it.mybatis.company.common.SqlSessionHolder;
import jp.mufg.it.mybatis.company.dto.Department;
import jp.mufg.it.mybatis.company.dto.Employee;
import jp.mufg.it.mybatis.company.mapper.EmployeeMapper;
import jp.mufg.it.mybatis.company.type.JobType;

/*
 * INSERTのカスケード
 */
public class InsertMain {

    public static void main(String[] args) {
        // SqlSessionを取得する
        SqlSession sqlSession = SqlSessionHolder.getInstance().getSqlSession();

        // Mapperを取得する
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        // 挿入対象のDepartmentインスタンスを生成する
        Department department = new Department();
        department.setDepartmentId(3);

        // 挿入対象のEmployeeインスタンスを生成する
        Employee employee = new Employee(20001, "AAA", department, new Date(),
                JobType.CHIEF, 500000);

        // INSERT文を発行しコミットする
        mapper.insertEmployee(employee);
        sqlSession.commit();
    }
}