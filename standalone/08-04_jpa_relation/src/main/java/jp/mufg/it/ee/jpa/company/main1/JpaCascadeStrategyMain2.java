package jp.mufg.it.ee.jpa.company.main1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jp.mufg.it.ee.jpa.company.entity.Department;
import jp.mufg.it.ee.jpa.company.entity.Employee;
import jp.mufg.it.ee.jpa.company.type.JobType;

// カスケードのテスト
public class JpaCascadeStrategyMain2 {

    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        // エンティティトランザクションを開始する
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        // persist操作（INSERT）、One側からカスケード
        List<Employee> employees = new ArrayList<>();
        Department department = new Department(7, "営業第三部", "東京本社",
                employees, 0L);
        Calendar cal = Calendar.getInstance();
        cal.set(2017, 11, 1);
        Employee employee = new Employee(10016, "Trent", department,
                new Date(cal.getTimeInMillis()), JobType.CHIEF, 310000, 0L);
        department.getEmployees().add(employee);
        entityManager.persist(department);

        // コミットする
        entityTransaction.commit();
    }
}