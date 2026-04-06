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

    /**
     * Handles business exception : insufficient balance
     */
    @ExceptionHandler(InsufficientBalanceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse InsufficientBalanceException(InsufficientBalanceException ex){
        return new ErrorResponse("INSUFFICIENT_BALANCE", ex.getMessage()); 
    }

    
    /**
     * Unexcepted Error
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleGeneric(Exception ex){
        return new ErrorResponse("INTERNAL_ERROR", "An unexpected error occurred"); 
    }

    
}
 
