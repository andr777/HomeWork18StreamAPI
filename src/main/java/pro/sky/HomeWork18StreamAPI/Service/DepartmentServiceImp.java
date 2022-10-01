package pro.sky.HomeWork18StreamAPI.Service;

import org.springframework.stereotype.Service;
import pro.sky.HomeWork18StreamAPI.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.HomeWork18StreamAPI.Exceptions.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static pro.sky.HomeWork18StreamAPI.Service.EmployeeServiceImp.employeesListMap;

@Service
public class DepartmentServiceImp implements DepartmentServiceInterface {

    @Override
    public String maxsalary(String department) {

        Employee eListDep;
        List<Employee> employeesListDep = new ArrayList<>();
        Map<String, Employee> employeesListMapDep = new HashMap<>();

        double sal0 = 0;

        for (Map.Entry<String, Employee> pair : employeesListMap.entrySet()) {
            eListDep = pair.getValue();
            if (department.equals(eListDep.getDepartment())) {
                if (sal0 < eListDep.getSalary()) {
                    sal0 = eListDep.getSalary();
                    System.out.println(sal0);
                    employeesListMapDep.put("max" + ' ' + "salary", eListDep);

                }
            }


        }
        System.out.println(department + " список max sal : " + employeesListMapDep.toString());
        return employeesListMapDep.toString();


    }

    @Override
    public String minsalary(String department) {

        Employee eListDep;
        List<Employee> employeesListDep = new ArrayList<>();
        Map<String, Employee> employeesListMapDep = new HashMap<>();

        double sal0 = 9999999;

        for (Map.Entry<String, Employee> pair : employeesListMap.entrySet()) {
            eListDep = pair.getValue();
            if (department.equals(eListDep.getDepartment())) {
                if (sal0 > eListDep.getSalary()) {
                    sal0 = eListDep.getSalary();
                    System.out.println(sal0);
                    employeesListMapDep.put("min" + ' ' + "salary", eListDep);

                }
            }


        }
        System.out.println(department + " список min sal : " + employeesListMapDep.toString());
        return employeesListMapDep.toString();


    }

    @Override
    public boolean findDepartment(String department) {
        boolean find = false;
        Employee eListDep;
        List<Employee> employeesListDep = new ArrayList<>();
        Map<String, Employee> employeesListMapDep = new HashMap<>();
        for (Map.Entry<String, Employee> pair : employeesListMap.entrySet()) {
            eListDep = pair.getValue();
            if (department.equals(eListDep.getDepartment())) {
                find = true;
            }
        }

        return find;
    }

    @Override
    public String all(String department) {


        Employee eListDep;
        List<Employee> employeesListDep = new ArrayList<>();
        Map<String, Employee> employeesListMapDep = new HashMap<>();

        for (Map.Entry<String, Employee> pair : employeesListMap.entrySet()) {
            eListDep = pair.getValue();
            if (department.equals(eListDep.getDepartment())) {
                employeesListMapDep.put(eListDep.getFirstName() + ' ' + eListDep.getLastName(), eListDep);

            }
        }
        System.out.println(department + " список dep: " + employeesListMapDep.toString());
        return employeesListMapDep.toString();


    }

    @Override
    public String all() {
        System.out.println(" список all: " + employeesListMap);
        return employeesListMap.toString();
    }


}
