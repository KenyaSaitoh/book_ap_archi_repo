package jp.mufg.it.ee.jpa.company.main3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jp.mufg.it.ee.jpa.company.entity.Department;
import jp.mufg.it.ee.jpa.company.entity.Employee;

// フェッチのテスト
public class JpaFetchStrategyMain3 {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        // レイジーフェッチにおける「N+1 SELECT」問題
        Query query = entityManager.createQuery("SELECT d FROM Department AS d");
        List<Department> departmentList = (List<Department>)query.getResultList();
        for (Department department: departmentList) {
            List<Employee> employeeList = department.getEmployees();
            for (Employee employee: employeeList) {
                System.out.println("employeeName ---> " + employee.getEmployeeName());
            }
        }
    }
}