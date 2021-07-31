package jp.mufg.it.ee.jpa.company.main3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jp.mufg.it.ee.jpa.company.entity.Department;
import jp.mufg.it.ee.jpa.company.entity.Employee;

// フェッチのテスト
public class JpaFetchStrategyMain4 {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        // 「N+1 SELECT」をフェッチジョインによって解決
        Query query = entityManager.createQuery(
                "SELECT DISTINCT d FROM Department AS d JOIN FETCH d.employees");
        List<Department> departmentList =
                (List<Department>)query.getResultList();

        // 検索結果を表示する
        for (Department department: departmentList) {
            System.out.println("departmentName => " +
                    department.getDepartmentName());
            List<Employee> employeeList = department.getEmployees();
            for (Employee employee: employeeList) {
                System.out.println("employeeName => " +
            employee.getEmployeeName());
            }
        }
    }
}