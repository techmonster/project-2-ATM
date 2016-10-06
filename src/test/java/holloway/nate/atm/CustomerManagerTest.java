package holloway.nate.atm;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nathanielholloway on 9/17/16.
 * This class was created to test the CustomerManager class.
 */
public class CustomerManagerTest {

    @Test
    public void createNewCustomer(){
        CustomerManager customerManager = new CustomerManager();
        Customer firstCustomer = customerManager.createNewCustomer("Nate","Holloway","9999");
        Assert.assertNotNull(firstCustomer);
    }

    @Test
    public void getCustomerByIdTest(){

        CustomerManager customerManager = new CustomerManager();
        Customer firstCustomer = customerManager.createNewCustomer("Nate","Holloway","9999");
        Customer secondCustomer = customerManager.createNewCustomer("Rihanna","Holloway","1111");
        Customer returnedCustomer = customerManager.getCustomerById(secondCustomer.getCustomerID());
        Assert.assertNotNull(returnedCustomer);
    }

    @Test
    public void findPin(){
        CustomerManager customerManager = new CustomerManager();
        Customer firstCustomer = customerManager.createNewCustomer("Nate","Holloway","9999");
        Customer secondCustomer = customerManager.createNewCustomer("Rihanna","Holloway","1111");
        String actual = customerManager.findPin("1111");
        String expected = secondCustomer.getPin();
        Assert.assertEquals(expected,actual);
    }
}
