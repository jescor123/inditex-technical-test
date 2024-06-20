package com.inditex.inditex_technical_test.controller;

import com.inditex.inditex_technical_test.exception.SpaceShipInternalServerErrorException;
import com.inditex.inditex_technical_test.exception.SpaceShipNotContentException;
import com.inditex.inditex_technical_test.exception.SpaceShipNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleExceptionController {
    @ExceptionHandler(value = SpaceShipNotFoundException.class)
    public ResponseEntity<Object> exception1(SpaceShipNotFoundException exception) {
        return new ResponseEntity<>("Error 404 : SpaceShip Id not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = SpaceShipInternalServerErrorException.class)
    public ResponseEntity<Object> exception2(SpaceShipInternalServerErrorException exception) {
        return new ResponseEntity<>("Error 500 : It's not possible to process the SpaceShip", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = SpaceShipNotContentException.class)
    public ResponseEntity<Object> exception3(SpaceShipNotContentException exception) {
        return new ResponseEntity<>("Error 204 : No content SpaceShip has been added to the Response", HttpStatus.NO_CONTENT);
    }

}
