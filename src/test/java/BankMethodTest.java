import org.example.AXIS.AXIS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BankMethodTest {
    @Test
    void depositMoney(){
        // This axis constructor will create a customer with 10000 balance.
        // I am checking for only one axis class methods as other implemented method similarly
        // just the minimum_balance or ROI are different.
        AXIS axis = new AXIS();
        float money = 1000;
        axis.depositMoney(money);
        float result = axis.getCustomer().getBalance();
        Assertions.assertEquals(11000f,result);
    }
    @Test
    void withDrawMoney(){
        AXIS axis = new AXIS();
        float money = 1000;
        axis.withdrawMoney(money);
        float result = axis.getCustomer().getBalance();
        Assertions.assertEquals(9000f,result);
        axis.withdrawMoney(5000f);
        // I have set the minimum balance for this bank to be 5000 so this withdraw
        // must not happen as the balance of the user will be set to 4000<5000
        // For this reason I am checking if the balance still 9000.
        Assertions.assertEquals(9000f,axis.getCustomer().getBalance());
    }
    @Test
    void openFD(){
        AXIS axis = new AXIS();
        float money = 10000;
        float arr[] = { 10100f, 10201f, 10303.01f};
        axis.openFD(money,0.01f,3);
        float[] result = axis.fd;
        Assertions.assertArrayEquals(arr,result);
    }
    @Test
    void applyLoan(){
        AXIS axis = new AXIS();
        float money = 10000;
        axis.depositMoney(10000);
        axis.applyLoan("Test",money,0.01f,2);
        Assertions.assertEquals(10201f,axis.loanAmount);
    }
    @Test
    void applyCC(){
        AXIS axis = new AXIS();
        axis.depositMoney(10000);
        axis.applyCreditCard();
        Assertions.assertEquals(true,axis.applyCC);
    }
}
