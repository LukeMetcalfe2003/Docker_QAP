package com.example.member;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "members")
public class Member {
    @Id
    @SequenceGenerator(name = "member_sequence", sequenceName = "member_sequence", allocationSize = 1, initialValue = 4)
    @GeneratedValue(generator = "member_sequence")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Email
    private String email;

    private String phone;

    @DateTimeFormat
    @Column(name = "start_date") // Mapping to database column if it's named start_date
    private String startDate;

    private int duration;

    public Member() {}

    public Member(String name, String address, String email, String phone, String startDate, int duration) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.startDate = startDate;
        this.duration = duration;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}

