package jp.mufg.it.mybatis.company.main;


import org.apache.ibatis.session.SqlSession;

import jp.mufg.it.mybatis.company.common.SqlSessionHolder;
import jp.mufg.it.mybatis.company.dto.Employee;
import jp.mufg.it.mybatis.company.mapper.EmployeeMapper;

/*
 * 楽観的ロック
 *
 * このプログラムを、OptimisticLockMain1の後に実行する
 * → 楽観的ロックにより異常終了し、月給は更新されない
 */
public class OptimisticLockMain2 {

    public static void main(String[] args) throws Exception {
        // SqlSessionを取得する
        SqlSession sqlSession = SqlSessionHolder.getInstance().getSqlSession();

        // Mapperを取得する
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        // SELECT文を発行し、Employeeを取得する
        Employee employee = mapper.selectEmployee(10001);

        // 取得したEmployeeの値（月給）を書き換える
        employee.setSalary(employee.getSalary() + 5000);

        // 意図的に10秒間スリープする
        Thread.sleep(10000);

        // UPDATE文を発行する
        int hitCount = mapper.updateEmployeeWithOptimisticLock(employee);

        // ヒット件数をチェックし、1件ではなかった場合は例外をスローする（ロールバック）
        if (hitCount != 1) {
            throw new RuntimeException("楽観ロックエラー発生");
        }

        // コミットする
        sqlSession.commit();
    }
}