package com.example.scheduleapp.repository;

import com.example.scheduleapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //조회
    Optional<User> findUserByUsername(String username);
    //예외처리
    default User findMemberByUsernameOrElseThrow(String username) {
        return findUserByUsername(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist username = " + username));
    }//findMemberByUsernameOrElseThrow

}//end interface
