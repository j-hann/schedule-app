package com.example.scheduleapp.common.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.util.PatternMatchUtils;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@Slf4j//log 작성
public class LoginFilter implements Filter {
    //인증을 하지 않아도 되는 URL Path 배열
    private static final String[] WHITE_LIST = {"/", "/users/signup", "/login", "/logout"};

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {

        //다양한 기능을 사용하기 위해 다운 캐스팅
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();

        HttpServletResponse httpResponse = (HttpServletResponse) response;

        log.info("로그인 필터 로직 실행");

        //로그인을 체크 해야하는 URL인지 검사 -> whiteListURL에 포함된 경우 true 반환
        if (!isWhiteList(requestURI)) {

            //로그인 확인 -> 세션이 존재하면 가져온다. 세션이 없으면 새로운 세션 생성 x
            HttpSession session = httpRequest.getSession(false);

            //로그인하지 않은 사용자인 경우
            if (session == null || session.getAttribute("email") == null) {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED ,"로그인을 해주세요.");
            }//if

            //로그인 성공한 경우
            log.info("로그인에 성공했습니다.");
        }//if

        //등록되지 않은 URL 요청이면, 필터 로직 통과 후 실행
        chain.doFilter(request, response);
        }//doFilter

        //로그인 여부를 확인하는 URL인지 체크하는 메서드
        private boolean isWhiteList (String requestURI){
            // request URI가 whiteListURL에 포함되는지 확인 -> 포함되면 true, 포함되지 않으면 false 반환
            return PatternMatchUtils.simpleMatch(WHITE_LIST, requestURI);
        }//isWhiteList

    }//end class
