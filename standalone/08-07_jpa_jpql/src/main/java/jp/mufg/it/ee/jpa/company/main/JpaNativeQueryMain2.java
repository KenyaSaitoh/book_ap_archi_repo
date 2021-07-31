package jp.mufg.it.ee.jpa.company.main;

import static jp.mufg.it.ee.jpa.company.util.ResultUtil.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jp.mufg.it.ee.jpa.company.entity.EmployeeQueryResult1;

// ネイティブクエリのテスト
@SuppressWarnings("unchecked")
public class JpaNativeQueryMain2 {

    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        // SQL RESULT CLASS
        {
        System.out.println("##### TEST6 START #####");
        Query query = entityManager.createNativeQuery(
                "SELECT e.EMPLOYEE_ID AS E_EMPLOYEE_ID, " +
                "e.EMPLOYEE_NAME AS E_EMPLOYEE_NAME, " +
                "d.DEPARTMENT_NAME AS D_DEPARTMENT_NAME " +
                "FROM EMPLOYEE e, DEPARTMENT d " +
                "WHERE e.DEPARTMENT_ID = d.DEPARTMENT_ID " +
                "AND e.EMPLOYEE_ID = ?1",
                EmployeeQueryResult1.class)
                .setParameter(1, 10006);
        List<EmployeeQueryResult1> resultList = query.getResultList();
        showEmployeeQueryResultList1(resultList); // 検索結果を表示
        System.out.println("##### TEST6 END #####\n");
        }
    }
}