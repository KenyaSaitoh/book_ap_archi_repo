package jp.mufg.it.ee.servlet.jstl;

import java.util.ArrayList;
import java.util.List;

public class DepartmentBean {

    private String departmentName;
    private List<EmployeeBean> employees = new ArrayList<EmployeeBean>();

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public List<EmployeeBean> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeBean> employees) {
        this.employees = employees;
    }
}