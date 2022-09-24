package com.kodilla.kodillalibrary.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException exception){
        return new ResponseEntity<>("User with given id not exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<Object> handleBookNotFoundException(BookNotFoundException exception){
        return new ResponseEntity<>("Book with given id not exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CopyNotFoundException.class)
    public ResponseEntity<Object> handleCopyNotFoundException(CopyNotFoundException exception){
        return new ResponseEntity<>("Copy of book with given id not exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalBookStatusException.class)
    public ResponseEntity<Object> handleIllegalBookStatusException(IllegalBookStatusException exception){
        return new ResponseEntity<>("User provided illegal book status", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BorrowNotFoundException.class)
    public ResponseEntity<Object> handleBorrowingNotFoundException(BorrowNotFoundException exception){
        return new ResponseEntity<>("Borrowing with given id not exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CopyUnavailableException.class)
    public ResponseEntity<Object> handleCopyUnavailableException(CopyUnavailableException exception){
        return new ResponseEntity<>("Provided book is unavailable to let at this moment", HttpStatus.BAD_REQUEST);
    }
}
