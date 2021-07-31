package jp.mufg.it.ee.jpa.company.main;

import static jp.mufg.it.ee.jpa.company.util.ResultUtil.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jp.mufg.it.ee.jpa.company.entity.Employee;

// ソート（ORDER BY）のテスト
@SuppressWarnings("unchecked")
public class JpaOrderByMain {

    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        // ソート（ORDER BY） 1
        {
        System.out.println("##### TEST1 START #####");
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "ORDER BY e.department.departmentId");
        List<Employee> resultList = query.getResultList();
        showEmployeeList(resultList);
        System.out.println("##### TEST1 END #####\n"); // 検索結果を表示
        }

        // ソート（ORDER BY） 2
        {
        System.out.println("##### TEST2 START #####");
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "ORDER BY e.department.departmentId, e.salary");
        List<Employee> resultList = query.getResultList();
        showEmployeeList(resultList); // 検索結果を表示
        System.out.println("##### TEST2 END #####\n");
        }

        // ソート（ORDER BY） 3
        {
        System.out.println("##### TEST3 START #####");
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "ORDER BY e.salary DESC")
                .setFirstResult(4)
                .setMaxResults(3);
        List<Employee> resultList = query.getResultList();
        showEmployeeList(resultList); // 検索結果を表示
        System.out.println("##### TEST3 END #####\n");
        }
    }
}