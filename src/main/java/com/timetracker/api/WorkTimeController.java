package com.timetracker.api;

import com.timetracker.model.Employee;
import com.timetracker.service.WorkTimeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@RequestMapping("api/v1/worktime")
@RestController
public class WorkTimeController {

    private final WorkTimeService workTimeService;

    public WorkTimeController(WorkTimeService workTimeService){
        this.workTimeService = workTimeService;
    }

    @PostMapping
    public void punch(@RequestBody Date punchTime, Employee employee){
        workTimeService.addPunchTime(punchTime, employee);
    }
}
