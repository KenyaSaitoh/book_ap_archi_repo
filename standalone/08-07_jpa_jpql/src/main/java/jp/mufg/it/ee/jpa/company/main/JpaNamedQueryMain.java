package jp.mufg.it.ee.jpa.company.main;

import static jp.mufg.it.ee.jpa.company.util.ResultUtil.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jp.mufg.it.ee.jpa.company.entity.Employee;

// 名前付きクエリのテスト
@SuppressWarnings("unchecked")
public class JpaNamedQueryMain {

    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        // 名前付きクエリ
        Query query = entityManager.createNamedQuery("findEmployeesBysalary")
                .setParameter("salary", 400000);
        List<Employee> resultList = query.getResultList();
        showEmployeeList(resultList); // 検索結果を表示
    }
}