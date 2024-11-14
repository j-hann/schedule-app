package com.example.scheduleapp.dto;

import lombok.Getter;

//게시글 생성
@Getter
public class CreateScheduleRequestDto {
    private final String title;//일정 제목
    private final String contents;//일정 내용
    private final String username;//사용자 이름

    //생성자
    public CreateScheduleRequestDto(String title, String contents, String username) {
        this.title = title;
        this.contents = contents;
        this.username = username;
    }//CreateBoardRequestDto
}//end class
