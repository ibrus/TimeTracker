package com.timetracker.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface WorkTimeRepository extends CrudRepository<LocalDate, Long> {
}
