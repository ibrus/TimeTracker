package com.timetracker.dao;

import com.timetracker.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class EmployeeFakeDao implements EmployeeDao {

    private static List<Employee> DB = new ArrayList<>();

    public void addEmployee(Employee employee){
        DB.add(new Employee(UUID.randomUUID(), employee.getFirstName(), employee.getLastName(),
                employee.getSSN()));
    }

    @Override
    public List<Employee> getAllEmployee() {
        return DB;
    }

    @Override
    public Optional<Employee> getEmployeeById(UUID id) {
        return DB.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst();
    }

    @Override
    public void deleteEmployeeById(UUID id) {
        Optional<Employee> employeeIfPresent = getEmployeeById(id);
        if(!employeeIfPresent.isPresent()){
            throw new IllegalArgumentException();
        } else{
            DB.remove(employeeIfPresent.get());
        }
    }

    @Override
    public void updateEmployeeById(UUID id, Employee employee) {
        getEmployeeById(id)
                .map(e -> {
                    int indexOfEmployeeToDelete = DB.indexOf(employee);
                    if(indexOfEmployeeToDelete >= 0){
                        DB.set(indexOfEmployeeToDelete, employee);
                    } else try {
                        throw new IllegalAccessException();
                    } catch (IllegalAccessException illegalAccessException) {
                        illegalAccessException.printStackTrace();
                    }
                    return null;
                }).orElse(null);
    }
}
