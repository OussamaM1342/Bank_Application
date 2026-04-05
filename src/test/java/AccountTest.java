import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.app.bank.domaine.Account;
import com.app.bank.domaine.Amount;

public class AccountTest {

    @Test
    void should_deposit_money(){
        //Given
        Account account = new Account(); 

        //When
        account.deposit(new Amount(BigDecimal.valueOf(100)), LocalDate.now()); 

        //Then
        assertEquals(1, account.history().size());
    }

    @Test
    void should_rejet_negative_deposit(){
        Account account = new Account() ; 
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(new Amount(BigDecimal.valueOf(-50)), LocalDate.now());
        
        }); 
    }

}
