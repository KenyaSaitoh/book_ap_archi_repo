package jp.mufg.it.ee.jpa.company.main;

import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jp.mufg.it.ee.jpa.company.entity.Employee;
import jp.mufg.it.ee.jpa.company.type.JobType;


public class JpaInsertMain {

    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager em = emf.createEntityManager();

        // エンティティトランザクションを開始する
        EntityTransaction et = em.getTransaction();
        et.begin();

        // 挿入対象のEmployeeクラスのインスタンスを生成する
        Calendar cal = Calendar.getInstance();
        cal.set(2017, 11, 1);
        Employee employee = new Employee(10021, "Steve", "総務部",
                new Date(cal.getTimeInMillis()), JobType.LEADER, 380000);
        // persistメソッドに、生成したEmployeeインスタンスを渡す
        em.persist(employee);

        // エンティティトランザクションをコミットする
        et.commit();

        // エンティティマネージャをクローズする
        em.close();
    }
}