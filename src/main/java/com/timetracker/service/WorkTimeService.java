package com.timetracker.service;

import com.timetracker.repository.WorkTimeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class WorkTimeService {

    private final WorkTimeRepository workTimeRepository;

    public WorkTimeService(WorkTimeRepository workTimeRepository){
        this.workTimeRepository = workTimeRepository;
    }

    public void addPunchTime(LocalDate punchTime){
       workTimeRepository.save(punchTime);
    }
}
