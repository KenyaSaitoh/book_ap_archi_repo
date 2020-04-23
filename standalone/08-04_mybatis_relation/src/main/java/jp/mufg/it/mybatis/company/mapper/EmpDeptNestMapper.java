package jp.mufg.it.mybatis.company.mapper;

import jp.mufg.it.mybatis.company.dto.Department;
import jp.mufg.it.mybatis.company.dto.Employee;

public interface EmpDeptNestMapper {

    // SELECT
    Employee selectEmployee(int employeeId);
    Department selectDepartment(int departmentId);
}
