package com.sparta.upgradeschedule.entity;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="schedule_id")
    private Schedule schedule;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Participant(Schedule schedule, User user) {
        this.schedule = schedule;
        this.user = user;
    }

    public Participant() {}
}
