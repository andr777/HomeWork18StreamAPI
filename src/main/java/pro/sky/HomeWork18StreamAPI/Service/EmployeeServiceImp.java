package pro.sky.HomeWork18StreamAPI.Service;

import org.springframework.stereotype.Service;
import pro.sky.HomeWork18StreamAPI.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.HomeWork18StreamAPI.Exceptions.EmployeeNotFoundException;

import java.util.*;


@Service
public class EmployeeServiceImp implements EmployeeServiceIInterface {


   // List<Employee> employeesList = new ArrayList<>();
    private Map<String, Employee> employeesListMap = new HashMap<>();

    @Override
    public Employee add(String firstName, String lastName, double salary, String department) {


        Employee employees = new Employee(firstName, lastName,  salary,  department);



        if (find(employees)) {
            System.out.println(employees + " этот уже есть в списке.");

            throw new EmployeeAlreadyAddedException();
        } else {
            employeesListMap.put(firstName + ' ' + lastName, employees);
            System.out.println('\n' + " Добавлен: Фамилия='" + firstName + '\'' +
                    ", Имя='" + lastName + '\'');
        }

        return employees;
    }

    @Override
    public Employee employeeList() {
        System.out.println(" список: " + employeesListMap);
        return (Employee) employeesListMap;
    }

    @Override
    public boolean find(Employee employee) {
        boolean flagFinfEmployee = false;

        flagFinfEmployee = employeesListMap.containsValue(employee);

        return flagFinfEmployee;
    }

    @Override
    public boolean remove(Employee employee) {
        boolean flagRemoveOk = false;

        if (find(employee)) {
            employeesListMap.remove(employee.getFirstName() + " " + employee.getLastName());
            System.out.println(employee + " удалён  ");
            flagRemoveOk = true;

        } else {
            System.out.println(employee + " не найден");
            flagRemoveOk = false;
            throw new EmployeeNotFoundException();

        }


        return flagRemoveOk;
    }


    public List<Employee> getAll() {
        return new ArrayList<>(employeesListMap.values());
    }

    public void setAll(Employee all) {
      //  this.all = all;
    }

    public Map<String, Employee> getEmployeesListMap() {
        return employeesListMap;
    }

    public void setEmployeesListMap(Map<String, Employee> employeesListMap) {
        this.employeesListMap = employeesListMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeServiceImp that = (EmployeeServiceImp) o;

        return Objects.equals(employeesListMap, that.employeesListMap);
    }

    @Override
    public int hashCode() {
        return employeesListMap != null ? employeesListMap.hashCode() : 0;
    }
}
