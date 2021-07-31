package jp.mufg.it.ee.jpa.company.main1;

import static jp.mufg.it.ee.jpa.company.util.ResultUtil.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jp.mufg.it.ee.jpa.company.entity.Employee;

// リレーションのテスト
public class JpaRelationMain {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        // 主キー検索
        {
        System.out.println("##### TEST1 START #####");
        Employee employee = entityManager.find(Employee.class, 10007);
        System.out.println(employee); // 検索結果を表示
        System.out.println("##### TEST1#END #####\n");
        }

        // 条件検索
        {
        System.out.println("##### TEST2 START #####");
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee e " +
                "WHERE :lower <= e.salary AND e.salary <= :upper")
                .setParameter("lower", 300000)
                .setParameter("upper", 400000);
        List<Employee> resultList = query.getResultList();
        showEmployeeList(resultList); // 検索結果を表示
        System.out.println("##### TEST2#END #####\n");
        }
    }
}