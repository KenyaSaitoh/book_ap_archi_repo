package jp.mufg.it.ee.jpa.company.main2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.OptimisticLockException;
import javax.persistence.Persistence;

import jp.mufg.it.ee.jpa.company.entity.Employee;

/*
 * 楽観的ロック
 *
 * このプログラムを、OptimisticLockMain2よりも先に実行する
 * → 正常終了し、月給は+10000円で更新される
 */
public class OptimisticLockMain1 {

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
        Employee employee = entityManager.find(Employee.class, 10001);

        // 取得したEmployeeの値（月給）を書き換える
        employee.setSalary(employee.getSalary() + 10000);

        // 意図的に10秒間スリープする
        Thread.sleep(10000);

        try {
            // UPDATE文を発行する
            entityManager.flush();
        } catch(OptimisticLockException ole) {
            throw new RuntimeException("楽観ロックエラー発生", ole);
        }

        // コミットする
        entityTransaction.commit();
    }
}