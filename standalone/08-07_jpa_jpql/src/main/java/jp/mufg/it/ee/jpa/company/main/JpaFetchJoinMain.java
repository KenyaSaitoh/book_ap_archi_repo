package jp.mufg.it.ee.jpa.company.main;

import static jp.mufg.it.ee.jpa.company.util.ResultUtil.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jp.mufg.it.ee.jpa.company.entity.Department;
import jp.mufg.it.ee.jpa.company.entity.Employee;

// フェッチジョインのテスト
@SuppressWarnings("unchecked")
public class JpaFetchJoinMain {

    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        // フェッチジョイン 1
        {
        System.out.println("##### TEST1 START #####");
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee AS e JOIN FETCH e.department " +
                "WHERE e.department.departmentId = :departmentId")
                .setParameter("departmentId", 3);
        List<Employee> resultList = query.getResultList();
        showEmployeeList(resultList); // 検索結果を表示
        System.out.println("##### TEST1 END #####\n");
        }

        // フェッチジョイン 2
        {
        System.out.println("##### TEST2 START #####");
        Query query = entityManager.createQuery(
                "SELECT DISTINCT d FROM Department AS d JOIN FETCH d.employees " +
                "WHERE d.departmentId = :departmentId")
                .setParameter("departmentId", 3);
        List<Department> resultList = query.getResultList();
        showDepartmentList(resultList); // 検索結果を表示
        System.out.println("##### TEST2 END #####\n");
        }
        // One-to-manyのOne側でSELECTすると、Many側のロー数文だけ結果が返ってくるので、
        // DISTINCTする。

        // フェッチジョイン 3
        {
        // フェッチジョイン＋件数指定
        // Departmentに対する件数指定がしたい。
        // そして対象となったDepartmentは、所属している全社員がヒットして欲しい。
        // しかしDISTINCTを使う、使わないに関わらず、思ったとおりの結果が得られず。
        System.out.println("##### TEST3 START #####");
        Query query1 = entityManager.createQuery(
                "SELECT d FROM Department AS d JOIN FETCH d.employees")
                .setMaxResults(4);
        List<Department> resultList1 = query1.getResultList();
        showDepartmentList(resultList1);
        Query query2 = entityManager.createQuery(
                "SELECT DISTINCT d FROM Department AS d JOIN FETCH d.employees")
                .setMaxResults(4);
        List<Department> resultList2 = query2.getResultList();
        showDepartmentList(resultList2);
        for (Department department : resultList2) {
            for (Employee employee : department.getEmployees()) {
                System.out.println(employee);
            }
        }
        System.out.println("##### TEST3 END #####\n");
        }

        // フェッチジョイン 4
        {
        System.out.println("##### TEST4 START #####");
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee AS e JOIN FETCH e.department " +
                "WHERE e.employeeId = :employeeId")
                .setParameter("employeeId", 10003);
        Employee employee = (Employee)query.getSingleResult();
        System.out.println(employee); // 検索結果を表示
        System.out.println("##### TEST4 END #####\n");
        }
    }
}