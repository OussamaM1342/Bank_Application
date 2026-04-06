package com.app.bank.domaine;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.app.bank.exception.InsufficientBalanceException;

public class Account {

    /**
    * List of all transactions  on this account
    */
    private final List<Transaction> transactions = new ArrayList<>() ; 

    /**
    * Current balance of the account.
    */
    private BigDecimal balance = BigDecimal.ZERO ; 

    public BigDecimal getBalance() {
    return balance;
    }

    /**
    * Deposits a given amount into the account.
    * the amount to deposit must be positive
    */
    public void deposit(Amount amount, LocalDate date){
        balance = balance.add(amount.getValue()) ;

        transactions.add(new Transaction(
            date,
            amount.getValue(),
            balance,
            TransactionType.DEPOSIT
        ));
    }

    /**
    * Withdraws a given amount from the account.
    * Checks if the balance is sufficient, updates the balance,
    */
    public void withdrawal(Amount amount, LocalDate date ){
         if(amount.getValue().compareTo(balance) > 0){
            throw new InsufficientBalanceException("Insufficient balance");
         }
         balance = balance.subtract(amount.getValue()) ;
         transactions.add(new Transaction(
            date,
            amount.getValue().negate(),
            balance,
            TransactionType.WITHDRAWAL
        ));

    }
    /**
    * Returns the transaction history of the account.
    * return an immutable copy of the list of transactions
    */
    public List<Transaction> history(){
        return List.copyOf(transactions)  ; 
    }

}
