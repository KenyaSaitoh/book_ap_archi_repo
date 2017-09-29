package org.study.ee.jpa.company.main;

import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.study.ee.jpa.company.entity.Employee;
import org.study.ee.jpa.company.type.JobType;


public class JpaInsertMain {

    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する。
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する。
        EntityManager em = emf.createEntityManager();

        // エンティティトランザクションを開始する。
        EntityTransaction et = em.getTransaction();
        et.begin();

        // 挿入対象のEmployeeクラスのオブジェクトを生成する（①）。
        Calendar cal = Calendar.getInstance();
        cal.set(2006, 3, 1);
        Employee employee = new Employee(10031, "ふくもと けんじ",
                "基盤技術部", new Date(cal.getTimeInMillis()),
                JobType.PROGRAMMER, 270000);

        // persistメソッドに、生成したEmployeeオブジェクトを渡す（②）。
        em.persist(employee);

        // エンティティトランザクションをコミットする。
        et.commit();

        // エンティティマネージャをクローズする。
        em.close();
    }
}