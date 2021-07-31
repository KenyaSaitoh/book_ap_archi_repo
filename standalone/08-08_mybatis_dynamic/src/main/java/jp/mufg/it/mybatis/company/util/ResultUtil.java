package jp.mufg.it.mybatis.company.util;

import java.util.List;

import jp.mufg.it.mybatis.company.dto.Employee;

public class ResultUtil {
    public static void showEmployeeList(List<Employee> resultList) {
        for (Employee employee : resultList) {
            System.out.println(employee);
        }
    }
}