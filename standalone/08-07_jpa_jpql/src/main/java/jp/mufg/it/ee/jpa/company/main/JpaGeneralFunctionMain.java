package jp.mufg.it.ee.jpa.company.main;

import static jp.mufg.it.ee.jpa.company.util.ResultUtil.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jp.mufg.it.ee.jpa.company.entity.Department;
import jp.mufg.it.ee.jpa.company.entity.Employee;

// 機能関数のテスト
@SuppressWarnings("unchecked")
public class JpaGeneralFunctionMain {

    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        // LENGTH
        {
        System.out.println("##### TEST1 START #####");
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "WHERE 5 < LENGTH(e.employeeName)");
        List<Employee> resultList = query.getResultList();
        showEmployeeList(resultList); // 検索結果を表示
        System.out.println("##### TEST1 END #####\n");
        }

        // SIZE
        {
        System.out.println("##### TEST2 START #####");
        Query query = entityManager.createQuery(
                "SELECT d FROM Department AS d " +
                "WHERE SIZE(d.employees) = 5");
        List<Department> resultList = query.getResultList();
        showDepartmentList(resultList); // 検索結果を表示
        System.out.println("##### TEST2 END #####\n");
        }

        // SUBSTRING
        {
        System.out.println("##### TEST3 START #####");
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "WHERE SUBSTRING(e.employeeName, 2, 1) = 'a'");
        List<Employee> resultList = query.getResultList();
        showEmployeeList(resultList); // 検索結果を表示
        System.out.println("##### TEST3 END #####\n");
        }
    }
}