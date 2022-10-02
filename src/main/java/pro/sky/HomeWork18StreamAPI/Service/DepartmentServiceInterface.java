package pro.sky.HomeWork18StreamAPI.Service;

public interface DepartmentServiceInterface {


    String maxsalary(String department);

    String minsalary(String department);

    String all(String department);

    String all();

    boolean findDepartment(String department);


}
