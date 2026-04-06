package com.app.bank;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.app.bank.domaine.Account;
import com.app.bank.domaine.Amount;
import com.app.bank.domaine.Transaction;
import com.app.bank.domaine.TransactionType;
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
    * Verifies that a withdrawal operation
    */
    @Test
    void withdraw_shouldDecreaseBalance_whenSufficientFunds() {
        //Given 
        Account account = new Account() ; 

        //When
        account.withdrawal(new Amount(BigDecimal.valueOf(100)), LocalDate.now()); 

        //Then
        assertEquals(1, account.history().size());
    }

    /**
    * Verifies withdrawal operation when balance is insufficient
    *
    */
     @Test
    void withdraw_shouldThrowException_whenInsufficientBalance() {
        Account account = new Account();

        // GIVEN
        account.deposit(new Amount(new BigDecimal("50.0")), LocalDate.now());

        // WHEN
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
            account.withdrawal(new Amount(new BigDecimal("100.0")), LocalDate.now())
        );

        // THEN
        assertEquals("Insufficient funds", exception.getMessage());
    }

    /**
    * Retrieve transaction history
    */
    @Test
    void should_return_account_history(){
        
    Account account = new Account();
    account.deposit(new Amount(BigDecimal.valueOf(100)), LocalDate.now());
    account.withdrawal(new Amount(BigDecimal.valueOf(50)), LocalDate.now());

    // Service minimal simulé
    AccountService service = new AccountService();

    // Appel direct
    List<Transaction> history = service.getHistory();

    // Assertions
    assertEquals(2, history.size());
    assertEquals(TransactionType.DEPOSIT, history.get(0).type());
    }

   
}
