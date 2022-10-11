package pro.sky.HomeWork18StreamAPI.Service;

import org.springframework.stereotype.Service;
import pro.sky.HomeWork18StreamAPI.Exceptions.EmployeeNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

//import static pro.sky.HomeWork18StreamAPI.Service.EmployeeServiceImp.employeesListMap;

@Service
public class DepartmentServiceImp implements DepartmentServiceInterface {

    private final EmployeeServiceImp employeeServiceImp;

    public DepartmentServiceImp(EmployeeServiceImp employeeServiceImp) {
        this.employeeServiceImp = employeeServiceImp;
    }


    @Override
    public Employee maxsalary(String department) {
        return employeeServiceImp.getAll().stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);

    }
  

    @Override
    public Employee minsalary(String department) {

        return employeeServiceImp.getAll().stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }
    @Override
    public Collection<Employee> all(String department) {
        return employeeServiceImp.getAll().stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .collect(Collectors.toList());
    }



    @Override
    public Map<String, List<Employee>> all() {
        return employeeServiceImp.getAll().stream()
                               .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    @Override
    public boolean findDepartment(String department) {
        return false;
    }
    


}
