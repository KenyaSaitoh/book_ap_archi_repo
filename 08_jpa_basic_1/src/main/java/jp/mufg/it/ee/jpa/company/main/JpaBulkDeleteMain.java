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
        EntityManager em = emf.createEntityManager();

        // エンティティトランザクションを開始する
        EntityTransaction et = em.getTransaction();
        et.begin();

        // バルクで削除する
        Query query = em.createQuery(
                "DELETE FROM Employee AS e " +
                "WHERE :salary <= e.salary")
                .setParameter("salary", 400000);
        int hitCount = query.executeUpdate();
        System.out.println("ヒット件数 ---> " + hitCount);

        // エンティティトランザクションをコミットする
        et.commit();

        // エンティティマネージャをクローズする
        em.close();
    }
}