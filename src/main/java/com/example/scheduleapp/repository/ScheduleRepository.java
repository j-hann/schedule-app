package com.example.scheduleapp.repository;

import com.example.scheduleapp.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    //일정 ID로 특정 일정 조회
    default Schedule findScheduleByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id));
    }//findScheduleByIdOrElseThrow
}//end class
