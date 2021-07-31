package jp.mufg.it.ee.jpa.company.main;

import static jp.mufg.it.ee.jpa.company.util.ResultUtil.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

//外部結合（アウタージョイン）のテスト
@SuppressWarnings("unchecked")
public class JpaOuterJoinMain {

    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        // 外部結合（アウタージョイン）1
        {
        System.out.println("##### TEST1 START #####");
        Query query = entityManager.createQuery(
                "SELECT e.employeeId, e.employeeName, d.departmentName " +
                "FROM Employee AS e LEFT OUTER JOIN e.department AS d");
        List<Object[]> resultList = query.getResultList();
        showObjectArrayList(resultList); // 検索結果を表示
        System.out.println("##### TEST1 END #####\n");
        }

        // 外部結合（アウタージョイン）2
        {
        System.out.println("##### TEST2 START #####");
        Query query = entityManager.createQuery(
                "SELECT e.employeeId, e.employeeName, d.departmentName " +
                "FROM Department AS d LEFT OUTER JOIN d.employees AS e");
        List<Object[]> resultList = query.getResultList();
        showObjectArrayList(resultList); // 検索結果を表示
        System.out.println("##### TEST2 END #####\n");
        }
    }
}