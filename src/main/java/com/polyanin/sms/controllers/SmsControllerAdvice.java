package com.polyanin.sms.controllers;

import com.polyanin.sms.exceptions.SmsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(basePackageClasses = EmployeeController.class)
public class SmsControllerAdvice {

    @ExceptionHandler(SmsException.class)
    @ResponseBody
    ResponseEntity<?> handleControllerException(HttpServletRequest request, SmsException ex) {

        return new ResponseEntity<>(ex.getMessage(), ex.getHttpStatus());
    }

}
