import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    void should_deposit_money(){
        //Given
        Account account = new Account(); 

        //When
        account.deposit(new Amount(BigDecimal.valueOf(100))); 

        //Then
        assertEquals(1, account.history.size());
    }

}
