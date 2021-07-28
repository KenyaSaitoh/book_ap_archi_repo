package jp.mufg.it.ee.jpa.company.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jp.mufg.it.ee.jpa.company.entity.Department;
import jp.mufg.it.ee.jpa.company.entity.Employee;

// WHERE節の様々な記述方法に関するテスト
@SuppressWarnings("unchecked")
public class JpaWhereClauseMain {

    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        // ARITHMETIC OPERATOR
        {
        System.out.println("[ test1 ] Start");
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "WHERE e.salary * 0.1 < :salary")
                .setParameter("salary", 30000);
        List<Employee> resultList = query.getResultList();
        showEmployeeList(resultList);
        System.out.println("[ test1 End ]");
        }

        // LOGICAL OPERATOR
        {
        System.out.println("[ test2 ] Start");
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "WHERE :lower <= e.salary AND e.salary <= :upper")
                .setParameter("lower", 300000)
                .setParameter("upper", 350000);
        List<Employee> resultList = query.getResultList();
        showEmployeeList(resultList);
        System.out.println("[ test2 End ]");
        }

        // COMPARISON SYMBOLS
        {
        System.out.println("[ test3 ] Start");
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "WHERE NOT e.department.departmentId = :departmentId " +
                "AND ( e.salary <= :lower OR :upper <= e.salary)")
                .setParameter("departmentId", 2)
                .setParameter("lower", 300000)
                .setParameter("upper", 350000);
        List<Employee> resultList = query.getResultList();
        showEmployeeList(resultList);
        System.out.println("[ test3 End ]");
        }

        // BETWEEN
        {
        System.out.println("[ test4 ] Start");
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "WHERE e.salary BETWEEN :lower AND :upper")
                .setParameter("lower", 300000)
                .setParameter("upper", 350000);
        List<Employee> resultList = query.getResultList();
        showEmployeeList(resultList);
        System.out.println("[ test4 End ]");
        }

        // NOT BETWEEN
        {
        System.out.println("[ test5 ] Start");
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "WHERE e.salary NOT BETWEEN :lower AND :upper")
                .setParameter("lower", 300000)
                .setParameter("upper", 450000);
        List<Employee> resultList = query.getResultList();
        showEmployeeList(resultList);
        System.out.println("[ test5 End ]");
        }

        // IN
        {
        System.out.println("[ test6 ] Start");
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee e " +
                "WHERE e.department.departmentId IN (1, 5)");
        List<Employee> resultList = query.getResultList();
        showEmployeeList(resultList);
        System.out.println("[ test6 End ]");
        }

        // NOT IN
        {
        System.out.println("[ test7 ] Start");
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee e " +
                "WHERE e.department.departmentId NOT IN (2, 3, 4)");
        List<Employee> resultList = query.getResultList();
        showEmployeeList(resultList);
        System.out.println("[ test7 End ]");
        }

        // LIKE 1
        {
        System.out.println("[ test8 ] Start");
        Query query = entityManager.createQuery(
                "SELECT d FROM Department d " +
                "WHERE d.location LIKE :location")
                .setParameter("location", "新宿%");
        List<Department> resultList = query.getResultList();
        showDepartmentList(resultList);
        System.out.println("[ test8 End ]");
        }

        // LIKE 2
        {
        System.out.println("[ test9 ] Start");
        Query query = entityManager.createQuery(
                "SELECT d FROM Department d " +
                "WHERE d.location LIKE '新宿%'");
        List<Department> resultList = query.getResultList();
        showDepartmentList(resultList);
        System.out.println("[ test9 End ]");
        }

        // NOT LIKE
        {
        System.out.println("[ test10 ] Start");
        Query query = entityManager.createQuery(
                "SELECT d FROM Department d " +
                "WHERE d.location NOT LIKE :location")
                .setParameter("location", "新宿%");
        List<Department> resultList = query.getResultList();
        showDepartmentList(resultList);
        System.out.println("[ test10 End ]");
        }

        // NULL
        {
        System.out.println("[ test11 ] Start");
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee e " +
                "WHERE e.department IS NULL");
        List<Employee> resultList = query.getResultList();
        showEmployeeList(resultList);
        System.out.println("[ test11 End ]");
        }

        // NOT NULL
        {
        System.out.println("[ test12 ] Start");
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee e " +
                "WHERE e.department IS NOT NULL");
        List<Employee> resultList = query.getResultList();
        showEmployeeList(resultList);
        System.out.println("[ test12 End ]");
        }

        // EMPTY
        {
        System.out.println("[ test13 ] Start");
        Query query = entityManager.createQuery(
                "SELECT d FROM Department d " +
                "WHERE d.employees IS EMPTY");
        List<Department> resultList = query.getResultList();
        showDepartmentList(resultList);
        System.out.println("[ test13 End ]");
        }

        // NOT EMPTY
        {
        System.out.println("[ test14 ] Start");
        Query query = entityManager.createQuery(
                "SELECT d FROM Department d " +
                "WHERE d.employees IS NOT EMPTY");
        List<Department> resultList = query.getResultList();
        showDepartmentList(resultList);
        System.out.println("[ test14 End ]");
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