package jp.mufg.it.ee.jpa.company.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jp.mufg.it.ee.jpa.company.entity.Employee;
import jp.mufg.it.ee.jpa.company.util.ResultUtil;

public class JpaBulkUpdateMain2 {
    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager em = emf.createEntityManager();

        // エンティティトランザクションを開始する
        EntityTransaction et = em.getTransaction();
        et.begin();

        Employee employee = em.find(Employee.class, 10001);

        // バルクで更新する
        Query query = em.createQuery(
                "UPDATE Employee AS e " +
                "SET e.salary = e.salary + :increase")
                .setParameter("increase", 2000);
        query.executeUpdate();

        em.flush();

        // Employeeインスタンスの永続フィールドの値を書き換える
        employee.setSalary(employee.getSalary() + 10000);

        // エンティティトランザクションをコミットする
        et.commit();

        ResultUtil.showEmployee(employee);

        // エンティティマネージャをクローズする
        em.close();
    }
}