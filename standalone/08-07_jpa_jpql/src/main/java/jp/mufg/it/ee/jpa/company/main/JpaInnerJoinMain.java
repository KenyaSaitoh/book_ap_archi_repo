package jp.mufg.it.ee.jpa.company.main;

import static jp.mufg.it.ee.jpa.company.util.ResultUtil.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

// 内部結合のテスト
@SuppressWarnings("unchecked")
public class JpaInnerJoinMain {

    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        // SINGLE RESULT
        {
        System.out.println("##### TEST1 START #####");
        Query query = entityManager.createQuery(
                "SELECT e.employeeId, e.employeeName, d.departmentName " +
                "FROM Employee AS e INNER JOIN e.department AS d " +
                "WHERE e.employeeId = :employeeId")
                .setParameter("employeeId", 10005);
        Object[] result = (Object[])query.getSingleResult();
        showObjectArray(result); // 検索結果を表示
        System.out.println("##### TEST1 END #####\n");
        }

        // LIST RESULT 1
        {
        System.out.println("##### TEST2 START #####");
        Query query = entityManager.createQuery(
                "SELECT e.employeeId, e.employeeName, d.departmentName " +
                "FROM Employee AS e INNER JOIN e.department AS d " +
                "WHERE d.departmentId = :departmentId")
                .setParameter("departmentId", 2);
        List result = query.getResultList();
        showObjectArrayList(result); // 検索結果を表示
        System.out.println("##### TEST2 END #####\n");
        }

        // LIST RESULT 2
        {
        System.out.println("##### TEST3 START #####");
        Query query = entityManager.createQuery(
                "SELECT e.employeeId, e.employeeName, d.departmentName " +
                "FROM Department AS d INNER JOIN d.employees AS e " +
                "WHERE d.departmentId = :departmentId")
                .setParameter("departmentId", 2);
        List resultList = query.getResultList();
        showObjectArrayList(resultList); // 検索結果を表示
        System.out.println("##### TEST3 END #####\n");
        }

        // IN OPERATOR
        {
        System.out.println("##### TEST4 START #####");
        Query query = entityManager.createQuery(
                "SELECT e.employeeId, e.employeeName, d.departmentName " +
                "FROM Department AS d, IN (d.employees) AS e " +
                "WHERE d.departmentId = :departmentId")
                .setParameter("departmentId", 2);
        List resultList = query.getResultList();
        showObjectArrayList(resultList); // 検索結果を表示
        System.out.println("##### TEST4 END #####\n");
        }
    }
}