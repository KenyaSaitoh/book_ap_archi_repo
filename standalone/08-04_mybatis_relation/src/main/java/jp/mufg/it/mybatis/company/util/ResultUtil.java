package jp.mufg.it.mybatis.company.util;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import jp.mufg.it.mybatis.company.dto.Employee;
import jp.mufg.it.mybatis.company.dto.EmpDept;

public class ResultUtil {

    public static void showEmpDept(EmpDept empDept) {
        System.out.print(empDept.getEmployeeId() + " / ");
        System.out.print(empDept.getEmployeeName() + " / ");
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(empDept.getEntranceDate().getTime());
        String entranceDate =
                cal.get(Calendar.YEAR) + "年"
                        + (cal.get(Calendar.MONTH) + 1) + "月"
                        + cal.get(Calendar.DATE) + "日";
        System.out.print(entranceDate + " / ");
        System.out.print(empDept.getJobType() + " / ");
        System.out.print(empDept.getSalary() + " / ");
        System.out.print(empDept.getDepartmentId() + " / ");
        System.out.print(empDept.getDepartmentName() + " / ");
        System.out.println(empDept.getLocation());
    }

    public static void showEmpDeptList(List<EmpDept> list) {
        Iterator<EmpDept> i = list.iterator();
        while (i.hasNext()) {
            EmpDept empDept = i.next();
            showEmpDept(empDept);
        }
    }

    public static void showEmployee(Employee employee) {
        if (employee != null) {
            System.out.print(employee.getEmployeeId() + " / ");
            System.out.print(employee.getEmployeeName() + " / ");
            if (employee.getDepartment() != null) {
                System.out.print(employee.getDepartment().getDepartmentName()
                        + " / ");
                System.out.print(employee.getDepartment().getLocation() + " / ");
            } else {
                System.out.print("null" + " / ");
            }
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(employee.getEntranceDate().getTime());
            String entranceDate =
                    cal.get(Calendar.YEAR) + "年"
                            + (cal.get(Calendar.MONTH) + 1) + "月"
                            + cal.get(Calendar.DATE) + "日";
            System.out.print(entranceDate + " / ");
            System.out.print(employee.getJobType().toString() + " / ");
            System.out.println(employee.getSalary());
        }
    }

    public static void showEmployeeList(List<Employee> list) {
        Iterator<Employee> i = list.iterator();
        while (i.hasNext()) {
            Employee employee = i.next();
            showEmployee(employee);
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