package pro.sky.HomeWork18StreamAPI.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.HomeWork18StreamAPI.Service.Employee;
import pro.sky.HomeWork18StreamAPI.Service.EmployeeServiceIInterface;

@Primary
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/emp")
public class EmpController {

    private final EmployeeServiceIInterface employeeServiceIInterface;


    @GetMapping(path = "add")
    public String Plus(@RequestParam(name = "firstName") String firstName,
                       @RequestParam(name = "lastName") String lastName,
                       @RequestParam(name = "salary") int salary,
                       @RequestParam(name = "department") String department) {
      Employee aaa =  employeeServiceIInterface.add(firstName, lastName, (double) salary ,department );
         return " + " + firstName + " " + lastName + " " + aaa;
    }

    @GetMapping(path = "list")
    public String List(){
        return " список: " +  employeeServiceIInterface.employeeList();
    }

    @GetMapping(path = "find")
    public String Find(@RequestParam(name = "firstName") String firstName,
                       @RequestParam(name = "lastName") String lastName) {
        Employee fff = new Employee(firstName, lastName , (double) 0, null);
        if(employeeServiceIInterface.find(fff)){
            System.out.println("ArrayList find ");
            return " + " + firstName + " " + lastName + " найден в списке";
        } else {
            System.out.println("ArrayList NOT find ");
            return " + " + firstName + " " + lastName + " НЕ найден в списке";
        }
        //return " + " + firstName + " " + lastName + " найден в списке";
    }

    @GetMapping(path = "remove")
    public String remove(@RequestParam(name = "firstName") String firstName,
                       @RequestParam(name = "lastName") String lastName) {
        Employee oneEmployee = new Employee(firstName, lastName , (double) 0, null);
        if(employeeServiceIInterface.remove(oneEmployee)){
            System.out.println("ArrayList remove ");
            return " - " + firstName + " " + lastName + " remove в списке";
        } else {
            System.out.println("ArrayList NOT find ");
            return " + " + firstName + " " + lastName + " НЕ remove в списке";
        }
        //return " + " + firstName + " " + lastName + " найден в списке";
    }


}
/*
http://localhost:8080/emp/add?firstName=Vasia&lastName=Vasichkin&salary=1111&department=department_01

http://localhost:8080/emp/add?firstName=Ivan&lastName=Ivanov&salary=2222&department=department_02

http://localhost:8080/emp/list

http://localhost:8080/emp/find?firstName=Vasia&lastName=Vasichkin

http://localhost:8080/emp/remove?firstName=Vasia&lastName=Vasichkin

**********
/departments/max-salary?departmentId=5  //Возвращать сотрудника с максимальной зарплатой на основе номера отдела

 /departments/min-salary?departmentId=5     //Возвращать сотрудника с минимальной зарплатой на основе номера отдела.

 /departments/all?departmentId=5         //Возвращать всех сотрудников по отделу.

/departments/all             //Возвращать всех сотрудников с разделением по отделам./


 */