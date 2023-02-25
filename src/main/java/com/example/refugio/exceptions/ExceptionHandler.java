package com.example.refugio.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class ExceptionHandler{

//    @org.springframework.web.bind.annotation.ExceptionHandler({Exception.class})
//    public ResponseEntity<Response> exceptionHandler(Exception exception){
//        Response response = new Response("500",
//                exception.getMessage());
//        return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @org.springframework.web.bind.annotation.ExceptionHandler(AnimalNotFoundCustomException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public AnimalNotFoundCustomExceptionResponse handleAnimalNotFoundException (AnimalNotFoundCustomException ex){

        return new AnimalNotFoundCustomExceptionResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    }


}
