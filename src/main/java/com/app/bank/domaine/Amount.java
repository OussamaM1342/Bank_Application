package com.app.bank.domaine;

import java.math.BigDecimal;

public class Amount {

    private final BigDecimal value ; 

    public Amount(BigDecimal value){
        if (value == null || value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        this.value = value;
    }

     public BigDecimal getValue() {
        return value;
    }

}
