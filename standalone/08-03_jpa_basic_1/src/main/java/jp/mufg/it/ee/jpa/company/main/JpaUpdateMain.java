package jp.mufg.it.ee.jpa.company.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jp.mufg.it.ee.jpa.company.entity.Employee;

public class JpaUpdateMain {

    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager= emf.createEntityManager();

        // エンティティトランザクションを開始する
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        // findメソッドにより更新対象のEmployeeインスタンスを取得する
        Employee employee = entityManager.find(Employee.class, 10001);

        // Employeeインスタンスの永続フィールドの値を書き換える
        employee.setSalary(employee.getSalary() + 10000);

        // エンティティトランザクションをコミットする
        entityTransaction.commit();

        // エンティティマネージャをクローズする
        entityManager.close();
    }
}