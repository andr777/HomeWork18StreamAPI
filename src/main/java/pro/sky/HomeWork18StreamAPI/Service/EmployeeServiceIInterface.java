package pro.sky.HomeWork18StreamAPI.Service;

public interface EmployeeServiceIInterface {

    public String add(String name, String firstName, double salary, String lastName);



    String employeeList();

    boolean find(Employee fff);

    boolean remove(Employee fff);
}
