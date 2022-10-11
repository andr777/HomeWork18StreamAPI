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

        boolean f = false;

        if (find(employees)) {
            System.out.println(employees + " этот уже есть в списке.");
            f = true;
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
    public boolean find(Employee fff) {
        boolean f = false;

        f = employeesListMap.containsValue(fff);

        return f;
    }

    @Override
    public boolean remove(Employee fff) {
        boolean f = false;

        if (find(fff)) {
            employeesListMap.remove(fff.getFirstName() + " " + fff.getLastName());
            System.out.println(fff + " удалён  ");
            f = true;

        } else {
            System.out.println(fff + " не найден");
            f = false;
            throw new EmployeeNotFoundException();

        }


        return f;
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
