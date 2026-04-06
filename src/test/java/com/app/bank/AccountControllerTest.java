package com.app.bank;

import java.math.BigDecimal;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import com.app.bank.controller.AccountController;
import com.app.bank.service.AccountService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post; 
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status; 
import org.springframework.http.MediaType;

@WebMvcTest(AccountController.class) 
public class AccountControllerTest {

     @Autowired
     private MockMvc mockMvc;

     @MockitoBean
     private AccountService accountService; 

    /**
    * Test of the Withdrawal API
    */
     @Test
    public void testDepositTransaction() throws Exception {
        String depositJson = "{ \"amount\": 100.0 }";

        mockMvc.perform(post("/api/account/deposit")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(depositJson))
               .andExpect(status().isOk());

        Mockito.verify(accountService)
               .deposit(new BigDecimal("100.0"));
    }

    /**
    * Test of the Withdrawal API
    */
     @Test
    public void testWithdrawalTransaction() throws Exception {
        String withdrawalJson = "{ \"amount\": 50}";

        mockMvc.perform(post("/api/account/withdrawal")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(withdrawalJson))
               .andExpect(status().isOk());

        Mockito.verify(accountService)
               .withdrawal(new BigDecimal(50));
    }

    /**
    * Test of the history API
    */
    @Test
    public void testTransactionHistory() throws Exception {
        mockMvc.perform(get("/api/account/history"))
               .andExpect(status().isOk());

        Mockito.verify(accountService)
               .getHistory();
}
}
