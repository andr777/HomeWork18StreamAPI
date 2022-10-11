package pro.sky.HomeWork18StreamAPI.Service;

import org.springframework.stereotype.Service;

import java.lang.String;

@Service
public class Employee {
    private String firstName;         // фамилия
    private String lastName;            // имя


    private double salary; //Зарплата

    private String  department;  //Отдел

    public Employee() {
        this(null, null, 0, null);
    }


    public Employee(String fName, String lName, double salary, String department) {
        this.firstName = fName;
        this.lastName = lName;
        this.salary=salary;
        this.department=department;

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(String lastName) {
        this.salary = salary;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String lastName) {
        this.department = department;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Employee employee = (Employee) obj;

        return this.firstName.equals(employee.getFirstName()) && this.lastName.equals(employee.getLastName());


    }

    @Override
    public String toString() {
        return this.firstName + ", " + this.lastName + ", " + this.salary + ", " + this.department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
