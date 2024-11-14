package com.example.scheduleapp.service;

import com.example.scheduleapp.dto.ScheduleResponseDto;
import com.example.scheduleapp.entity.Schedule;
import com.example.scheduleapp.entity.User;
import com.example.scheduleapp.repository.ScheduleRepository;
import com.example.scheduleapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;

    //일정 생성
    public ScheduleResponseDto save(String title, String contents, String username) {

        //유저 조회 가능
        User findUser = userRepository.findMemberByUsernameOrElseThrow(username);

        Schedule schedule = new Schedule(title, contents);
        schedule.setUser(findUser);//멤버를 조회해서 참조

        //Schedule 일정 저장하기
        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(savedSchedule.getId(), savedSchedule.getTitle(), savedSchedule.getContents());
    }//save

}//end class
