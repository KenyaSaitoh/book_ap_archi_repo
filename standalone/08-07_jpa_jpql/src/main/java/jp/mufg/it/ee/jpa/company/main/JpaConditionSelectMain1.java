package jp.mufg.it.ee.jpa.company.main;

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

        // 検索結果を標準出力する
        showEmployeeList(resultList);

        // エンティティマネージャをクローズする
        entityManager.close();
    }

    private static void showEmployeeList(List<Employee> resultList) {
        for (Employee employee : resultList) {
            System.out.println(employee);
        }
    }
}