package com.timetracker.service;

import com.timetracker.model.Employee;
import com.timetracker.model.WorkTime;
import com.timetracker.repository.WorkTimeRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;

@Service
public class WorkTimeService {

    HashMap<Long, Date> employeeIdAndPunchTime = new HashMap<>();

    private final WorkTimeRepository workTimeRepository;

    public WorkTimeService(WorkTimeRepository workTimeRepository){
        this.workTimeRepository = workTimeRepository;
    }

    public void addPunchTime(Date punchTime, Employee employee){
        if (!employeeIdAndPunchTime.containsKey(employee.getId())){
            employeeIdAndPunchTime.put(employee.getId(), punchTime);
        } else{
            workTimeRepository.save(new WorkTime(employeeIdAndPunchTime.get(employee.getId()), punchTime, employee));
            employeeIdAndPunchTime.remove(employee.getId());
        }
    }
}
