package jp.mufg.it.ee.jpa.company.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jp.mufg.it.ee.jpa.company.entity.Employee;

public class JpaOptimisticLockConflicter {

    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        Employee employee = em.find(Employee.class, 10001);
        employee.setSalary(550000);
        et.commit();
        em.close();
    }
}