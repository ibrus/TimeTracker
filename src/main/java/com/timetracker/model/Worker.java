package com.timetracker.model;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Worker extends Employee{

    private Supervisor supervisor;
    private List<LocalDate> punches = new LinkedList<>();
}
