package jp.mufg.it.ee.jpa.company.main;

import static jp.mufg.it.ee.jpa.company.util.ResultUtil.*;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import jp.mufg.it.ee.jpa.company.entity.Department;
import jp.mufg.it.ee.jpa.company.entity.Employee;

// クエリのテスト
@SuppressWarnings("unchecked")
public class JpaQueryMain {

    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        // 全カラムを指定
        {
        System.out.println("##### TEST1 START #####");
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "WHERE :lower <= e.salary AND e.salary <= :upper")
                .setParameter("lower", 300000)
                .setParameter("upper", 400000);
        List<Employee> resultList = query.getResultList();
        showEmployeeList(resultList); // 検索結果を表示
        System.out.println("##### TEST1 END #####\n");
        }

        // カラムを限定
        {
        System.out.println("##### TEST2 START #####");
        Query query = entityManager.createQuery(
                "SELECT e.employeeId, e.employeeName, e.salary " +
                "FROM Employee AS e " +
                "WHERE :lower <= e.salary AND e.salary <= :upper")
                .setParameter("lower", 300000)
                .setParameter("upper", 400000);
        List<Object[]> resultList = query.getResultList();
        showObjectArrayList(resultList); // 検索結果を表示
        System.out.println("##### TEST2 END #####\n");
        }

        // 関連エンティティを条件に指定
        {
        System.out.println("##### TEST3 START #####");
        Department department = entityManager.find(Department.class, 3);
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "WHERE e.department = :department")
                .setParameter("department", department);
        List<Employee> resultList = query.getResultList();
        showEmployeeList(resultList); // 検索結果を表示
        System.out.println("##### TEST3 END #####\n");
        }

        // 時間型の永続フィールドを条件に指定
        {
        System.out.println("##### TEST4 START #####");
        Calendar entranceDate = Calendar.getInstance();
        entranceDate.set(2012, 3, 1);  // 2012年4月1日
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "WHERE e.entranceDate = :entranceDate")
                .setParameter("entranceDate", entranceDate, TemporalType.DATE);
        List<Employee> resultList = query.getResultList();
        showEmployeeList(resultList); // 検索結果を表示
        System.out.println("##### TEST4 END #####\n");
        }
    }
}