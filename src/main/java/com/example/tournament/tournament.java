package com.example.tournament;
import jakarta.persistence.*;
import com.example.member.member;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

@Entity
@Table(name = "Tournaments")
public class tournament {
    @Id
    @SequenceGenerator(name = "member_sequence", sequenceName = "member_sequence", allocationSize = 1, initialValue = 3)
    @GeneratedValue(generator = "member_sequence")
    private long id;

    @DateTimeFormat
    private String start_date;

    @DateTimeFormat
    private String end_date;

    private String location;

    private double entry_fee;

    private double cash_prize;

    @ManyToMany
    @JoinTable(
            name = "tournament_participants",
            joinColumns = @JoinColumn(name = "tournament_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id")
    )

    private List<member> participants;

    public tournament() {}

    public tournament(String start_date, String end_date, String location, double entry_fee, double cash_prize, List<member> participants) {
        this.start_date = start_date;
        this.end_date = end_date;
        this.location = location;
        this.entry_fee = entry_fee;
        this.cash_prize = cash_prize;
        this.participants = participants;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getEntry_fee() {
        return entry_fee;
    }

    public void setEntry_fee(double entry_fee) {
        this.entry_fee = entry_fee;
    }

    public double getCash_prize() {
        return cash_prize;
    }

    public void setCash_prize(double cash_prize) {
        this.cash_prize = cash_prize;
    }

    public List<member> getParticipants() {
        return participants;
    }

    public void setParticipants(List<member> participants) {
        this.participants = participants;
    }

}
