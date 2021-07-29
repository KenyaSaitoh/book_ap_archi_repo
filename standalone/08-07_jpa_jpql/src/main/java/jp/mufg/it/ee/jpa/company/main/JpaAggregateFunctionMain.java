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
        System.out.println("===== TEST1 START =====");
        Query query = entityManager.createQuery(
                "SELECT COUNT(e) FROM Employee e ");
        Long result = (Long)query.getSingleResult();
        System.out.println(result);
        System.out.println("===== TEST1 END =====\n");
        }

        // COUNT 2
        {
        System.out.println("===== TEST2 START =====");
        Query query = entityManager.createQuery(
                "SELECT COUNT(DISTINCT e.department.departmentId) " +
                "FROM Employee e ");
        Long result = (Long)query.getSingleResult();
        System.out.println(result);
        System.out.println("===== TEST2 END =====\n");
        }

        // AVG
        {
        System.out.println("===== TEST3 START =====");
        Query query = entityManager.createQuery(
                "SELECT AVG(e.salary) FROM Employee e ");
        Double result = (Double)query.getSingleResult();
        System.out.println(result);
        System.out.println("===== TEST3 END =====\n");
        }

        // MIN 1
        {
        System.out.println("===== TEST4 START =====");
        Query query = entityManager.createQuery(
                "SELECT MIN(e.salary) FROM Employee e ");
        Integer result = (Integer)query.getSingleResult();
        System.out.println(result);
        System.out.println("===== TEST4 END =====\n");
        }

        // MIN 2
        {
        System.out.println("===== TEST5 START =====");
        Query query = entityManager.createQuery(
                "SELECT MIN(e.entranceDate) FROM Employee e ");
        Date result = (Date)query.getSingleResult();
        System.out.println(result);
        System.out.println("===== TEST5 END =====\n");
        }

        // MAX
        {
        System.out.println("===== TEST6 START =====");
        Query query = entityManager.createQuery(
                "SELECT MAX(e.salary) FROM Employee e ");
        Integer result = (Integer)query.getSingleResult();
        System.out.println(result);
        System.out.println("===== TEST6 END =====\n");
        }

        // SUM
        {
        System.out.println("===== TEST7 START =====");
        Query query = entityManager.createQuery(
                "SELECT SUM(e.salary) FROM Employee e ");
        Long result = (Long)query.getSingleResult();
        System.out.println(result);
        System.out.println("===== TEST7 END =====\n");
        }
    }
}