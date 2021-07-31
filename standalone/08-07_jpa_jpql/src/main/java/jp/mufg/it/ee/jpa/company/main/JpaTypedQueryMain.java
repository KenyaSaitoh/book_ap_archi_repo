package jp.mufg.it.ee.jpa.company.main;

import static jp.mufg.it.ee.jpa.company.util.ResultUtil.*;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import jp.mufg.it.ee.jpa.company.entity.Department;
import jp.mufg.it.ee.jpa.company.entity.Employee;

// クエリのテスト
public class JpaTypedQueryMain {

    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        // 全カラムを指定
        {
        System.out.println("##### TEST1 START #####");
        TypedQuery<Employee> query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "WHERE :lower <= e.salary AND e.salary <= :upper",
                Employee.class)
                .setParameter("lower", 300000)
                .setParameter("upper", 400000);
        List<Employee> resultList = query.getResultList();
        showEmployeeList(resultList); // 検索結果を表示
        System.out.println("##### TEST1 END #####\n");
        }

        // カラムを限定
        {
        System.out.println("##### TEST2 START #####");
        TypedQuery<Object[]> query = entityManager.createQuery(
                "SELECT e.employeeId, e.employeeName, e.salary " +
                "FROM Employee AS e " +
                "WHERE :lower <= e.salary AND e.salary <= :upper",
                Object[].class)
                .setParameter("lower", 300000)
                .setParameter("upper", 400000);
        List<Object[]> resultList = query.getResultList();
        showObjectArrayList(resultList); // 検索結果を表示
        System.out.println("##### TEST2 END #####\n");
        }

        // 関連を持っている別のエンティティオブジェクトを条件に指定
        {
        System.out.println("##### TEST3 START #####");
        Department department = entityManager.find(Department.class, 3);
        TypedQuery<Employee> query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "WHERE e.department = :department",
                Employee.class)
                .setParameter("department", department);
        List<Employee> resultList = query.getResultList();
        showEmployeeList(resultList); // 検索結果を表示
        System.out.println("##### TEST3 END #####\n");
        }

        // 時間型の永続フィールドを条件に指定
        {
        System.out.println("##### TEST4 START #####");
        Calendar entranceDate = Calendar.getInstance();
        entranceDate.set(2014, 6, 1);
        TypedQuery<Employee> query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "WHERE e.entranceDate = :entranceDate", Employee.class)
                .setParameter("entranceDate", entranceDate, TemporalType.DATE);
        List<Employee> resultList = query.getResultList();
        showEmployeeList(resultList); // 検索結果を表示
        System.out.println("##### TEST4 END #####\n");
        }
    }
}