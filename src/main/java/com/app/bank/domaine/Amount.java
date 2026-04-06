package com.app.bank.domaine;

import java.math.BigDecimal;
import com.app.bank.exception.InvalidAmountException;

public class Amount {

    private final BigDecimal value ; 

    /**
     *  Validates that the amount is not null
     *  Ensures the value is strictly greater than zero
     */
    public Amount(BigDecimal value){
        if (value == null || value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidAmountException("Amount must be positive");
        }
        this.value = value;
    }

     public BigDecimal getValue() {
        return value;
    }

}
