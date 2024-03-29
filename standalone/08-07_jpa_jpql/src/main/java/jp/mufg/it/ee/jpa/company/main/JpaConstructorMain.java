package jp.mufg.it.ee.jpa.company.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jp.mufg.it.ee.jpa.company.entity.EmpDept;
import jp.mufg.it.ee.jpa.company.entity.EmployeeTO;

// コンストラクタ式のテスト
public class JpaConstructorMain {

    public static void main(String[] args) {
        // エンティティマネージャファクトリを取得する
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // エンティティマネージャを取得する
        EntityManager entityManager = emf.createEntityManager();

        {
        System.out.println("##### TEST1 START #####");
        Query query = entityManager.createQuery(
                "SELECT NEW jp.mufg.it.ee.jpa.company.entity.EmployeeTO" +
                "(e.employeeId, e.employeeName, d.departmentName) " +
                "FROM Department AS d INNER JOIN d.employees AS e " +
                "WHERE e.employeeId = :employeeId")
                .setParameter("employeeId", 10008);
        EmployeeTO employeeTO = (EmployeeTO)query.getSingleResult();
        System.out.println(employeeTO); // 検索結果を表示
        System.out.println("##### TEST1 END #####\n");
        }

        // コンストラクタ式 2
        {
        System.out.println("##### TEST2 START #####");
        Query query = entityManager.createQuery(
                "SELECT NEW jp.mufg.it.ee.jpa.company.entity.EmployeeDepartment" +
                "(e.employeeId, e.employeeName, e.salary, d.departmentId, " +
                "d.departmentName, d.location) " +
                "FROM Employee AS e INNER JOIN e.department AS d " +
                "WHERE e.employeeId = :employeeId")
                .setParameter("employeeId", 10001);
        EmpDept employeeDepartment =
                (EmpDept)query.getSingleResult();
        System.out.println(employeeDepartment); // 検索結果を表示
        System.out.println("##### TEST2 END #####\n");
        }
    }
}