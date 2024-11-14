package com.example.scheduleapp.schedule.entity;

import com.example.scheduleapp.common.entity.BaseEntity;
import com.example.scheduleapp.user.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//일정 id

    @Column(nullable = false)
    private String title;//일정 제목

    @Column(columnDefinition = "longtext")
    private String contents;//일정 내용

    //N:1
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //생성자
    public Schedule(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }//Schedule

    public Schedule() {
    }//Schedule

    //작성자 추가 메서드
    public void setUser(User user) {
        this.user = user;
    }//setUser

}//end class
