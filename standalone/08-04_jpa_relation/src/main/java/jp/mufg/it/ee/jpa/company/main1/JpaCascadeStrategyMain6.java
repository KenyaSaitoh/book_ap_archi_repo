package jp.mufg.it.ee.jpa.company.main1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jp.mufg.it.ee.jpa.company.entity.Department;
import jp.mufg.it.ee.jpa.company.entity.Employee;

//カスケードのテスト
public class JpaCascadeStrategyMain6 {

    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        // エンティティトランザクションを開始する
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        // refresh操作
        Employee employee = entityManager.find(Employee.class, 10002);
        Department department = employee.getDepartment();
        employee.setSalary(480000); // もともとは450000
        department.setDepartmentName("経営企画部"); // もともとは企画部

        System.out.println("refresh前 ---> " + employee);
        entityManager.refresh(employee);
        System.out.println("refresh後 ---> " + employee);

        // コミットする
        entityTransaction.commit();
    }
}