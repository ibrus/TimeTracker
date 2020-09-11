package com.timetracker.dao;

import com.timetracker.model.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeDao {

    void addEmployee(Employee employee);

    List<Employee> getAllEmployee();

    Optional<Employee> getEmployeeById(UUID id);

    void deleteEmployeeById(UUID id);

    void updateEmployeeById(UUID id, Employee employee);
}
