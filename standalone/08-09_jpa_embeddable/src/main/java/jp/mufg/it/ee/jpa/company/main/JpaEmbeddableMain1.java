package jp.mufg.it.ee.jpa.company.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jp.mufg.it.ee.jpa.company.entity.Department;
import jp.mufg.it.ee.jpa.company.entity.Employee;

// クライテリアによる動的SQLのテスト
public class JpaEmbeddableMain1 {

    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        // 社員を検索する
        {
        System.out.println("##### TEST1 START #####");
        Employee employee = entityManager.find(Employee.class, 10007);
        System.out.println(employee); // 検索結果を表示
        System.out.println("##### TEST1 ]");
        }

        // 部署を検索する
        {
        System.out.println("##### TEST2 START #####");
        Department department = entityManager.find(Department.class, 4);
        System.out.println(department); // 検索結果を表示
        System.out.println("##### TEST2 ]");
        }
    }
}