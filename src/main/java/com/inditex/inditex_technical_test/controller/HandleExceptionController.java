package com.inditex.inditex_technical_test.controller;

import com.inditex.inditex_technical_test.exception.AlbumDataInternalServerErrorException;
import com.inditex.inditex_technical_test.exception.AlbumDataNotContentException;
import com.inditex.inditex_technical_test.exception.AlbumDataNotFoundException;
import com.inditex.inditex_technical_test.exception.AlbumSQLErrorServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleExceptionController {
    @ExceptionHandler(value = AlbumDataNotFoundException.class)
    public ResponseEntity<Object> exception1(AlbumDataNotFoundException exception) {
        return new ResponseEntity<>("Error 404 : Album data not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = AlbumDataInternalServerErrorException.class)
    public ResponseEntity<Object> exception2(AlbumDataInternalServerErrorException exception) {
        return new ResponseEntity<>("Error 500 : It's not possible to process this Album data", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = AlbumDataNotContentException.class)
    public ResponseEntity<Object> exception3(AlbumDataNotContentException exception) {
        return new ResponseEntity<>("Error 204 : No content Album data have been added to the Response", HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(value = AlbumSQLErrorServiceException.class)
    public ResponseEntity<Object> exception3(AlbumSQLErrorServiceException exception) {
        return new ResponseEntity<>("Error 500 SQL : A SQL error in H2 database have occurred", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
