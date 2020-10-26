package com.expressacademy.professores.controller.advice;

import com.expressacademy.professores.response.ValidationExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class ValidationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidationExceptionResponse handle(MethodArgumentNotValidException e) {
        log.info("M=handle, I=Parametros invalidos, Message={}", e.getMessage());
        List<String> errors = e.getBindingResult()
                                .getAllErrors()
                                .stream()
                                .map(objectError -> objectError.getDefaultMessage())
                                .collect(Collectors.toList());

        ValidationExceptionResponse response = new ValidationExceptionResponse();

        response.setDate(LocalDateTime.now());
        response.setErrors(errors);
        response.setMessage("Field validation error. Please check your request");

        return response;
    }

}
