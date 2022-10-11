package pro.sky.HomeWork18StreamAPI.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentServiceInterface {


    Employee maxsalary(String department);

    Employee minsalary(String department);

    Collection<Employee>  all(String department);

    Map<String, List<Employee>> all();

    boolean findDepartment(String department);


}
