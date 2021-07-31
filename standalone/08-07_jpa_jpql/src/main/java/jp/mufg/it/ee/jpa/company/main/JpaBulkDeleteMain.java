package jp.mufg.it.ee.jpa.company.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JpaBulkDeleteMain {
    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        // エンティティトランザクションを開始する
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        // バルクで削除する
        Query query = entityManager.createQuery(
                "DELETE FROM Employee AS e " +
                "WHERE :salary <= e.salary")
                .setParameter("salary", 400000);
        int hitCount = query.executeUpdate();
        System.out.println("ヒット件数 => " + hitCount); // 更新結果を表示

        // エンティティトランザクションをコミットする
        entityTransaction.commit();

        // エンティティマネージャをクローズする
        entityManager.close();
    }
}