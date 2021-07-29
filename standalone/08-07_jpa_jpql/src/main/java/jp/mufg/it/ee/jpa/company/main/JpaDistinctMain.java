package jp.mufg.it.ee.jpa.company.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

// Distinct演算子のテスト
@SuppressWarnings("unchecked")
public class JpaDistinctMain {

    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        // DISTINCTありのケース
        {
        System.out.println("===== TEST1 START =====");
        Query query = entityManager.createQuery(
                "SELECT DISTINCT a.prefecture FROM Address AS a");
        List<String> resultList = query.getResultList();
        System.out.println(resultList);
        System.out.println("===== TEST1 END =====\n");
        }

        // DISTINCTなしのケース
        {
        System.out.println("===== TEST2 START =====");
        Query query = entityManager.createQuery(
                "SELECT a.prefecture FROM Address AS a");
        List<String> resultList = query.getResultList();
        System.out.println(resultList);
        System.out.println("===== TEST2 END =====\n");
        }
    }
}