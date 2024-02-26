package com.ashburn.postgresbase.model;

import jakarta.persistence.*;

@Entity
@Table(name = "properties")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String label;
    private String address;
    private String email;
    private String phone;
    private String contactname;
    private Float longitude;
    private Float latitude;
    private String proptype;
    private String parking;
    private String treeaccess;
    private Long clientid;

    public Property() {
    }

    public Property(String label, String address, String email, String phone, String contactname, Float longitude, Float latitude, String proptype, String parking, String treeaccess, Long clientid) {
        this.label = label;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.contactname = contactname;
        this.longitude = longitude;
        this.latitude = latitude;
        this.proptype = proptype;
        this.parking = parking;
        this.treeaccess = treeaccess;
        this.clientid = clientid;
    }
    public Long getId() {
        return id;
    }
    public String getLabel() {
        return label;
    }
    public String getAddress() {
        return address;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    public String getContactname() {
        return contactname;
    }
    public Float getLongitude() {
        return longitude;
    }
    public Float getLatitude() {
        return latitude;
    }
    public String getProptype() {
        return proptype;
    }
    public String getParking() {
        return parking;
    }
    public String getTreeaccess() {
        return treeaccess;
    }
    public Long getClientid() {
        return clientid;
    }
}
