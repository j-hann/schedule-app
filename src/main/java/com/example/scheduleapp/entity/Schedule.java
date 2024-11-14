package com.example.scheduleapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//일정 id

    @Column(nullable = false)
    private String title;//제목

    @Column(columnDefinition = "longtext")
    private String contents;//내용

    //N:1 단방향
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}//end class
