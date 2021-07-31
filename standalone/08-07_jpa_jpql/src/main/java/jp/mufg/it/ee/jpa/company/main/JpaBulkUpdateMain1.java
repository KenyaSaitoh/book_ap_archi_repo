package jp.mufg.it.ee.jpa.company.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JpaBulkUpdateMain1 {
    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        // エンティティトランザクションを開始する
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        // バルクで更新する
        Query query = entityManager.createQuery(
                "UPDATE Employee AS e " +
                "SET e.salary = e.salary + :increase " +
                "WHERE e.salary <= :salary")
                .setParameter("increase", 2000)
                .setParameter("salary", 300000);
        int updateCount = query.executeUpdate();
        // 更新結果を表示
        System.out.println("ヒット件数 => " + updateCount);

        // エンティティトランザクションをコミットする
        entityTransaction.commit();

        // エンティティマネージャをクローズする
        entityManager.close();
    }
}