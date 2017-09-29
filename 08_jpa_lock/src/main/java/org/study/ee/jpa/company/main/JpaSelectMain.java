package org.study.ee.jpa.company.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.study.ee.jpa.company.entity.Employee;

public class JpaSelectMain {

    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する。
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する。
        EntityManager em = emf.createEntityManager();

        // findメソッドによりEmployeeオブジェクトを取得する。（①）
        Employee employee = em.find(Employee.class, 10001);

        // Employeeオブジェクトのゲッタにより、カラム値を取得する。（②）
        String employeeName = employee.getEmployeeName();

        // 検索結果を標準出力する。
        System.out.println("employeeName ---> " + employeeName);

        // エンティティマネージャをクローズする。
        em.close();
    }
}