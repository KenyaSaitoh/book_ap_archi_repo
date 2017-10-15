package jp.mufg.it.ee.jpa.company.test.util;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import jp.mufg.it.ee.jpa.company.entity.Employee;
import jp.mufg.it.ee.jpa.company.entity.Fulltimer;
import jp.mufg.it.ee.jpa.company.entity.Parttimer;

public class ResultUtil {

    public static void showEmployee(Employee employee) {
        System.out.print(employee.getEmployeeId() + " / ");
        System.out.print(employee.getEmployeeName() + " / ");
        if (employee.getDepartment() != null) {
            System.out
                    .print(employee.getDepartment().getDepartmentId() + " / ");
            System.out.print(employee.getDepartment().getDepartmentName()
                    + " / ");
            System.out.println(employee.getDepartment().getLocation() + " / ");
        }
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(employee.getEntranceDate().getTime());
        String entranceDate =
                cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1)
                        + "月" + cal.get(Calendar.DATE) + "日";
        System.out.print(entranceDate + " / ");
    }

    public static void showStaff(Fulltimer staff) {
        showEmployee(staff);
        System.out.print(staff.getJobName() + " / ");
        System.out.print(staff.getsalary());
        System.out.println();
    }

    public static void showParttimer(Parttimer parttimer) {
        showEmployee(parttimer);
        System.out.print(parttimer.getParttimerPayment());
        System.out.println();
    }

    public static void showStaffList(List<Fulltimer> list) {
        Iterator<Fulltimer> i = list.iterator();
        while (i.hasNext()) {
            Fulltimer staff = i.next();
            showStaff(staff);
        }
    }

    public static void showParttimerList(List<Parttimer> list) {
        Iterator<Parttimer> i = list.iterator();
        while (i.hasNext()) {
            Parttimer parttimer = i.next();
            showParttimer(parttimer);
        }
    }
}