package holloway.nate.atm;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nathanielholloway on 9/17/16.
 */
public class CustomerTest {

    @Test
    public void createCustomerTest(){
        Customer firstCustomer = Customer.createCustomer("Nate","Holloway","9999");
        Assert.assertNotNull(firstCustomer);
    }

    @Test
    public void createMultipleCustomersWithIncrementingIDsTest(){
        Customer firstCustomer = Customer.createCustomer("Nate","Holloway","9999");
        Customer secondCustomer = Customer.createCustomer("Rihanna","Holloway","1111");
        Assert.assertEquals(firstCustomer.getCustomerID()+1,secondCustomer.getCustomerID());
    }
}
