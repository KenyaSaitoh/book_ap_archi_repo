package jp.mufg.it.ee.jpa.company.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

// ネイティブクエリのテスト
public class JpaNativeQueryMain4 {

    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        // エンティティトランザクションを開始する
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        // NATIVE QUERY
        Query query = entityManager.createNativeQuery(
                "UPDATE EMPLOYEE " +
                "SET SALARY = SALARY + ?3 " +
                "WHERE DEPARTMENT_ID = ?1")
                .setParameter(3, 2000)
                .setParameter(1, 2);
        int updateCount = query.executeUpdate();
        System.out.println("ヒット件数 => " + updateCount); // 更新結果を表示

        // エンティティトランザクションをコミットする
        entityTransaction.commit();

        // エンティティマネージャをクローズする
        entityManager.close();
    }
}