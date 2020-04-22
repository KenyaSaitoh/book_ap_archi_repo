package jp.mufg.it.mybatis.company.mapper;

import java.util.List;

import jp.mufg.it.mybatis.company.dto.Employee;

public interface EmployeeMapper {

    // SELECT
    Employee selectEmployee(int employeeId);
    List<Employee> selectVariousDepartment(List<String> departmentNameList);

    // INSERT
    void insertEmployee(Employee employee);
    void insertEmployeeWithKeyGen(Employee employee);
}
