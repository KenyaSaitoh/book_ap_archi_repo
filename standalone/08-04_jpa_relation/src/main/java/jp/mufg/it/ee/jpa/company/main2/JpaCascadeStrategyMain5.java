package jp.mufg.it.ee.jpa.company.main2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jp.mufg.it.ee.jpa.company.entity.Department;
import jp.mufg.it.ee.jpa.company.entity.Employee;

//カスケードのテスト
public class JpaCascadeStrategyMain5 {

    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        // エンティティトランザクションを開始する
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        // merge操作（UPDATE）
        Employee employee = entityManager.find(Employee.class, 10007);
        Department department = employee.getDepartment();
        entityManager.clear();  // mergeのテストのために、取得したエンティティオブジェクトを意図的にDETACHED状態にする
        employee.setSalary(500000); // もともとは480000
        department.setLocation("新宿新都心支社"); // もともとは新宿東口支社
        employee.setDepartment(department);
        entityManager.merge(employee);

        // コミットする
        entityTransaction.commit();
    }
}