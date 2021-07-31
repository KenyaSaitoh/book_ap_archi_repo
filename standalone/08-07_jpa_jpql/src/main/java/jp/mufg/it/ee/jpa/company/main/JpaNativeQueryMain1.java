package jp.mufg.it.ee.jpa.company.main;

import static jp.mufg.it.ee.jpa.company.util.ResultUtil.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

// ネイティブクエリのテスト
@SuppressWarnings("unchecked")
public class JpaNativeQueryMain1 {

    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        // NATIVE QUERY 1
        {
        System.out.println("##### TEST1 START #####");
        Query query = entityManager.createNativeQuery(
                "SELECT EMPLOYEE_NAME FROM EMPLOYEE " +
                "WHERE EMPLOYEE_ID = ?1")
                .setParameter(1, 10001);
        String result = (String)query.getSingleResult();
        System.out.println(result); // 検索結果を表示
        System.out.println("##### TEST1 END #####\n");
        }

        // NATIVE QUERY 2
        {
        System.out.println("##### TEST2 START #####");
        Query query = entityManager.createNativeQuery(
                "SELECT EMPLOYEE_NAME FROM EMPLOYEE " +
                "WHERE DEPARTMENT_ID = ?1")
                .setParameter(1, 2);
        List<Object> resultList = (List<Object>)query.getResultList();
        showObjectList(resultList); // 検索結果を表示
        System.out.println("##### TEST2 END #####\n");
        }

        // NATIVE QUERY 3
        {
        System.out.println("##### TEST3 START #####");
        Query query = entityManager.createNativeQuery(
                "SELECT EMPLOYEE_NAME, SALARY FROM EMPLOYEE " +
                "WHERE EMPLOYEE_ID = ?1")
                .setParameter(1, 10001);
        Object[] result = (Object[])query.getSingleResult();
        showObjectArray(result); // 検索結果を表示
        System.out.println("##### TEST3 END #####\n");
        }

        // NATIVE QUERY 4
        {
        System.out.println("##### TEST4 START #####");
        Query query = entityManager.createNativeQuery(
                "SELECT EMPLOYEE_NAME, SALARY FROM EMPLOYEE " +
                "WHERE DEPARTMENT_ID = ?1")
                .setParameter(1, 2);
        List<Object[]> resultList = (List<Object[]>)query.getResultList();
        showObjectArrayList(resultList); // 検索結果を表示
        System.out.println("##### TEST4 END #####\n");
        }
    }
}