package pro.sky.HomeWork18StreamAPI.Service;

import java.util.List;

public interface EmployeeServiceIInterface {

   // public String add(String name, String firstName, double salary, String lastName);

    public Employee add(String name, String firstName, double salary, String lastName);

    Employee employeeList();

    boolean find(Employee fff);

    boolean remove(Employee fff);

    public List<Employee> getAll();
}
