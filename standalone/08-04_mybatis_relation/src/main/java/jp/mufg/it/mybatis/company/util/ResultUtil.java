package jp.mufg.it.mybatis.company.util;

import java.util.List;

import jp.mufg.it.mybatis.company.dto.Department;
import jp.mufg.it.mybatis.company.dto.EmpDept;
import jp.mufg.it.mybatis.company.dto.Employee;

public class ResultUtil {
    public static void showEmployeeList(List<Employee> resultList) {
        for (Employee employee : resultList) {
            System.out.println(employee);
        }
    }

    public static void showDepartmentList(List<Department> resultList) {
        for (Department department : resultList) {
            System.out.println(department);
            for (Employee employee : department.getEmployees()) {
                System.out.println("  +--- " + employee);
            }
        }
    }

    public static void showEmpDeptList(List<EmpDept> resultList) {
        for (EmpDept empDept : resultList) {
            System.out.println(empDept);
        }
    }

    public static void showObjectList(List<Object> list) {
        String log = "[ ";
        for (int i = 0; i < list.size(); i++) {
            log = list.get(i) != null ? log + list.get(i).toString() :
                log + "null";
            if (i != list.size() - 1) log = log + ", ";
        }
        System.out.println(log + " ]");
    }

    public static void showObjectArray(Object[] array) {
        String log = "[ ";
        for (int i = 0; i < array.length; i++) {
            log = array[i] != null ? log + array[i].toString() : log + "null";
            if (i != array.length - 1) log = log + ", ";
        }
        System.out.println(log + " ]");
    }

    public static void showObjectArrayList(List<Object[]> list) {
        for (Object[] items : list) {
            String log = "[ ";
            for (int i = 0; i < items.length; i++) {
                log = items[i] != null ? log + items[i].toString() :
                    log + "null";
                if (i != items.length - 1) log = log + ", ";
            }
            System.out.println(log + " ]");
        }
    }
}
