package pro.sky.HomeWork18StreamAPI.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentServiceInterface {


    Employee maxsalary(String department);

    Employee minsalary(String department);

    //Возвращать всех сотрудников по отделу. /departments/all?departmentId=5
    // плохое название метода, all что? [ iStemmer Pavel ]
    // ok. заменил all на более лучшее название.
    Collection<Employee> AllReturnAllEmployeesOfADepartmentOrReturnAllEmployeesDividedByDepartment(String department);

    //Возвращать всех сотрудников с разделением по отделам.  /departments/all
    // плохое название метода, all что? [ iStemmer Pavel ]
    // ok. заменил all на более лучшее название.
    Map<String, List<Employee>> AllReturnAllEmployeesOfADepartmentOrReturnAllEmployeesDividedByDepartment();

    boolean findDepartment(String department);


}
