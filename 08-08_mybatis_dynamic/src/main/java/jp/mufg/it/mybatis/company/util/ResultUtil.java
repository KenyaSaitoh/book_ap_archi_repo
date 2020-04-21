package jp.mufg.it.mybatis.company.util;

import java.util.Iterator;
import java.util.List;

import jp.mufg.it.mybatis.company.dto.Employee;

public class ResultUtil {

    public static void showEmployee(Employee employee) {
        System.out.print(employee.getEmployeeId() + " / ");
        System.out.print(employee.getEmployeeName() + " / ");
        System.out.print(employee.getDepartmentName() + " / ");
        System.out.print(employee.getEntranceDate() + " / ");
        System.out.print(employee.getJobType() + " / ");
        System.out.println(employee.getSalary());
    }

    public static void showEmployeeList(List<Employee> list) {
        Iterator<Employee> i = list.iterator();
        while (i.hasNext()) {
            Employee employee = i.next();
            showEmployee(employee);
        }
    }
}