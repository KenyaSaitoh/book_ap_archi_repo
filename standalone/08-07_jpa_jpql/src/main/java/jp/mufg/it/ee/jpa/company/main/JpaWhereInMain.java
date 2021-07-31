package jp.mufg.it.ee.jpa.company.main;

import static jp.mufg.it.ee.jpa.company.util.ResultUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jp.mufg.it.ee.jpa.company.entity.Department;
import jp.mufg.it.ee.jpa.company.entity.Employee;

@SuppressWarnings("unchecked")
public class JpaWhereInMain {

    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        {
        System.out.println("##### TEST1 START #####");
        List<Integer> paramList = new ArrayList<Integer>();
        paramList.add(1);
        paramList.add(4);
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee e " +
                "WHERE e.department.departmentId IN :departmentId")
                .setParameter("departmentId", paramList);
        List<Employee> resultList = query.getResultList();
        showEmployeeList(resultList); // 検索結果を表示
        System.out.println("##### TEST1 END #####\n");
        }

        {
        System.out.println("##### TEST2 START #####");
        List<Department> paramList = new ArrayList<Department>();
        Department department1 = entityManager.find(Department.class, 1);
        Department department2 = entityManager.find(Department.class, 4);
        paramList.add(department1);
        paramList.add(department2);
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee e " +
                "WHERE e.department IN :department")
                .setParameter("department", paramList);
        List<Employee> resultList = query.getResultList();
        showEmployeeList(resultList); // 検索結果を表示
        System.out.println("##### TEST2#END #####\n");
        }
    }
}