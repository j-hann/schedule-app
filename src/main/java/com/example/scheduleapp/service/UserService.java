package com.example.scheduleapp.service;

import com.example.scheduleapp.dto.SignUpResponseDto;
import com.example.scheduleapp.entity.User;
import com.example.scheduleapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public SignUpResponseDto signUp(String username, String password, String email) {
        User user = new User(username, password, email);
        User savedMember = userRepository.save(user);

        return new SignUpResponseDto(savedMember.getId(), savedMember.getUsername(), savedMember.getEmail());
    }//signUp
}//end class
