package jp.mufg.it.ee.jpa.company.main;

import static jp.mufg.it.ee.jpa.company.util.ResultUtil.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jp.mufg.it.ee.jpa.company.entity.Employee;

// 副問い合わせとEXISTS式のテスト
@SuppressWarnings("unchecked")
public class JpaSubQueryMain {

    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        // 副問い合わせ
        {
        System.out.println("##### TEST1 START #####");
        Query query = entityManager.createQuery(
                "SELECT e1 FROM Employee AS e1 " +
                "WHERE e1.salary >= " +
                "(SELECT AVG(e2.salary) FROM Employee AS e2)");
        List<Employee> resultList = query.getResultList();
        showEmployeeList(resultList); // 検索結果を表示
        System.out.println("##### TEST1 END #####\n");
        }

        // 副問い合わせ + EXISTS式 1
        {
        System.out.println("##### TEST2 START #####");
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "WHERE EXISTS " +
                "(SELECT d FROM Department AS d " +
                "WHERE d.employees = e AND d.departmentId = 3)");
        List<Employee> resultList = query.getResultList();
        showEmployeeList(resultList); // 検索結果を表示
        System.out.println("##### TEST2 END #####\n");
        }

        // 副問い合わせ + EXISTS式 2
        {
        System.out.println("##### TEST3 START #####");
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "WHERE EXISTS " +
                "(SELECT d FROM e.department AS d " +
                "WHERE d.departmentId = 3)");
        List<Employee> resultList = query.getResultList();
        showEmployeeList(resultList); // 検索結果を表示
        System.out.println("##### TEST3 END #####\n");
        }

        // 副問い合わせ + NOT EXISTS式 1
        {
        System.out.println("##### TEST4 START #####");
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "WHERE NOT EXISTS " +
                "(SELECT d FROM Department AS d " +
                "WHERE d.employees = e AND d.departmentId = 3)");
        List<Employee> resultList = query.getResultList();
        showEmployeeList(resultList); // 検索結果を表示
        System.out.println("##### TEST4 END #####\n");
        }

        // 副問い合わせ + NOT EXISTS式 2
        {
        System.out.println("##### TEST5 START #####");
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "WHERE NOT EXISTS " +
                "(SELECT d FROM e.department AS d " +
                "WHERE d.departmentId = 3)");
        List<Employee> resultList = query.getResultList();
        showEmployeeList(resultList); // 検索結果を表示
        System.out.println("##### TEST5 END #####\n");
        }
    }
}