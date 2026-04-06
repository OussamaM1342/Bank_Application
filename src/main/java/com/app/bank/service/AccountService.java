package com.app.bank.service;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDate;
import org.springframework.stereotype.Service;
import com.app.bank.domaine.Account;
import com.app.bank.domaine.Amount;

@Service
public class AccountService {

    private final Account acount = new Account() ;
    private final Clock clock = Clock.systemDefaultZone() ; 

    public void deposit(BigDecimal amount){
      acount.deposit(new Amount(amount), LocalDate.now(clock));
    }

    
     
}
