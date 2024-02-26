package com.ashburn.postgresbase.repository;

import com.ashburn.postgresbase.model.Job;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job, Long> {
}
