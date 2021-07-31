package jp.mufg.it.ee.jpa.company.main;

import static jp.mufg.it.ee.jpa.company.util.ResultUtil.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jp.mufg.it.ee.jpa.company.entity.EmployeeQueryResult2;

// ネイティブクエリのテスト
@SuppressWarnings("unchecked")
public class JpaNativeQueryMain3 {

    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        // SQL RESULT SET MAPPING 1
        {
        System.out.println("##### TEST7 START #####");
        // ネイティブクエリを生成する
        Query query = entityManager.createNativeQuery(
                "SELECT e.EMPLOYEE_ID AS E_EMPLOYEE_ID, " +
                "e.EMPLOYEE_NAME AS E_EMPLOYEE_NAME, " +
                "d.DEPARTMENT_NAME AS D_DEPARTMENT_NAME, " +
                "e.SALARY AS E_SALARY, " +
                "d.LOCATION AS D_LOCATION " +
                "FROM EMPLOYEE e, DEPARTMENT d " +
                "WHERE e.DEPARTMENT_ID = d.DEPARTMENT_ID " +
                "AND e.EMPLOYEE_ID = ?1",
                "NativeQueryResult1")
                .setParameter(1, 10006); // EMPLOYEE_IDに10006をセットする
        List<EmployeeQueryResult2> resultList =
                (List<EmployeeQueryResult2>)query.getResultList();
        showEmployeeQueryResultList2(resultList); // 検索結果を表示
        System.out.println("##### TEST7 END #####\n");
        }

        // SQL RESULT SET MAPPING 2
        {
        System.out.println("##### TEST8 START #####");
        // ネイティブクエリを生成する
        Query query = entityManager.createNativeQuery(
                "SELECT e.SALARY AS E_SALARY, " +
                "d.LOCATION AS D_LOCATION " +
                "FROM EMPLOYEE e, DEPARTMENT d " +
                "WHERE e.DEPARTMENT_ID = d.DEPARTMENT_ID " +
                "AND e.EMPLOYEE_ID = ?1",
                "NativeQueryResult2")
                .setParameter(1, 10006);  // EMPLOYEE_IDに10006をセットする
        List<Object[]> resultList = (List<Object[]>)query.getResultList();
        showObjectArrayList(resultList); // 検索結果を表示
        System.out.println("##### TEST8 END #####\n");
        }

        // SQL RESULT SET MAPPING 3
        {
        System.out.println("##### TEST9 START #####");
        // ネイティブクエリを生成する
        Query query = entityManager.createNativeQuery(
                "SELECT e.EMPLOYEE_ID AS E_EMPLOYEE_ID, " +
                "e.EMPLOYEE_NAME AS E_EMPLOYEE_NAME, " +
                "d.DEPARTMENT_NAME AS D_DEPARTMENT_NAME, " +
                "e.SALARY AS E_SALARY, " +
                "d.LOCATION AS D_LOCATION " +
                "FROM EMPLOYEE e, DEPARTMENT d " +
                "WHERE e.DEPARTMENT_ID = d.DEPARTMENT_ID " +
                "AND e.EMPLOYEE_ID = ?1",
                "NativeQueryResult3")
                .setParameter(1, 10006);  // EMPLOYEE_IDに10006をセットする
        List<Object[]> resultList = (List<Object[]>)query.getResultList();
        showObjectArrayList(resultList); // 検索結果を表示
        System.out.println("##### TEST9 END #####\n");
        }
    }
}