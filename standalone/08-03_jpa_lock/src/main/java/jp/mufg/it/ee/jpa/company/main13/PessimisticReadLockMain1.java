package jp.mufg.it.ee.jpa.company.main13;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;

import jp.mufg.it.ee.jpa.company.entity.Employee;

/*
 * 悲観的ロック
 *
 * このプログラムを、PessimisticReadLockMain2よりも先に実行する
 * → 10秒間のスリープの後、正常終了し、月給は+10000円で更新される
 */
public class PessimisticReadLockMain1 {

    public static void main(String[] args) throws Exception {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager= emf.createEntityManager();

        // エンティティトランザクションを開始する
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        // findメソッドによりEmployeeインスタンスを取得する
        Employee employee = entityManager.find(Employee.class, 10001,
                LockModeType.PESSIMISTIC_READ);

        // 取得したEmployeeの値（月給）を書き換える
        employee.setSalary(employee.getSalary() + 10000);

        // 意図的に10秒間スリープする
        Thread.sleep(20000);

        // コミットする
        entityTransaction.commit();
    }
}