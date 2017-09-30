package jp.mufg.it.ee.jpa.company.util;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import jp.mufg.it.ee.jpa.company.entity.Department;
import jp.mufg.it.ee.jpa.company.entity.Employee;

public class ResultUtil {

    public static void showEmployee(Employee employee) {
        if (employee != null) {
            System.out.print(employee.getEmployeeId() + " / ");
            System.out.print(employee.getEmployeeName() + " / ");
            if (employee.getDepartment() != null)
                System.out.print(employee.getDepartment().getDepartmentName()
                        + " / ");
            else
                System.out.print("null" + " / ");
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(employee.getEntranceDate().getTime());
            String entranceDate =
                    cal.get(Calendar.YEAR) + "年"
                            + (cal.get(Calendar.MONTH) + 1) + "月"
                            + cal.get(Calendar.DATE) + "日";
            System.out.print(entranceDate + " / ");
            System.out.print(employee.getJobType().toString() + " / ");
            System.out.println(employee.getSalary() + " / ");
        }
    }

    public static void showEmployeeList(List<Employee> list) {
        Iterator<Employee> i = list.iterator();
        while (i.hasNext()) {
            Employee employee = i.next();
            showEmployee(employee);
        }
    }

    public static void showDepartment(Department department) {
        if (department != null) {
            System.out.print(department.getDepartmentId() + " / ");
            System.out.print(department.getDepartmentName() + " / ");
            System.out.print(department.getBuildingName() + " / ");
            System.out.println(department.getFloor());
        }
    }

    public static void showDepartmentList(List<Department> list) {
        Iterator<Department> i = list.iterator();
        while (i.hasNext()) {
            Department department = i.next();
            showDepartment(department);
        }
    }

    public static void showObjectArray(Object[] objs) {
        for (Integer i = 0; i < objs.length; i++) {
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