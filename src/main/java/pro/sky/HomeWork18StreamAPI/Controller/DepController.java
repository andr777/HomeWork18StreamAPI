package pro.sky.HomeWork18StreamAPI.Controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.HomeWork18StreamAPI.Service.DepartmentServiceInterface;
import pro.sky.HomeWork18StreamAPI.Service.Employee;
import pro.sky.HomeWork18StreamAPI.Service.EmployeeServiceIInterface;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/departments")
public class DepController {
   private final DepartmentServiceInterface departmentServiceInterface;

    @GetMapping(path = "max-salary")
    public String max(@RequestParam(name = "departmentId") String department) {
        return " max-salary " +  " " + departmentServiceInterface.maxsalary(department) ;
    }

    @GetMapping(path = "min-salary")
    public String min(@RequestParam(name = "departmentId") String department) {
        return " min-salary " +  " " + departmentServiceInterface.minsalary(department)  ;
    }

    @GetMapping(path = "all", params = "departmentId")
    public String all(@RequestParam(name = "departmentId") String department) {
        return department + " список: " +  departmentServiceInterface.all(department) ;


    }

    @GetMapping(path = "all")
    public String all() {
        return " список: " +  departmentServiceInterface.all();
    }

}

/*
http://localhost:8080/emp/add?firstName=Vasia&lastName=Vasichkin&salary=1111&department=department_01

http://localhost:8080/emp/add?firstName=Ivan&lastName=Ivanov&salary=2222&department=department_02

http://localhost:8080/emp/list

http://localhost:8080/emp/find?firstName=Vasia&lastName=Vasichkin

http://localhost:8080/emp/remove?firstName=Vasia&lastName=Vasichkin

**********
http://localhost:8080/departments/max-salary?departmentId=5  //Возвращать сотрудника с максимальной зарплатой на основе номера отдела

 /departments/min-salary?departmentId=5     //Возвращать сотрудника с минимальной зарплатой на основе номера отдела.

 /departments/all?departmentId=5         //Возвращать всех сотрудников по отделу.

/departments/all             //Возвращать всех сотрудников с разделением по отделам./


 */