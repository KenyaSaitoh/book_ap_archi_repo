package jp.mufg.it.ee.jpa.company.main;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

// 集合関数のテスト
public class JpaAggregateFunctionMain {

    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        // COUNT 1
        {
        System.out.println("[ test1 ] Start");
        Query query = entityManager.createQuery(
                "SELECT COUNT(e) FROM Employee e ");
        Long result = (Long)query.getSingleResult();
        System.out.println(result);
        System.out.println("[ test1 End ]");
        }

        // COUNT 2
        {
        System.out.println("[ test2 ] Start");
        Query query = entityManager.createQuery(
                "SELECT COUNT(DISTINCT e.department.departmentId) " +
                "FROM Employee e ");
        Long result = (Long)query.getSingleResult();
        System.out.println(result);
        System.out.println("[ test2 End ]");
        }

        // AVG
        {
        System.out.println("[ test3 ] Start");
        Query query = entityManager.createQuery(
                "SELECT AVG(e.salary) FROM Employee e ");
        Double result = (Double)query.getSingleResult();
        System.out.println(result);
        System.out.println("[ test3 End ]");
        }

        // MIN 1
        {
        System.out.println("[ test4 ] Start");
        Query query = entityManager.createQuery(
                "SELECT MIN(e.salary) FROM Employee e ");
        Integer result = (Integer)query.getSingleResult();
        System.out.println(result);
        System.out.println("[ test4 End ]");
        }

        // MIN 2
        {
        System.out.println("[ test5 ] Start");
        Query query = entityManager.createQuery(
                "SELECT MIN(e.entranceDate) FROM Employee e ");
        Date result = (Date)query.getSingleResult();
        System.out.println(result);
        System.out.println("[ test5 End ]");
        }

        // MAX
        {
        System.out.println("[ test6 ] Start");
        Query query = entityManager.createQuery(
                "SELECT MAX(e.salary) FROM Employee e ");
        Integer result = (Integer)query.getSingleResult();
        System.out.println(result);
        System.out.println("[ test6 End ]");
        }

        // SUM
        {
        System.out.println("[ test7 ] Start");
        Query query = entityManager.createQuery(
                "SELECT SUM(e.salary) FROM Employee e ");
        Long result = (Long)query.getSingleResult();
        System.out.println(result);
        System.out.println("[ test7 End ]");
        }
    }
}