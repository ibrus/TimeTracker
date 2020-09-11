package com.timetracker.service;

import com.timetracker.dao.EmployeeDao;
import com.timetracker.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public void addEmployee(Employee employee){
        employeeDao.addEmployee(employee);
    }

    public List<Employee> getAllEmployee(){
        return employeeDao.getAllEmployee();
    }

    public Optional<Employee> getEmployeeById(UUID id){
        return employeeDao.getEmployeeById(id);
    }

    public void deleteEmployeeById(UUID id){
        employeeDao.deleteEmployeeById(id);
    }

    public void updateEmployeeById(UUID id, Employee employee){
        employeeDao.updateEmployeeById(id, employee);
    }

}
