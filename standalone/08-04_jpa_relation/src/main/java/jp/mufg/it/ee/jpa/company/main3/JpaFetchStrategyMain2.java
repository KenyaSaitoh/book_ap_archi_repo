package jp.mufg.it.ee.jpa.company.main3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jp.mufg.it.ee.jpa.company.entity.Department;
import jp.mufg.it.ee.jpa.company.entity.Employee;

// フェッチのテスト
public class JpaFetchStrategyMain2 {

    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        // Department → Employee（レイジーフェッチ）
        System.out.println("##### findメソッド呼び出し #####");
        Department department = entityManager.find(Department.class, 1);
        System.out.println(department); // 検索結果を表示
        System.out.println("employees => " + department.getEmployees());
        System.out.println("##### 関連エンティティにアクセス #####");
        Employee employee = department.getEmployees().get(0);
        System.out.println("employees => " + department.getEmployees());
    }
}