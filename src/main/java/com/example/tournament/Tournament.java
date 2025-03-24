package com.example.tournament;

import jakarta.persistence.*;
import com.example.member.Member;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

@Entity
@Table(name = "Tournaments")
public class Tournament {
    @Id
    @SequenceGenerator(name = "tournament_sequence", sequenceName = "tournament_sequence", allocationSize = 1, initialValue = 3)
    @GeneratedValue(generator = "tournament_sequence")
    private long id;

    @DateTimeFormat
    @Column(name = "start_date") // Ensure correct database column mapping
    private String startDate;

    @DateTimeFormat
    @Column(name = "end_date")
    private String endDate;

    private String location;
    private double entryFee;
    private double cashPrize;

    @ManyToMany
    @JoinTable(
            name = "tournament_participants",
            joinColumns = @JoinColumn(name = "tournament_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id")
    )
    private List<Member> participants;

    public Tournament() {}

    public Tournament(String startDate, String endDate, String location, double entryFee, double cashPrize, List<Member> participants) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.entryFee = entryFee;
        this.cashPrize = cashPrize;
        this.participants = participants;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(double entryFee) {
        this.entryFee = entryFee;
    }

    public double getCashPrize() {
        return cashPrize;
    }

    public void setCashPrize(double cashPrize) {
        this.cashPrize = cashPrize;
    }

    public List<Member> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Member> participants) {
        this.participants = participants;
    }
}
