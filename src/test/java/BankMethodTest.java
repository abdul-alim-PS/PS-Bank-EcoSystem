import org.example.AXIS.AXIS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BankMethodTest {
    @Test
    void depositMoney(){
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
