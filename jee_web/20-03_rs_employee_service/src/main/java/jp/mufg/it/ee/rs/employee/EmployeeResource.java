package jp.mufg.it.ee.rs.employee;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Dependent @Transactional
@Path("/employees")
public class EmployeeResource {

    @PersistenceContext(unitName = "MyPersistenceUnit")
    private EntityManager entityManager;

    // リソース（社員1名）の取得
    @GET
    @Path("/{employeeId}")
    @Produces("application/json")
    public Employee getEmployee(@PathParam("employeeId") int employeeId) {
        Employee employee = entityManager.find(Employee.class, employeeId);
        return employee;
    }

    // リソース（社員全員）の取得
    @SuppressWarnings("unchecked")
    @GET
    @Path("/all")
    @Produces("application/json")
    public List<Employee> getEmployeesAll() {
        Query query = entityManager.createQuery("SELECT e FROM Employee AS e");
        List<Employee> resultList = query.getResultList();
        return resultList;
    }

    // リソース（指定された部署に所属する全員）の取得
    @SuppressWarnings("unchecked")
    @GET
    @Produces("application/json")
    public List<Employee> getEmployeesByDepartmentName(
            @QueryParam("departmentName") String departmentName) {
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "WHERE e.departmentName = :departmentName")
                .setParameter("departmentName", departmentName);
        List<Employee> resultList = query.getResultList();
        return resultList;
    }

    // リソース（指定された月給以上の社員）の取得
    @SuppressWarnings("unchecked")
    @Path("/query_by_salary")
    @GET
    @Produces("application/json")
    public List<Employee> getEmployeesBySalary(
            @QueryParam("lowerSalary") int lowerSalary,
            @QueryParam("upperSalary") int upperSalary) {
        Query query = entityManager.createQuery(
                "SELECT e FROM Employee AS e " +
                "WHERE :lowerSalary <= e.salary AND e.salary <= :upperSalary")
                .setParameter("lowerSalary", lowerSalary)
                .setParameter("upperSalary", upperSalary);
        List<Employee> resultList = query.getResultList();
        return resultList;
    }

    // リソース（社員1名）の挿入
    // 冪等性なし
    @POST
    public Response createEmployee(Employee employee) {
        entityManager.persist(employee);
        return Response.status(201).entity(employee).build();
    }

    // リソース（社員1名）の置換
    // 冪等性あり
    @PUT
    @Path("/{employeeId}")
    public Response replaceEmployee(@PathParam("employeeId") int employeeId,
            Employee employee) {
        employee.setEmployeeId(employeeId);
        if (entityManager.find(Employee.class, employeeId) != null) {
            // 存在する場合は更新する
            entityManager.merge(employee);
            ResponseBuilder builder = Response.status(204);
            return builder.build();
        } else {
            // 存在しない場合は挿入する
            entityManager.persist(employee);
            return Response.status(201).build();
        }
    }

    // リソース（社員1名）の削除
    // 冪等性あり
    @DELETE
    @Path("/{employeeId}")
    public void removeEmployee(@PathParam("employeeId") int employeeId) {
        Employee employee = entityManager.find(Employee.class, employeeId);
        entityManager.remove(employee);
    }

    // リソース（社員の月給）の更新処理
    // 冪等性なし
    @POST
    @Path("/{employeeId}")
    public void updatesalary(@PathParam("employeeId") int employeeId,
            @FormParam("amount") int amount) {
        Employee employee = entityManager.find(Employee.class, employeeId);
        employee.setSalary(employee.getSalary() + amount);
    }
}