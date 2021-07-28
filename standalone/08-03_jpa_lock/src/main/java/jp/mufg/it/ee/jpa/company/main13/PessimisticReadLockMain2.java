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
 * このプログラムを、PessimisticReadLockMain1の後に実行する
 * → SELECT FOR UPDATE文によりロックウェイトし、PessimisticReadLockMain1がコミットされた後、
 * 初めて参照が可能となる。
 */
public class PessimisticReadLockMain2 {

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

        // 検索結果を標準出力する
        System.out.println("employeeName ---> " + employee);
    }
}