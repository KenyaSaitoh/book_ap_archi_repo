package jp.mufg.it.mybatis.company.mapper;

import java.util.List;

import jp.mufg.it.mybatis.company.dto.EmpDept;

public interface EmpDeptFlatMapper {

    // SELECT
    EmpDept selectEmpDept(int employeeId);
    List<EmpDept> selectEmpDeptByDepartmentId(int departmentId);
}
