package com.timetracker.model;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Transient;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
public class WorkTime {

    private LocalDate punchIn;
    private LocalDate punchOut;
    @Transient
    private static int punchCounter;

    public WorkTime(LocalDate punch){
        if (punchCounter == 0){
            this.punchIn = punch;
            punchCounter++;
        }
        else{
            this.punchOut = punch;
            punchCounter = 0;
        }
    }

}
