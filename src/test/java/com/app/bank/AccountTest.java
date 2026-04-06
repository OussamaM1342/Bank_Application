package com.app.bank;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.app.bank.domaine.Account;
import com.app.bank.domaine.Amount;
import com.app.bank.exception.InvalidAmountException;
import com.app.bank.service.AccountService;

public class AccountTest {

    /**
     * Verifies that a deposit operation:
     */
    @Test
    void should_deposit_money(){
        //Given
        Account account = new Account(); 

        //When
        account.deposit(new Amount(BigDecimal.valueOf(100)), LocalDate.now()); 

        //Then
        assertEquals(1, account.history().size());
    }

    /**
     * Verifies that depositing a negative amount is rejected.
     */
    @Test
    void should_rejet_negative_deposit(){
        Account account = new Account() ; 
        assertThrows(InvalidAmountException.class, () -> {
        account.deposit(new Amount(BigDecimal.valueOf(-50)), LocalDate.now());
        }); 
    }

    /**
     * Verifies that a withdrawal operation:
     */
    @Test
    void withdraw_shouldDecreaseBalance_whenSufficientFunds() {
        //Given 
        Account account = new Account() ; 

        //When
        account.withdraw(new Amount(BigDecimal.valueOf(100)), LocalDate.now()); 

        //Then
        assertEquals(new BigDecimal("60.0"), account.getBalance());
    }
}
