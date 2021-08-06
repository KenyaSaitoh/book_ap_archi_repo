package jp.mufg.it.ee.jpa.company.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jp.mufg.it.ee.jpa.company.entity.Fulltimer;

// Table per Concrete Class戦略のテスト
public class JpaInheritanceMain1 {

    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        // エンティティトランザクションを開始する
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        // フルタイマーを検索 → 更新
        Fulltimer fulltimer = entityManager.find(Fulltimer.class, 10001);
        fulltimer.setSalary(fulltimer.getSalary() + 5000);

        // エンティティトランザクションをコミットする
        entityTransaction.commit();
        System.out.println(fulltimer);
    }
}