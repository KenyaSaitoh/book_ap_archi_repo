package jp.mufg.it.ee.jpa.company.main1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jp.mufg.it.ee.jpa.company.entity.Employee;

//カスケードのテスト
public class JpaCascadeStrategyMain4 {

    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        // エンティティトランザクションを開始する
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        // remove操作（DELETE）、Many側からカスケード
        Employee employee = entityManager.find(Employee.class, 10001);
        entityManager.remove(employee);

        // コミットする
        entityTransaction.commit();
    }
}