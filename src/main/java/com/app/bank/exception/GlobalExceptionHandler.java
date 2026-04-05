package com.app.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handle invalid input
    */
    @ExceptionHandler(InvalidAmountException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleInvalidAmount(InvalidAmountException  ex){
        return new ErrorResponse("INVALID_AMOUNT ", ex.getMessage()) ;
    }

    
}
 
