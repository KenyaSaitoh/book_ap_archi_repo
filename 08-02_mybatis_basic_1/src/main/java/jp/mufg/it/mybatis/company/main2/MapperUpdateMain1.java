package jp.mufg.it.mybatis.company.main2;

import org.apache.ibatis.session.SqlSession;

import jp.mufg.it.mybatis.company.common.SqlSessionHolder;
import jp.mufg.it.mybatis.company.dto.Employee;
import jp.mufg.it.mybatis.company.mapper.EmployeeMapper;

/*
 * UPDATE文、主キー特定カラム更新
 */
public class MapperUpdateMain1 {

    public static void main(String[] args) {
        // SqlSessionを取得する
        SqlSession sqlSession = SqlSessionHolder.getInstance().getSqlSession();

        // Mapperを取得する
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        // SELECT文を発行する
        Employee employee = mapper.selectEmployee(10005);

        // UPDATE文を発行しコミットする
        employee.setSalary(employee.getSalary() + 3333);
        mapper.updateEmployee(employee);
        sqlSession.commit();
    }
}