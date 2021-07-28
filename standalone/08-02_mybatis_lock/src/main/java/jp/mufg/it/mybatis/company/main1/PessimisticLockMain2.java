package jp.mufg.it.mybatis.company.main1;

import org.apache.ibatis.session.SqlSession;

import jp.mufg.it.mybatis.company.common.SqlSessionHolder;
import jp.mufg.it.mybatis.company.dto.Employee;
import jp.mufg.it.mybatis.company.mapper.EmployeeMapper;

/*
 * 悲観的ロック
 *
 * このプログラムを、PessimisticLockMain1の後に実行する
 * → SELECT FOR UPDATE文によりロックウェイトし、PessimisticLockMain1がコミットされた後、
 * 月給が+5000円で更新される
 */
public class PessimisticLockMain2 {

    public static void main(String[] args) throws Exception {
        // SqlSessionを取得する
        SqlSession sqlSession = SqlSessionHolder.getInstance().getSqlSession();

        // Mapperを取得する
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        // SELECT文を発行し、Employeeを取得する
        Employee employee = mapper.selectEmployeeWithPessimisticLock(10001);

        // 取得したEmployeeの値（月給）を書き換える
        employee.setSalary(employee.getSalary() + 5000);

        // UPDATE文を発行する
        mapper.updateEmployee(employee);

        // コミットする
        sqlSession.commit();
    }
}