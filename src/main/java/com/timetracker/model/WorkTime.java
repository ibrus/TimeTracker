package com.timetracker.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter @Setter
public class WorkTime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @DateTimeFormat(style = "yyyy.MM.dd HH:mm:ss")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy.MM.dd HH:mm:ss")
    private Date punchIn;

    @DateTimeFormat(style = "yyyy.MM.dd HH:mm:ss")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy.MM.dd HH:mm:ss")
    private Date punchOut;

    private double totalHours;

    @Transient
    private static int punchCounter;

    public WorkTime(Date punchIn, Date punchOut, Employee employee){
        this.employee = employee;
        this.punchIn = punchIn;
        this.punchOut = punchOut;
        calculatePeriodBetweenPunchInAndPunchOut();
    }

    private void calculatePeriodBetweenPunchInAndPunchOut(){
        this.totalHours =  ChronoUnit.MINUTES.between(
                new Timestamp(punchIn.getTime()).toLocalDateTime(),
                new Timestamp(punchIn.getTime()).toLocalDateTime())/60;
    }

}
