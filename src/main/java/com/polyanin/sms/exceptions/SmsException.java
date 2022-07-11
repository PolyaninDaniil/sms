package com.polyanin.sms.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class SmsException extends RuntimeException{

    private final HttpStatus httpStatus;

    public SmsException(HttpStatus httpStatus, String errorMessage) {
        super(errorMessage);
        this.httpStatus = httpStatus;
    }


}
