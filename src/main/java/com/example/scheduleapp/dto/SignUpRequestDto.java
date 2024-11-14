package com.example.scheduleapp.dto;

import lombok.Getter;

//회원가입 api
//Request 요청
@Getter
public class SignUpRequestDto {
    private final String username;//사용자 이름
    private final String password;//비밀번호
    private final String email;//이메일

    //리퀘스트 요청이 오면 작성자, 비밀번호, 이메일 입력받음
    public SignUpRequestDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }//SignUpRequestDto
}//end class
