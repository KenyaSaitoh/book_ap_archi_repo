package jp.mufg.it.ee.jpa.company.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jp.mufg.it.ee.jpa.company.entity.Department;
import jp.mufg.it.ee.jpa.company.entity.Employee;

// 機能関数のテスト
@SuppressWarnings("unchecked")
public class JpaGeneralFunctionMain {

    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        // LENGTH
        {
        System.out.println("===== TEST1 START =====");
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "WHERE 8 < LENGTH(e.employeeName)");
        List<Employee> resultList = query.getResultList();
        showEmployeeList(resultList);
        System.out.println("===== TEST1 END =====\n");
        }

        // SIZE
        {
        System.out.println("===== TEST2 START =====");
        Query query = entityManager.createQuery(
                "SELECT d FROM Department AS d " +
                "WHERE SIZE(d.employees) = 3");
        List<Department> resultList = query.getResultList();
        showDepartmentList(resultList);
        System.out.println("===== TEST2 END =====\n");
        }

        // SUBSTRING
        {
        System.out.println("===== TEST3 START =====");
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "WHERE SUBSTRING(e.employeeName, 2, 1) = 'か'");
        List<Employee> resultList = query.getResultList();
        showEmployeeList(resultList);
        System.out.println("===== TEST3 END =====\n");
        }
    }

    private static void showEmployeeList(List<Employee> resultList) {
        for (Employee employee : resultList) {
            System.out.println(employee);
        }
    }

    private static void showDepartmentList(List<Department> resultList) {
        for (Department department : resultList) {
            System.out.println(department);
            for (Employee employee : department.getEmployees()) {
                System.out.println("    +---" + employee);
            }
        }
    }
}