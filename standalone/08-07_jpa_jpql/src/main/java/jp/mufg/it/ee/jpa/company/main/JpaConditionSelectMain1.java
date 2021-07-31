package jp.mufg.it.ee.jpa.company.main;

import static jp.mufg.it.ee.jpa.company.util.ResultUtil.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jp.mufg.it.ee.jpa.company.entity.Employee;

public class JpaConditionSelectMain1 {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        // 条件検索する
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "WHERE :lowerSalary <= e.salary " +
                "AND e.salary <= :upperSalary")
                .setParameter("lowerSalary", 300000)
                .setParameter("upperSalary", 400000);
        List<Employee> resultList = query.getResultList();
        showEmployeeList(resultList); // 検索結果を表示

        // エンティティマネージャをクローズする
        entityManager.close();
    }
}