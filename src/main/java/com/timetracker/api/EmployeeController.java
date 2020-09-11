package com.timetracker.api;

import com.timetracker.model.Employee;
import com.timetracker.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/employee")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public void addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping(path = "{id}")
    public Employee getEmployeeById(@PathVariable("id") UUID id){
        return employeeService.getEmployeeById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteEmployeeById(@PathVariable("id") UUID id){
        employeeService.deleteEmployeeById(id);
    }

    @PutMapping(path = "{id}")
    public void updateEmployeeById(@PathVariable("id") UUID id, @RequestBody Employee employee){
        employeeService.updateEmployeeById(id, employee);
    }
}
