package jp.mufg.it.ee.jpa.company.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JpaBulkUpdateMain {
    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager em = emf.createEntityManager();

        // エンティティトランザクションを開始する
        EntityTransaction et = em.getTransaction();
        et.begin();

        // バルクで更新する
        Query query = em.createQuery(
                "UPDATE Employee AS e " +
                "SET e.salary = e.salary + :increase " +
                "WHERE e.salary <= :salary")
                .setParameter("increase", 2000)
                .setParameter("salary", 300000);
        int updateCount = query.executeUpdate();
        System.out.println("ヒット件数 ---> " + updateCount);

        // エンティティトランザクションをコミットする
        et.commit();

        // エンティティマネージャをクローズする
        em.close();
    }
}