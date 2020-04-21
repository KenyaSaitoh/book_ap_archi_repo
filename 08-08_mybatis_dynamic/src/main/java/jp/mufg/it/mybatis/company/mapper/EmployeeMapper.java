package jp.mufg.it.mybatis.company.mapper;

import java.util.List;

import jp.mufg.it.mybatis.company.dto.Employee;
import jp.mufg.it.mybatis.company.dto.EmployeeDynamicParam;

public interface EmployeeMapper {

    // SELECT
    List<Employee> selectDynamicEmployees(EmployeeDynamicParam paramEmployee);
}
