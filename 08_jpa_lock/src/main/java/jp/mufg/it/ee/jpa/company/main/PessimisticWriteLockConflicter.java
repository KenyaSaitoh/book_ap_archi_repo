package jp.mufg.it.ee.jpa.company.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;

import jp.mufg.it.ee.jpa.company.entity.Employee;
import jp.mufg.it.ee.jpa.company.util.ResultUtil;

public class PessimisticWriteLockConflicter {

    public static void main(String[] args) {
        System.out.println("[ PessimisticWriteLockConflicter ] Start");
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        Employee employee = em.find(Employee.class, 10001,
                LockModeType.PESSIMISTIC_WRITE);
        em.flush();
        ResultUtil.showEmployee(employee);

        try {
            Thread.sleep(20000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        et.commit();
        em.close();
        System.out.println("[ PessimisticWriteLockConflicter ] End");
    }
}