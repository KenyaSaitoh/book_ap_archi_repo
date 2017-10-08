package jp.mufg.it.ee.jpa.company.test.base;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;

public class JpaTestBase {
    public EntityManagerFactory emf;
    public EntityManager em;
    public EntityTransaction et;

    // テストメソッド呼び出し前処理
    @Before
    public void beforeTest() {
        emf = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        em = emf.createEntityManager();
        et = em.getTransaction();
        et.begin();
    }

    // テストメソッド呼び出し後処理
    @After
    public void afterTest() {
        try {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    // コミット
    public void commit() {
        try {
            et.commit();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}