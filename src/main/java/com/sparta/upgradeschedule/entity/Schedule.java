package com.sparta.upgradeschedule.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
//@Table(name = "schedule")
@EntityListeners(AuditingEntityListener.class)
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String user;
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
    @OneToMany(mappedBy = "schedule")
    private List<Comment> commentList = new ArrayList<>();
}

