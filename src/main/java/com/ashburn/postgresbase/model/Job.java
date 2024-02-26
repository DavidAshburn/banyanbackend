package com.ashburn.postgresbase.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime start;
    private LocalDateTime est_end;

    private Boolean invoiced;
    private Boolean paid;
    private String estimator;
    private String foreman;
    private String notes;

    //we'll parse this string into JSON until I find a better type
    private String trees;
    private String equipment;
    private String vehicles;
    private int crew_size;
    private int est_hours;
    private int price;
    private Long property_id;
    private Long user_id;

    public Job() {
    }

    public Job(LocalDateTime start, LocalDateTime est_end, Boolean invoiced, Boolean paid, String estimator, String foreman, String notes, String trees, String equipment, String vehicles, int crew_size, int est_hours, int price, Long property_id, Long user_id) {
        this.start = start;
        this.est_end = est_end;
        this.invoiced = invoiced;
        this.paid = paid;
        this.estimator = estimator;
        this.foreman = foreman;
        this.notes = notes;
        this.trees = trees;
        this.equipment = equipment;
        this.vehicles = vehicles;
        this.crew_size = crew_size;
        this.est_hours = est_hours;
        this.price = price;
        this.property_id = property_id;
        this.user_id = user_id;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEst_end() {
        return est_end;
    }

    public Boolean getInvoiced() {
        return invoiced;
    }

    public Boolean getPaid() {
        return paid;
    }

    public String getEstimator() {
        return estimator;
    }

    public String getForeman() {
        return foreman;
    }

    public String getNotes() {
        return notes;
    }

    public String getTrees() {
        return trees;
    }

    public String getEquipment() {
        return equipment;
    }

    public String getVehicles() {
        return vehicles;
    }

    public int getCrew_size() {
        return crew_size;
    }

    public int getEst_hours() {
        return est_hours;
    }

    public int getPrice() {
        return price;
    }

    public Long getProperty_id() {
        return property_id;
    }

    public Long getUser_id() {
        return user_id;
    }
}
