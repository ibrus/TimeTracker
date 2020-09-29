package com.timetracker.api;

import com.timetracker.service.WorkTimeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RequestMapping("api/v1/worktime")
@RestController
public class WorkTimeController {

    private final WorkTimeService workTimeService;

    public WorkTimeController(WorkTimeService workTimeService){
        this.workTimeService = workTimeService;
    }

    @PostMapping
    public void punch(@RequestBody LocalDate punchTime){
        workTimeService.addPunchTime(punchTime);
    }
}
