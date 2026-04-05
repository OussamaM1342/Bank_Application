import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
