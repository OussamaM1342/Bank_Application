package com.app.bank.domaine;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
* Represents a financial transaction in the account
*  Stores all necessary information for account statement/history
*/
public record Transaction(LocalDate date, BigDecimal amount, BigDecimal balance, TransactionType type){
}
