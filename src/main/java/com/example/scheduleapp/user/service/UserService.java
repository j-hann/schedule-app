package com.example.scheduleapp.user.service;

import com.example.scheduleapp.user.dto.SignUpResponseDto;
import com.example.scheduleapp.user.dto.UserResponseDto;
import com.example.scheduleapp.user.entity.User;
import com.example.scheduleapp.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    //회원가입
    public SignUpResponseDto signUp(String username, String password, String email) {
        User user = new User(username, password, email);
        User savedMember = userRepository.save(user);

        return new SignUpResponseDto(savedMember.getId(), savedMember.getUsername(), savedMember.getEmail());
    }//signUp

    //사용자 조회
    public UserResponseDto findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        // NullPointerException 방지
        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }//if

        User findUser = optionalUser.get();
        //사용자 이름, 사용자 이메일 응답
        return new UserResponseDto(findUser.getUsername(), findUser.getEmail());
    }//findById


}//end class
