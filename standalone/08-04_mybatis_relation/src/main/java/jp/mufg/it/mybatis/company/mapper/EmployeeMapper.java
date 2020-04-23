package jp.mufg.it.mybatis.company.mapper;

import jp.mufg.it.mybatis.company.dto.Employee;

public interface EmployeeMapper {

    // INSERT
    void insertEmployee(Employee employee);

    // UPDATE
    int updateEmployee(Employee employee);
}
