package com.example.scheduleapp.schedule.repository;

import com.example.scheduleapp.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    //조회
    //일정 id가 없을 경우 예외처리
    default Schedule findScheduleByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 일정이 존재하지 않습니다." + id));
    }//findScheduleByIdOrElseThrow
}//end class
