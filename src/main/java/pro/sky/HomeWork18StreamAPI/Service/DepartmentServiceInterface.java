package pro.sky.HomeWork18StreamAPI.Service;

public interface DepartmentServiceInterface extends EmployeeServiceIInterface {


    String maxsalary(String department);

    String minsalary(String department);

    String all(String department);

    String all();


}
