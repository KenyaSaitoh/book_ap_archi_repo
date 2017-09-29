package org.study.ee.jpa.company.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.study.ee.jpa.company.entity.Employee;
import org.study.ee.jpa.company.test.util.ResultUtil;

public class JpaBulkUpdateMain2 {
    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する。
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する。
        EntityManager em = emf.createEntityManager();

        // エンティティトランザクションを開始する。
        EntityTransaction et = em.getTransaction();
        et.begin();

        Employee employee = em.find(Employee.class, 10001);

        // バルクで更新する。
        Query query = em.createQuery(
                "UPDATE Employee AS e " +
                "SET e.monthlySalary = e.monthlySalary + :increase")
                .setParameter("increase", 2000);
        query.executeUpdate();

        em.flush();

        // Employeeオブジェクトの永続フィールドの値を書き換える（②）。
        employee.setMonthlySalary(employee.getMonthlySalary() + 10000);

        // エンティティトランザクションをコミットする。
        et.commit();

        ResultUtil.showEmployee(employee);

        // エンティティマネージャをクローズする。
        em.close();
    }
}