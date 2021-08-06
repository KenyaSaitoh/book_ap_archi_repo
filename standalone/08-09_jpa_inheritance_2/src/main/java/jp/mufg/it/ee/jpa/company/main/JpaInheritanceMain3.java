package jp.mufg.it.ee.jpa.company.main;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jp.mufg.it.ee.jpa.company.entity.Department;
import jp.mufg.it.ee.jpa.company.entity.Parttimer;

// Joined Subclass戦略のテスト
public class JpaInheritanceMain3 {

    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        // エンティティトランザクションを開始する
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        // パートタイマーを挿入する
        Department department = entityManager.find(Department.class, 3);
        Calendar cal = Calendar.getInstance();
        cal.set(2017, 3, 1);
        Parttimer parttimer = new Parttimer(20003, "Zoe", department,
                new Date(cal.getTimeInMillis()), 1600);
        entityManager.persist(parttimer);

        // エンティティトランザクションをコミットする
        entityTransaction.commit();
        System.out.println(parttimer);
    }
}