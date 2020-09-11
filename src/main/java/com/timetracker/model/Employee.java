package com.timetracker.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Employee {
    private final UUID id;
    private final String firstName;
    private final String lastName;
    private final String SSN;


    public Employee(UUID id,
                    @JsonProperty("firstName") String firstName,
                    @JsonProperty("lastName") String lastName,
                    @JsonProperty("SSN") String SSN) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
    }
}
