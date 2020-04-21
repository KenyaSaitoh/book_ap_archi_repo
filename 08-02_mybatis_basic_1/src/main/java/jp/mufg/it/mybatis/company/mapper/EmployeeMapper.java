package jp.mufg.it.mybatis.company.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import jp.mufg.it.mybatis.company.dto.Employee;

public interface EmployeeMapper {

    // SELECT
    Employee selectEmployee(int employeeId);
    List<Employee> selectEmployees(
            @Param("departmentName") String departmentName,
            @Param("salary") int salary);

    // INSERT
    void insertEmployee(Employee employee);

    // DELETE
    int deleteEmployee(int employeeId);

    // UPDATE
    int updateEmployee(Employee employee);
    int subtractSalaryWithParam(
            @Param("salary") int salary,
            @Param("payCut") int payCut);
}
