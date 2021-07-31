package jp.mufg.it.ee.jpa.company.main;

import static jp.mufg.it.ee.jpa.company.util.ResultUtil.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jp.mufg.it.ee.jpa.company.entity.EmployeeCountTO;

// グルーピングのテスト
@SuppressWarnings("unchecked")
public class JpaGroupByMain {

    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        // グルーピング 1
        {
        System.out.println("##### TEST1 START #####");
        Query query = entityManager.createQuery(
                "SELECT e.department, COUNT(e) " +
                "FROM Employee AS e " +
                "GROUP BY e.department");
        List<Object[]> resultList = query.getResultList();
        showObjectArrayList(resultList); // 検索結果を表示
        System.out.println("##### TEST1 END #####\n");
        }

        //  グルーピング 2
        {
        System.out.println("##### TEST2 START #####");
        Query query = entityManager.createQuery(
                "SELECT e.department.departmentId, COUNT(e) " +
                "FROM Employee AS e " +
                "GROUP BY e.department.departmentId");
        List<Object[]> resultList = query.getResultList();
        showObjectArrayList(resultList); // 検索結果を表示
        System.out.println("##### TEST2 END #####\n");
        }

        // グルーピング 3
        {
        System.out.println("##### TEST3 START #####");
        Query query = entityManager.createQuery(
                "SELECT NEW jp.mufg.it.ee.jpa.company.entity.EmployeeCountTO" +
                "(e.department.departmentId, COUNT(e)) " +
                "FROM Employee AS e " +
                "GROUP BY e.department.departmentId " +
                "HAVING COUNT(e.department.departmentId) <= 3");
        List<EmployeeCountTO> resultList = query.getResultList();
        showEmployeeCountTOList(resultList); // 検索結果を表示
        System.out.println("##### TEST3 END #####\n");
    }

        // グルーピング 4
        {
        System.out.println("##### TEST4 START #####");
        Query query = entityManager.createQuery(
                "SELECT e.department.departmentId, COUNT(e) " +
                "FROM Employee AS e " +
                "GROUP BY e.department.departmentId " +
                "HAVING COUNT(e.department.departmentId) <= 3");
        List<Object[]> resultList = query.getResultList();
        showObjectArrayList(resultList); // 検索結果を表示
        System.out.println("##### TEST4 END #####\n");
        }
    }
}