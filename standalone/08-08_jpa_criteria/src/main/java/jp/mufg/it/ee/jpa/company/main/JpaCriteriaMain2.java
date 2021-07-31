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

//クライテリアによる動的SQLのテスト
public class JpaCriteriaMain2 {

    public static void main(String[] args) {
        // 営業部（部署ID3）に所属している社員（月給の条件なし）
        System.out.println("##### TEST1 START #####");
        executeQuery(3, null, null);
        System.out.println("##### TEST1 END #####\n");

        // 営業部（部署ID3）に所属している月給が30万円以上の社員
        System.out.println("##### TEST2 START #####");
        executeQuery(3, 300000, null);
        System.out.println("##### TEST2 END #####\n");

        // 営業部（部署ID3）に所属している月給が30万円以上、40万円以下の社員
        System.out.println("##### TEST3 START #####");
        executeQuery(3, 300000, 400000);
        System.out.println("##### TEST3 END #####\n");

        // 月給が30万円以上、40万円以下の社員（全部署）
        System.out.println("##### TEST4 START #####");
        executeQuery(null, 300000, 400000);
        System.out.println("##### TEST5 END #####\n");
    }

    private static void executeQuery(Integer departmentId, Integer lower,
            Integer upper) {

        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        // CriteriaBuilderを取得する
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        // CriteriaQueryを取得する
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

        // Rootエンティティを取得する
        Root<Employee> employee = cq.from(Employee.class);

        // パラメータにしたがって動的にPredicate（検索条件）を構築する
        Predicate condition = cb.conjunction();
        if (departmentId != null)
            condition = cb.and(condition, cb.equal(
                    employee.get("department").get("departmentId"), departmentId));
        if (lower != null)
            condition = cb.and(condition, cb.ge(
                    employee.get("salary"), lower));
        if (upper != null)
            condition = cb.and(condition, cb.le(
                    employee.get("salary"), upper));

        // CriteriaQueryを作成する
        cq.select(employee).where(condition);

        // クエリを実行して結果を取得する
        List<Employee> resultList = entityManager.createQuery(cq)
                .getResultList();

        // 検索結果を表示する
        showEmployeeList(resultList);
    }
}