package jp.mufg.it.ee.jpa.company.main;

import java.util.List;

import javax.persistence.Query;

import org.junit.Test;
import jp.mufg.it.ee.jpa.company.test.base.JpaTestBase;
import jp.mufg.it.ee.jpa.company.test.util.ResultUtil;

import jp.mufg.it.ee.jpa.company.entity.Employee;


// 名前付きクエリのテスト
@SuppressWarnings("unchecked")
public class JpaNamedQueryMain extends JpaTestBase {

    // 名前付きクエリ
    @Test
    public void test1() {
        System.out.println("===== TEST1 START =====");
        Query query = entityManager.createNamedQuery("findEmployeesBysalary")
                .setParameter("salary", 400000);
        List<Employee> resultList = query.getResultList();
        showEmployeeList(resultList);
        System.out.println("===== TEST1 END =====\n");
    }

    private static void showEmployeeList(List<Employee> resultList) {
        for (Employee employee : resultList) {
            System.out.println(employee);
        }
    }
}