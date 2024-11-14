package com.example.scheduleapp.entity;

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
public class User extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //사용자 id

    @Column(nullable = false, unique = true)//unique 설정
    private String username;//사용자 이름

    @Column(nullable = false)
    private String password;//비밀번호

    private String email;//이메일

    public User(){
    }//User

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }//User

}//end class