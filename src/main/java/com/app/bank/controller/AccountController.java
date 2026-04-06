package com.app.bank.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.app.bank.service.AccountService;
import com.app.bank.DTO.DepositRequest;
import com.app.bank.DTO.WithdrawlRequest;

import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService acountService; 

   @PostMapping("/deposit")
    public void deposit(@RequestBody DepositRequest depositRequest){
        acountService.deposit(depositRequest.getAmount());
    }

    @PostMapping("/withdrawal")
    public void withdrawal(@RequestBody WithdrawlRequest withdrawlRequest){
        acountService.withdrawal(withdrawlRequest.getAmount());

    }
}
