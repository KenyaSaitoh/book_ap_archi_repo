package jp.mufg.it.mybatis.company.main2;

import org.apache.ibatis.session.SqlSession;

import jp.mufg.it.mybatis.company.common.SqlSessionHolder;
import jp.mufg.it.mybatis.company.dto.Employee;
import jp.mufg.it.mybatis.company.mapper.EmployeeMapper;

/*
 * INSERT文
 */
public class MapperInsertMain1 {

    public static void main(String[] args) {
        // SqlSessionを取得する
        SqlSession sqlSession = SqlSessionHolder.getInstance().getSqlSession();

        // Mapperを取得する
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        // 挿入対象のEmployeeインスタンスを生成する
        Employee param = new Employee(10015, "Steve", "企画部", 380000);

        // INSERT文を発行しコミットする
        mapper.insertEmployee(param);
        sqlSession.commit();
    }
}