package com.timetracker.service;

import com.timetracker.model.Employee;
import com.timetracker.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void saveEmployee(Employee employee){
        if(employee.getBirthdate() != null){
            employee.setAge(calculateAge(employee));
        }
        employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee(){
        List<Employee> result = new ArrayList<>();
        employeeRepository.findAll().forEach(result::add);
        return result;
    }

    public Optional<Employee> getEmployeeById(Long id){
        return employeeRepository.findById(id);
    }

    public void deleteEmployeeById(Long id){
        employeeRepository.deleteById(id);
    }

    public static int calculateAge(Employee employee) {
            return Period.between(employee.getBirthdate(), LocalDate.now()).getYears();
    }

}
