package jp.mufg.it.mybatis.company.mapper;

import jp.mufg.it.mybatis.company.dto.Employee;

public interface EmployeeMapper {

    // SELECT
    Employee selectEmployee(int employeeId);
    Employee selectEmployeeWithPessimisticLock(int employeeId);

    // UPDATE
    int updateEmployee(Employee employee);
    int updateEmployeeWithOptimisticLock(Employee employee);
}
