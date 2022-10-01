package pro.sky.HomeWork18StreamAPI.Service;

import org.springframework.stereotype.Service;
import pro.sky.HomeWork18StreamAPI.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.HomeWork18StreamAPI.Exceptions.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static pro.sky.HomeWork18StreamAPI.Service.EmployeeServiceImp.employeesListMap;

@Service
public class DepartmentServiceImp implements DepartmentServiceInterface {

    @Override
    public String maxsalary(String department) {
        return null;
    }

    @Override
    public String minsalary(String department) {
        return null;
    }

    @Override
    public String all(String department) {
        return null;
    }

    @Override
    public String all() {
        System.out.println(" список: " + employeesListMap);
        return employeesListMap.toString();
    }

    @Override
    public String add(String name, String firstName, double salary, String lastName) {
        return null;
    }

    @Override
    public String employeeList() {
        return null;
    }

    @Override
    public boolean find(Employee fff) {
        return false;
    }

    @Override
    public boolean remove(Employee fff) {
        return false;
    }
}
