package com.timetracker.repository;

import com.timetracker.model.WorkTime;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;

@Repository
public interface WorkTimeRepository extends CrudRepository<WorkTime, Long> {
}
