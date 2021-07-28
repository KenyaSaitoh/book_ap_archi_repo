package jp.mufg.it.ee.jpa.company.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JpaSelectCountMain2 {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        // 条件検索する
        Query query = entityManager.createQuery(
                "SELECT e.jobType, COUNT(e) FROM Employee AS e " +
                "GROUP BY e.jobType");
        List<Object[]> resultList = query.getResultList();

        // 検索結果を標準出力する
        showEmployeeList(resultList);

        // エンティティマネージャをクローズする
        entityManager.close();
    }

    private static void showEmployeeList(List<Object[]> resultList) {
        for (Object[] items : resultList) {
            for (Object item : items) {
                System.out.print(item + " / ");
            }
            System.out.println();
        }
    }
}