package jp.mufg.it.ee.jpa.company.main;

import static jp.mufg.it.ee.jpa.company.util.ResultUtil.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

// パス式のテスト
public class JpaPathExpressionMain {

    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        // パス式
        {
        Query query = entityManager.createQuery(
                "SELECT e.employeeId, e.employeeName, " +
                "e.department.departmentName " +
                "FROM Employee AS e " +
                "WHERE e.employeeId = :employeeId")
                .setParameter("employeeId", 10006);
        Object[] objs = (Object[])query.getSingleResult();
        showObjectArray(objs); // 検索結果を表示
        }
    }
}