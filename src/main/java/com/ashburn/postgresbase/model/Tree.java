package com.ashburn.postgresbase.model;


import jakarta.persistence.*;

@Entity
@Table(name = "trees")
public class Tree {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Float longitude;
    private Float latitude;
    private String species;
    private int dbh;
    private String crown;
    private String notes;

    public Tree() {
    }

    public Tree(Float longitude, Float latitude, String species, int dbh, String crown, String notes) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.species = species;
        this.dbh = dbh;
        this.crown = crown;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public Float getLongitude() {
        return longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public String getSpecies() {
        return species;
    }

    public int getDbh() {
        return dbh;
    }

    public String getCrown() {
        return crown;
    }

    public String getNotes() {
        return notes;
    }
}
