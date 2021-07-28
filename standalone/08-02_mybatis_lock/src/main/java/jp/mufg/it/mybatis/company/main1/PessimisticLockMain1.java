package jp.mufg.it.mybatis.company.main1;

import org.apache.ibatis.session.SqlSession;

import jp.mufg.it.mybatis.company.common.SqlSessionHolder;
import jp.mufg.it.mybatis.company.dto.Employee;
import jp.mufg.it.mybatis.company.mapper.EmployeeMapper;

/*
 * 悲観的ロック
 *
 * このプログラムを、PessimisticLockMain2よりも先に実行する
 * → 10秒間のスリープの後、正常終了し、月給は+10000円で更新される
 */
public class PessimisticLockMain1 {

    public static void main(String[] args) throws Exception {
        // SqlSessionを取得する
        SqlSession sqlSession = SqlSessionHolder.getInstance().getSqlSession();

        // Mapperを取得する
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        // SELECT文を発行し、Employeeを取得する
        Employee employee = mapper.selectEmployeeWithPessimisticLock(10001);

        // 取得したEmployeeの値（月給）を書き換える
        employee.setSalary(employee.getSalary() + 10000);

        // 意図的に15秒間スリープする
        Thread.sleep(15000);

        // UPDATE文を発行する
        mapper.updateEmployee(employee);

        // コミットする
        sqlSession.commit();
    }
}