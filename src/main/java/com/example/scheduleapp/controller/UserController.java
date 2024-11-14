package com.example.scheduleapp.controller;

import com.example.scheduleapp.dto.SignUpRequestDto;
import com.example.scheduleapp.dto.SignUpResponseDto;
import com.example.scheduleapp.dto.UserResponseDto;
import com.example.scheduleapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")//url 설정
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    //사용자 생성(회원가입)
    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto) {

        SignUpResponseDto signUpResponseDto =
                userService.signUp(
                        requestDto.getUsername(),
                        requestDto.getPassword(),
                        requestDto.getEmail()
                );

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);//성공하면 CREATED
    }//signUp

    //사용자 조회
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id) {

        UserResponseDto memberResponseDto = userService.findById(id);

        return new ResponseEntity<>(memberResponseDto, HttpStatus.OK);
    }//findById

}//end class
