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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post; 
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status; 
import org.springframework.http.MediaType;

@WebMvcTest(AccountController.class) // Charge seulement le controller
public class AccountControllerTest {

     @Autowired
     private MockMvc mockMvc;

     @MockitoBean
     private AccountService accountService; // Mock du service

     @Test
    public void testDeposit() throws Exception {
        // Prepare the JSON request
        String depositJson = "{ \"amount\": 100.0 }";

        // Perform the POST request
        mockMvc.perform(post("/api/account/deposit")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(depositJson))
                .andExpect(status().isOk());

        // Verify that the service was called with the correct amount
        Mockito.verify(accountService).deposit(new BigDecimal("100.0"));
    }
}
