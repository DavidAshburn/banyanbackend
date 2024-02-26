package com.ashburn.postgresbase.model;

import jakarta.persistence.*;

@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String user_name;
    private String species;
    private String equipment;
    private String vehicles;
    private String worktypes;
    private Long user_id;

    public Profile() {
    }

    public Profile(String user_name, String species, String equipment, String vehicles, String worktypes, Long user_id) {
        this.user_name = user_name;
        this.species = species;
        this.equipment = equipment;
        this.vehicles = vehicles;
        this.worktypes = worktypes;
        this.user_id = user_id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getSpecies() {
        return species;
    }

    public String getEquipment() {
        return equipment;
    }

    public String getVehicles() {
        return vehicles;
    }

    public String getWorktypes() {
        return worktypes;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public void setVehicles(String vehicles) {
        this.vehicles = vehicles;
    }

    public void setWorktypes(String worktypes) {
        this.worktypes = worktypes;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
