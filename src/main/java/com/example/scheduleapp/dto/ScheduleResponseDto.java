package com.example.scheduleapp.dto;

import lombok.Getter;

@Getter
public class ScheduleResponseDto {
    private final Long id;//일정 id
    private final String title;//일정 제목
    private final String contents;//일정 내용
    
    //생성자
    public ScheduleResponseDto(Long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }//ScheduleResponseDto
}//end class
