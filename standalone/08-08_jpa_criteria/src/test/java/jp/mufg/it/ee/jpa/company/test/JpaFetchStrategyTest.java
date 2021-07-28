package jp.mufg.it.ee.jpa.company.test;

import java.util.List;
import javax.persistence.Query;
import org.junit.Test;

import jp.mufg.it.ee.jpa.company.entity.Department;
import jp.mufg.it.ee.jpa.company.entity.Employee;
import jp.mufg.it.ee.jpa.company.test.base.JpaTestBase;


// フェッチのテスト
public class JpaFetchStrategyTest extends JpaTestBase {

    // Employee → Department（イーガーフェッチ）
    @Test
    public void test1() {
        System.out.println("[ test1 ] Start");
        System.out.println("===== findメソッド呼び出し開始 =====");
        Employee employee = entityManager.find(Employee.class, 10011);
        System.out.println("===== 関連するエンティティオブジェクトの" +
                "永続フィールドにアクセス開始 =====");
        String employeeName = employee.getEmployeeName();
        System.out.println("employee.getEmployeeName() ---> " + employeeName);
        System.out.println("[ test1 ]");
    }

    // Department → Employee（レイジーフェッチ）
    @Test
    public void test2() {
        System.out.println("[ test2 ] Start");
        System.out.println("===== findメソッド呼び出し開始 =====");
        Department department = entityManager.find(Department.class, 1);
        System.out.println("===== 関連するエンティティオブジェクトの" +
                "永続フィールドにアクセス開始 =====");
        Employee employee = department.getEmployees().get(0);
        System.out.println("department.getEmployees().get(0) ---> "
                + employee);
        System.out.println("[ test2 ]");
    }

    // レイジーフェッチにおける「N+1 SELECT」問題
    @SuppressWarnings("unchecked")
    @Test
    public void test3() {
        System.out.println("[ test3 ] Start");
        Query query = entityManager.createQuery("SELECT d FROM Department AS d");
        List<Department> departmentList = (List<Department>)query.getResultList();
        System.out.println("##### ループ開始 #####");
        for (Department department: departmentList) {
            List<Employee> employeeList = department.getEmployees();
            for (Employee employee: employeeList) {
                System.out.println(employee.getEmployeeName());
            }
        }
        System.out.println("[ test3 ]");
    }

    // test3における「N+1 SELECT」をフェッチジョインによって解決する
    @SuppressWarnings("unchecked")
    @Test
    public void test4() {
        System.out.println("[ test4 ] Start");
        Query query = entityManager.createQuery(
                "SELECT DISTINCT d FROM Department AS d JOIN FETCH d.employees");
        List<Department> departmentList = (List<Department>)query.getResultList();
        // DICTINCTをつけない場合、結果が重複するので、
        // Setに代入して重複を取り除くこともできる
        // Set<Department> results = new HashSet<Department>(departmentList);
        for (Department department: departmentList) {
            System.out.println("### " + department.getDepartmentName() + " ###");
            List<Employee> employeeList = department.getEmployees();
            for (Employee employee: employeeList) {
                System.out.println(employee.getEmployeeName());
            }
        }
        System.out.println("[ test4 ]");
    }
}