package com.example.scheduleapp.common.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

public class ExceptionHandlerFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        try{
            filterChain.doFilter(request, response);
        } catch (ResponseStatusException e){
            //토큰의 유효기간 만료
            setErrorResponse(response, e);
        }
    }

    private void setErrorResponse(
            HttpServletResponse response,
            ResponseStatusException e
    ){
        ObjectMapper objectMapper = new ObjectMapper();
        response.setStatus(e.getStatusCode().value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        ErrorResponse errorResponse = new ErrorResponse(e.getStatusCode().value(), e.getMessage());
        try{
            response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
        } catch (IOException ioException){
            ioException.printStackTrace();
        }
    }

    @Data
    public static class ErrorResponse{
        private final Integer code;
        private final String message;
    }
}