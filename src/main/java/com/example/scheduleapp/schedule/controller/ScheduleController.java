package com.example.scheduleapp.schedule.controller;

import com.example.scheduleapp.schedule.dto.CreateScheduleRequestDto;
import com.example.scheduleapp.schedule.dto.ScheduleResponseDto;
import com.example.scheduleapp.schedule.dto.ScheduleWithUsernameResponseDto;
import com.example.scheduleapp.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    //일정 생성(저장)
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody CreateScheduleRequestDto requestDto) {

        ScheduleResponseDto scheduleResponseDto =
                scheduleService.save(
                        requestDto.getTitle(),
                        requestDto.getContents(),
                        requestDto.getUsername()
                );
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
    }//save

    //일정 전체 조회
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAllSchedule() {

        List<ScheduleResponseDto> scheduleResponseDtoList = scheduleService.findAllSchedule();

        return new ResponseEntity<>(scheduleResponseDtoList, HttpStatus.OK);
    }//findAllSchedule

    //일정 ID로 특정 일정 조회
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleWithUsernameResponseDto> findScheduleById(@PathVariable Long id) {

        ScheduleWithUsernameResponseDto scheduleWithUsernameResponseDto = scheduleService.findScheduleById(id);

        return new ResponseEntity<>(scheduleWithUsernameResponseDto, HttpStatus.OK);
    }//findScheduleById

    //일정 ID로 특정 일정 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {

        scheduleService.deleteSchedule(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }//delete
}//end class
