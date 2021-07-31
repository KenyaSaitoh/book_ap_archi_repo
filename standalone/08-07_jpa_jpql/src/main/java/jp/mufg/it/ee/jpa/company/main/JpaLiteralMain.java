package jp.mufg.it.ee.jpa.company.main;

import static jp.mufg.it.ee.jpa.company.util.ResultUtil.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jp.mufg.it.ee.jpa.company.entity.Employee;

// 日付リテラルのテスト
public class JpaLiteralMain {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        Query query = entityManager.createQuery("SELECT e FROM Employee AS e "
                + "WHERE {d '2015-01-01'} <= e.entranceDate");
        List<Employee> resultList = query.getResultList();
        showEmployeeList(resultList); // 検索結果を表示
    }
}