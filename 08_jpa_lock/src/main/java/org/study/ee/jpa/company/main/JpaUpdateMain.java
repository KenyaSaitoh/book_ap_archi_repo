package org.study.ee.jpa.company.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.study.ee.jpa.company.entity.Employee;

public class JpaUpdateMain {

    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する。
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する。
        EntityManager em = emf.createEntityManager();

        // エンティティトランザクションを開始する。
        EntityTransaction et = em.getTransaction();
        et.begin();

        // findメソッドにより更新対象のEmployeeオブジェクトを取得する（①）。
        Employee employee = em.find(Employee.class, 10001);

        // Employeeオブジェクトの永続フィールドの値を書き換える（②）。
        employee.setMonthlySalary(employee.getMonthlySalary() + 10000);

        // エンティティトランザクションをコミットする。
        et.commit();

        // エンティティマネージャをクローズする。
        em.close();
    }
}