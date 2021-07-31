package jp.mufg.it.mybatis.company.main;

import org.apache.ibatis.session.SqlSession;

import jp.mufg.it.mybatis.company.common.SqlSessionHolder;
import jp.mufg.it.mybatis.company.dto.Employee;
import jp.mufg.it.mybatis.company.mapper.EmpDeptJoinMapper;
import jp.mufg.it.mybatis.company.mapper.EmployeeMapper;
import jp.mufg.it.mybatis.company.type.JobType;

/*
 * UPDATE（社員の属性変更）
 */
public class UpdateMain {

    public static void main(String[] args) {
        // SqlSessionを取得する
        SqlSession sqlSession = SqlSessionHolder.getInstance().getSqlSession();

        // Mapperを取得する
        EmpDeptJoinMapper mapper1 = sqlSession.getMapper(
                EmpDeptJoinMapper.class);
        EmployeeMapper mapper2 = sqlSession.getMapper(EmployeeMapper.class);

        // 社員の属性を変更する
        Employee employee = mapper1.selectEmployee(10001);
        employee.setSalary(510000);
        employee.setJobType(JobType.LEADER);
        employee.getDepartment().setDepartmentId(3); // これがポイント!

        // UPDATE文を発行する
        mapper2.updateEmployee(employee);

        // コミット数する
        sqlSession.commit();
    }
}