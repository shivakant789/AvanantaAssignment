package com.avananta.controllers;

import com.avananta.Dtos.ErrorResponseDto;
import com.avananta.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionAdvices {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDto> nothandledException(Exception exception){
        ErrorResponseDto errorResponseDto= new ErrorResponseDto();
        errorResponseDto.setErrorMessage(exception.getMessage());

        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);

    }
}

