package holloway.nate.atm;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nathanielholloway on 9/18/16.
 */
public class BankEngineTest {

    @Test
    public void createNewCustomer(){
        BankEngine customerManager = new BankEngine();
        Customer firstCustomer = customerManager.createNewCustomer("Nate","Holloway","9999");
        Assert.assertNotNull(firstCustomer);
    }

    @Test
    public void createNewAccount(){
        BankEngine manager = new BankEngine();
        Customer firstCustomer = Customer.createCustomer("Nate","Holloway","9999");
        Account firstAccount = manager.createNewAccount(firstCustomer.getCustomerID(), Account.AccountType.SAVINGS,5000);
        Assert.assertNotNull(firstAccount);
    }

    @Test
    public void depositTest(){
        BankEngine manager = new BankEngine();
        Customer firstCustomer = Customer.createCustomer("Nate","Holloway","9999");
        Account firstAccount = manager.createNewAccount(firstCustomer.getCustomerID(), Account.AccountType.SAVINGS,10000);
        Account secondAccount = manager.createNewAccount(firstCustomer.getCustomerID(), Account.AccountType.CHECKING,500);
        boolean isTrue = manager.deposit(firstAccount.getAccountID(),500);
        Assert.assertTrue(isTrue);
    }

    @Test
    public void withdrawalTest(){
        BankEngine manager = new BankEngine();
        Customer firstCustomer = Customer.createCustomer("Nate","Holloway","9999");
        Account firstAccount = manager.createNewAccount(firstCustomer.getCustomerID(), Account.AccountType.SAVINGS,10000);
        Account secondAccount = manager.createNewAccount(firstCustomer.getCustomerID(), Account.AccountType.CHECKING,500);
        boolean isTrue = manager.withdrawal(firstAccount.getAccountID(),500);
        Assert.assertTrue(isTrue);
    }

    @Test
    public void transferTest(){
        BankEngine manager = new BankEngine();
        Customer firstCustomer = Customer.createCustomer("Nate","Holloway","9999");
        Customer secondCustomer = Customer.createCustomer("Nate","Holloway","9898");
        Account firstAccount = manager.createNewAccount(firstCustomer.getCustomerID(), Account.AccountType.SAVINGS,10000);
        Account secondAccount = manager.createNewAccount(firstCustomer.getCustomerID(), Account.AccountType.CHECKING,500);
        Account otherCustomerAccount = manager.createNewAccount(secondCustomer.getCustomerID(), Account.AccountType.CHECKING,250000);
        boolean isTrue = manager.transfer(firstAccount,secondAccount,1500);
        Assert.assertTrue(isTrue);
    }
}
