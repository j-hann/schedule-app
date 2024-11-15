package com.example.scheduleapp.schedule.dto;

import lombok.Getter;

//일정 제목 수정
@Getter
public class UpdateScheduleRequestDto {

    private final String title;//일정 제목
    private final String contents;//일정 내용

    public UpdateScheduleRequestDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }//UpdateTitleRequestDto
}//end class
