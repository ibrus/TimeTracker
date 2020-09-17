package com.timetracker.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private String SSN;


    public Employee(Long id,
                    @JsonProperty("firstName") String firstName,
                    @JsonProperty("lastName") String lastName,
                    @JsonProperty("SSN") String SSN) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
    }
}
