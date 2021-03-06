package library.exception;

import library.exception.exception.*;
import library.jpa.responceEntity.EntityResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.Timestamp;

@RestControllerAdvice
class APIHandleException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleException(ApiRequestException e) {
        return createResEntity(e.getMessage(), 400);
    }

    @ExceptionHandler(value = {ExistException.class})
    public ResponseEntity<Object> handleExist(ExistException e) {
        return createResEntity(e.getMessage(), 400);
    }

    @ExceptionHandler(value = {NullException.class})
    public ResponseEntity<Object> handleNull(NullException e) {
        return createResEntity(e.getMessage(), 400);
    }

    @ExceptionHandler(value = {EmptyException.class})
    public ResponseEntity<Object> handleExist(EmptyException e) {
        return createResEntity(e.getMessage(), 400);
    }

    @ExceptionHandler(value = {ExistNullOrBorrowedBookException.class})
    public ResponseEntity<Object> handleBookIsBorrowed(ExistNullOrBorrowedBookException e) {
        return createResEntity(e.getMessage(), 400,e.getData());
    }

    public ResponseEntity<Object> createResEntity(String message, int status) {
        EntityResponse responseEntity = new EntityResponse(status,
                new Timestamp(System.currentTimeMillis()), message, null);
        return new ResponseEntity<>(responseEntity, HttpStatus.resolve(status));
    }
    public ResponseEntity<Object> createResEntity(String message, int status,Object object) {
        EntityResponse responseEntity = new EntityResponse(status,
                new Timestamp(System.currentTimeMillis()), message, object);
        return new ResponseEntity<>(responseEntity, HttpStatus.resolve(status));
    }


}
