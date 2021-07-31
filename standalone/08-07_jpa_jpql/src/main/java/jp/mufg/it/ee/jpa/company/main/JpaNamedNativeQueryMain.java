package jp.mufg.it.ee.jpa.company.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jp.mufg.it.ee.jpa.company.entity.EmployeeQueryResult1;
import jp.mufg.it.ee.jpa.company.entity.EmployeeQueryResult2;

// 名前付きクエリのテスト
public class JpaNamedNativeQueryMain {

    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        // 名前付きクエリで結果クラスを使用
        {
        System.out.println("##### TEST1 START #####");
        Query query = entityManager.createNamedQuery("findEmployeesByDepartmentId1")
                .setParameter(1, 10006); // EMPLOYEE_IDに10006をセットする
        EmployeeQueryResult1 result =
                (EmployeeQueryResult1)query.getSingleResult();
        System.out.println(result); // 検索結果を表示
        System.out.println("##### TEST1 END #####\n");
        }

        // 名前付きクエリで結果セットマッピングを使用
        {
        System.out.println("##### TEST2 START #####");
        Query query = entityManager.createNamedQuery("findEmployeesByDepartmentId2")
                .setParameter(1, 10006); // EMPLOYEE_IDに10006をセットする
        EmployeeQueryResult2 result =
                (EmployeeQueryResult2)query.getSingleResult();
        System.out.println(result); // 検索結果を表示
        System.out.println("##### TEST2 END #####\n");
        }
    }
}