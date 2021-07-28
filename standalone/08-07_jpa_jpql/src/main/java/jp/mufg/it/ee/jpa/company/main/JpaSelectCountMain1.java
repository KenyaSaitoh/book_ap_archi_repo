package jp.mufg.it.ee.jpa.company.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JpaSelectCountMain1 {
    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        // 条件検索する
        Query query = entityManager.createQuery(
                "SELECT COUNT(e) FROM Employee AS e " +
                "WHERE e.department.departmentId = :departmentId")
                .setParameter("departmentId", 3);
        Long result = (Long)query.getSingleResult();

        // 検索結果を標準出力する
        System.out.println(result);

        // エンティティマネージャをクローズする
        entityManager.close();
    }
}