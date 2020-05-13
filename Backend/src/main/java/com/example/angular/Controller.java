package com.example.angular;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(value = "http://localhost:4200")
@RestController
public class Controller {
    private List<Employee> employees = createList();

    @GetMapping(value = "/employees")
    public List<Employee> firstPage(){
        return employees;
    }

    @DeleteMapping(path = { "employees/{id}"})
    public Employee employeeDelete(@PathVariable("id") int id){
        Employee deletedEmp = null;
            for ( Employee emp : employees){
                if(emp.getEmpId().equals(id)){
                    employees.remove(emp);
                    deletedEmp = emp;
                    break;
                }
            }
         return deletedEmp;
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee user){
        employees.add(user);
        System.out.println(employees);
        return user;
    }



    private static List<Employee> createList(){
        List<Employee> tempEmployees = new ArrayList<>();

        Employee emp1 = new Employee();
        emp1.setEmpId("1");
        emp1.setName("emp1");
        emp1.setDesignation("Manager");
        emp1.setSalary(3000);

        Employee emp2 = new Employee();
        emp2.setEmpId("2");
        emp2.setName("Pramod");
        emp2.setDesignation("Developer");
        emp2.setSalary(4000);

        tempEmployees.add(emp1);
        tempEmployees.add(emp2);


        return tempEmployees;

    }

}
