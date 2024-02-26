package com.ashburn.postgresbase.web;

import com.ashburn.postgresbase.model.Job;
import com.ashburn.postgresbase.repository.JobRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {

    private final JobRepository jobRepository;
    public JobController(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/jobs")
    public List<Job> findAllJobs() {
        List<Job> result = new ArrayList<Job>();
        this.jobRepository.findAll().forEach(result::add);
        return result;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/jobs/{id}")
    public Job findJob(@PathVariable Long id) {
        Job found = this.jobRepository.findById(id).orElse(null);
        if(found == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return found;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/api/jobs")
    public Job addOneJob(@RequestBody Job job) {
        return this.jobRepository.save(job);
    }
}
