package com.sparta.upgradeschedule.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
//@Table(name = "schedule")
@EntityListeners(AuditingEntityListener.class) // this is needed for date.time generation
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId; // unique user id
    private String title;
    private String content;

    @CreatedDate
    @Column(name = "date_created", updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "date_modified")
    private LocalDateTime modifiedDate;

    // mappedBy corresponds to the name of the field
    // in the "child" entity that owns the relationship
    @OneToMany(mappedBy = "schedule", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Comment> commentList = new ArrayList<>();
    //orphanRemoval should be set to true in cases for DB to be synchronized when individual comments are deleted

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.REMOVE)
    private List<Participant> participantList = new ArrayList<>(); // participants for this schedule

}

