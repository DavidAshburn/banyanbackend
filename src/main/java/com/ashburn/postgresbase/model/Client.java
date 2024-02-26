package com.ashburn.postgresbase.model;

import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String contact_name;
    private String phone;
    private String email;
    private String mail_address;
    private String notes;
    private Long user_id;

    public Client() {
    }

    public Client(String name, String contact_name, String phone, String email, String mail_address, String notes, Long user_id) {
        this.name = name;
        this.contact_name = contact_name;
        this.phone = phone;
        this.email = email;
        this.mail_address = mail_address;
        this.notes = notes;
        this.user_id = user_id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContact_name() {
        return contact_name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getMail_address() {
        return mail_address;
    }

    public String getNotes() {
        return notes;
    }

    public Long getUser_id() {
        return user_id;
    }
}
