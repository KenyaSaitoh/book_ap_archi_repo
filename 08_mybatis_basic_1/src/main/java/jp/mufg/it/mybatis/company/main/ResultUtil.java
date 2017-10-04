package jp.mufg.it.mybatis.company.main;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jp.mufg.it.mybatis.company.dto.Employee;

public class ResultUtil {

    public static void showEmployee(Employee employee) {
        System.out.print(employee.getEmployeeId() + " / ");
        System.out.print(employee.getEmployeeName() + " / ");
        System.out.print(employee.getDepartmentName() + " / ");
        System.out.println(employee.getSalary());
    }

    public static void showEmployeeList(List<Employee> list) {
        Iterator<Employee> i = list.iterator();
        while (i.hasNext()) {
            Employee employee = i.next();
            showEmployee(employee);
        }
    }

    public static void showEmployeeList2(List<Object> list) {
        Iterator<Object> i = list.iterator();
        while (i.hasNext()) {
            Employee employee = (Employee)i.next();
            showEmployee(employee);
        }
    }

    public static void showEmployeeMap(Map<Integer, Employee> map) {
        Iterator<Integer> i = map.keySet().iterator();
        while (i.hasNext()) {
            Integer employeeId = i.next();
            System.out.print(employeeId + " ---> ");
            showEmployee((Employee)map.get(employeeId));
        }
    }

    public static void showObjectArray(Object[] objs) {
        for (int i = 0; i < objs.length; i++) {
            System.out.print(objs[i] + " / ");
        }
        System.out.println();
    }

    public static void showObjectArrayList(List<Object[]> resultList) {
        Iterator<Object[]> i = resultList.iterator();
        while (i.hasNext()) {
            Object[] objs = i.next();
            showObjectArray(objs);
        }
    }
}