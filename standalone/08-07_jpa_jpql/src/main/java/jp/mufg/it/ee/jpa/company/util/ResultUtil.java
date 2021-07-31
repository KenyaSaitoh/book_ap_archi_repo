package jp.mufg.it.ee.jpa.company.util;

import java.util.List;

import jp.mufg.it.ee.jpa.company.entity.Department;
import jp.mufg.it.ee.jpa.company.entity.Employee;
import jp.mufg.it.ee.jpa.company.entity.EmployeeCountTO;
import jp.mufg.it.ee.jpa.company.entity.EmployeeQueryResult1;
import jp.mufg.it.ee.jpa.company.entity.EmployeeQueryResult2;

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

    public static void showEmployeeCountTOList(
            List<EmployeeCountTO> resultList) {
        for (EmployeeCountTO to : resultList) {
            System.out.println(to);
        }
    }

    public static void showEmployeeQueryResultList1(
            List<EmployeeQueryResult1> list) {
        String log = "[ ";
        for (int i = 0; i < list.size(); i++) {
            log = list.get(i) != null ? log + list.get(i).toString() :
                log + "null";
            if (i != list.size() - 1) log = log + ", ";
        }
        System.out.println(log + " ]");
    }

    public static void showEmployeeQueryResultList2(
            List<EmployeeQueryResult2> list) {
        String log = "[ ";
        for (int i = 0; i < list.size(); i++) {
            log = list.get(i) != null ? log + list.get(i).toString() :
                log + "null";
            if (i != list.size() - 1) log = log + ", ";
        }
        System.out.println(log + " ]");
    }
}
