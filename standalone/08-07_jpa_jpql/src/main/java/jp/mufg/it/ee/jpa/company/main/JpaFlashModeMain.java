package jp.mufg.it.ee.jpa.company.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jp.mufg.it.ee.jpa.company.entity.Department;
import jp.mufg.it.ee.jpa.company.entity.Employee;

// フラッシュモードのテスト
@SuppressWarnings("unchecked")
public class JpaFlashModeMain {

    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        // エンティティトランザクションを開始する
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        // FlushModeType.AUTO
        {
        System.out.println("===== TEST1 START =====");
        entityManager.setFlushMode(FlushModeType.AUTO);
        Employee employee = entityManager.find(Employee.class, 10013);
        Department department = entityManager.find(Department.class, 1);
        employee.setDepartment(department);
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "WHERE e.department.departmentId = 1");
        List<Employee> resultList = query.getResultList();
        entityTransaction.commit();
        showEmployeeList(resultList);
        System.out.println("===== TEST1 END =====\n");
        }

        // FlushModeType.COMMIT
        {
        System.out.println("===== TEST2 START =====");
        entityManager.setFlushMode(FlushModeType.COMMIT);
        Employee employee = entityManager.find(Employee.class, 10014);
        Department department = entityManager.find(Department.class, 2);
        employee.setDepartment(department);
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "WHERE e.department.departmentId = 2");
        List<Employee> resultList = query.getResultList();
        entityTransaction.commit();
        showEmployeeList(resultList);
        System.out.println("===== TEST2 END =====\n");
        }
    }

    private static void showEmployeeList(List<Employee> resultList) {
        for (Employee employee : resultList) {
            System.out.println(employee);
        }
    }
}