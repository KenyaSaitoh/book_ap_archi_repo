package jp.mufg.it.ee.jpa.company.main;

import static jp.mufg.it.ee.jpa.company.util.ResultUtil.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import jp.mufg.it.ee.jpa.company.entity.Employee;

// クライテリアによる動的SQLのテスト
public class JpaCriteriaMain1 {

    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        // CriteriaBuilderを取得する
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        // CriteriaQueryを取得する
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

        // Rootを取得する
        Root<Employee> employee = cq.from(Employee.class);

        // Predicate（検索条件）を構築する
        Predicate condition = cb.conjunction();
        condition = cb.and(condition, cb.equal(
                employee.get("department").get("departmentId"), 1));
        condition = cb.and(condition, cb.ge(employee.get("salary"), 300000));

        // CriteriaQueryにルートエンティティと検索条件を設定する
        cq.select(employee).where(condition);

        // クエリを実行して結果を取得する
        List<Employee> resultList = entityManager.createQuery(cq)
                .getResultList();

        // 検索結果を表示する
        showEmployeeList(resultList);
    }
}