package com.example.refugio.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@Data
@AllArgsConstructor
public class AnimalNotFoundCustomExceptionResponse {


    private HttpStatus statusCode;
    private String statusMsg;

}


