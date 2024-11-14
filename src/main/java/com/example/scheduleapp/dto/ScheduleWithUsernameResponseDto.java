package com.example.scheduleapp.dto;

import lombok.Getter;

//응답에 유저 이름 포함
@Getter
public class ScheduleWithUsernameResponseDto {
    private final String title;//일정 제목
    private final String contents;//일정 내용
    private final String username;//사용자 이름

    public ScheduleWithUsernameResponseDto(String title, String contents, String username) {
        this.title = title;
        this.contents = contents;
        this.username = username;
    }//ScheduleWithUsernameResponseDto
}//end class
