package com.timetracker.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@NoArgsConstructor
public class WorkTime {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private Employee employee;
    private LocalDate punchIn;
    private LocalDate punchOut;
    private int totalHours;
    @Transient
    private static int punchCounter;

    public WorkTime(LocalDate punch, Employee employee){
        this.employee = employee;
        
        if (punchCounter == 0){
            this.punchIn = punch;
            punchCounter++;
        }
        else{
            this.punchOut = punch;
            punchCounter = 0;
            this.totalHours = (int) ChronoUnit.HOURS.between(punchIn, punchOut);
        }
    }

}
