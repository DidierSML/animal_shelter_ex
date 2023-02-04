package com.example.refugio.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AnimalNotFoundCustomException extends RuntimeException{

    private final String message;


}
