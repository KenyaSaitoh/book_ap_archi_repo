package jp.mufg.it.ee.jpa.company.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jp.mufg.it.ee.jpa.company.entity.Parttimer;

// Single Table per Class Hierarchy戦略のテスト
public class JpaInheritanceMain2 {

    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        // エンティティトランザクションを開始する
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        // パートタイマーを検索 → 更新
        Parttimer parttimer = entityManager.find(Parttimer.class, 10021);
        parttimer.setWage(parttimer.getWage() + 200);

        // エンティティトランザクションをコミットする
        entityTransaction.commit();
        System.out.println(parttimer);
    }
}