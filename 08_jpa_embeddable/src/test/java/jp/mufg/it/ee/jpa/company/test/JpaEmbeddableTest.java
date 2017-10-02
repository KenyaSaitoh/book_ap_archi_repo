package jp.mufg.it.ee.jpa.company.test;

import org.junit.Test;

import jp.mufg.it.ee.jpa.company.entity.Department;
import jp.mufg.it.ee.jpa.company.entity.Employee;
import jp.mufg.it.ee.jpa.company.test.base.JpaTestBase;
import jp.mufg.it.ee.jpa.company.util.ResultUtil;

// エンベッダブルクラスのテスト
public class JpaEmbeddableTest extends JpaTestBase {

    // 社員を検索
    @Test
    public void test1() {
        System.out.println("[ test1 ] Start");
        Employee employee = em.find(Employee.class, 10007);
        ResultUtil.showEmployee(employee);
        System.out.println("[ test1 ] End\n");
    }

    // 部署を検索
    @Test
    public void test2() {
        System.out.println("[ test2 ] Start");
        Department department = em.find(Department.class, 4);
        ResultUtil.showDepartment(department);
        System.out.println("[ test2 ] End\n");
    }
}