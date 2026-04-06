package com.app.bank.service;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import com.app.bank.domaine.Account;
import com.app.bank.domaine.Amount;
import com.app.bank.domaine.Transaction;

@Service
public class AccountService {

    private final Account account = new Account() ;
    private final Clock clock = Clock.systemDefaultZone() ; 

     /**
     * Deposit a given amount into the account.
     */
    public void deposit(BigDecimal amount){
      account.deposit(new Amount(amount), LocalDate.now(clock));
    }

     /**
     * withdrawal a given amount into the account.
     */
    public void withdrawal(BigDecimal amount){
        account.withdrawal(new Amount(amount), LocalDate.now(clock));
    }

    /**
    * Get list of transactions
    */
    public List<Transaction> getHistory(){
      return account.history() ; 
    }

    

    

    

    

    
     
}
