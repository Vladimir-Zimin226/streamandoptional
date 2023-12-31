package pro.sky.streamandoptional.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.streamandoptional.Employee;
import pro.sky.streamandoptional.service.EmployeeService;


import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    public final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String surname, @RequestParam String name, @RequestParam int departmentId, @RequestParam int salary) {
        return service.add(surname, name, departmentId, salary);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String surname, @RequestParam String name, @RequestParam int departmentId, @RequestParam int salary) {
        return service.remove(surname, name, departmentId, salary);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String surname, @RequestParam String name, @RequestParam int departmentId, @RequestParam int salary) {
        return service.find(surname, name, departmentId, salary);
    }

    @GetMapping
    public Collection<Employee> findAll(){
        return service.findAll();
    }
}
