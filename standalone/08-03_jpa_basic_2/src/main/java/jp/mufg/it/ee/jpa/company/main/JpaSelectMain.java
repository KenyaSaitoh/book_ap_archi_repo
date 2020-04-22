package jp.mufg.it.ee.jpa.company.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jp.mufg.it.ee.jpa.company.entity.Employee;

public class JpaSelectMain {

    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager em = emf.createEntityManager();

        // findメソッドによりEmployeeインスタンスを取得する
        Employee employee = em.find(Employee.class, 10001);

        // Employeeインスタンスのゲッタにより、カラム値を取得する
        String employeeName = employee.getEmployeeName();

        // 検索結果を標準出力する
        System.out.println("employeeName ---> " + employeeName);

        // エンティティマネージャをクローズする
        em.close();
    }
}