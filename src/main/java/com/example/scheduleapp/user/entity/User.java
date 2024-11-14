package com.example.scheduleapp.user.entity;

import com.example.scheduleapp.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "user")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //사용자 id

    @Column(length = 10, nullable = false, unique = true)//unique 설정
    private String username;//사용자 이름

    @Column(nullable = false)
    private String password;//사용자 비밀번호

    @Column(nullable = false)
    private String email;//사용자 이메일

    public User(){
    }//User

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }//User

}//end class
