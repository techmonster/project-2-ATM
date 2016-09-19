package holloway.nate.atm;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nathanielholloway on 9/18/16.
 */
public class AccountManagerTest {

    @Test
    public void createNewAccount(){
        BankEngine thisBankEngine = new BankEngine();
        Customer thisCustomer = thisBankEngine.createNewCustomer("Nate","Holloway","6745");
        AccountManager accountManager = new AccountManager();
        Account firstAccount = accountManager.createNewAccount(thisCustomer.getCustomerID(),Account.AccountType.INVESTMENT,300);
        Assert.assertNotNull(firstAccount);
    }

    @Test
    public void getAccountByIdTest(){
        BankEngine thisBankEngine = new BankEngine();
        Customer thisCustomer = thisBankEngine.createNewCustomer("Nate","Holloway","6745");
        Customer thisOtherCustomer = thisBankEngine.createNewCustomer("Jessica","Campos","9999");
        AccountManager accountManager = new AccountManager();
        Account firstAccount = accountManager.createNewAccount(thisCustomer.getCustomerID(),Account.AccountType.CHECKING, 500);
        Account secondAccount = accountManager.createNewAccount(thisOtherCustomer.getCustomerID(),Account.AccountType.INVESTMENT, 1000);
        Account returnedAccount = accountManager.getAccountById(secondAccount.getAccountID());
        Assert.assertNotNull(returnedAccount);
    }

    @Test
    public void changeAccountStatus(){
        BankEngine thisBankEngine = new BankEngine();
        Customer thisCustomer = thisBankEngine.createNewCustomer("Nate","Holloway","6745");
        AccountManager accountManager = new AccountManager();
        Account secondAccount = accountManager.createNewAccount(thisCustomer.getCustomerID(),Account.AccountType.INVESTMENT, 1000);
        boolean returnedAccount = accountManager.closeAccount(secondAccount.getAccountID());
        Assert.assertTrue(returnedAccount);

    }

    @Test
    public void balanceInquiryTest(){
        BankEngine thisBankEngine = new BankEngine();
        Customer thisCustomer = thisBankEngine.createNewCustomer("Nate","Holloway","6745");
        AccountManager accountManager = new AccountManager();
        Account secondAccount = accountManager.createNewAccount(thisCustomer.getCustomerID(),Account.AccountType.INVESTMENT, 1000);
        double returnedAmount = accountManager.balanceInquiry(secondAccount.getAccountID());
        Assert.assertEquals(returnedAmount, 1000.00, .1);
    }

    @Test
    public void transferBetweenAccountsAndVerifyNewBalances(){
        BankEngine thisBankEngine = new BankEngine();
        Customer thisCustomer = thisBankEngine.createNewCustomer("Nate","Holloway","6745");
        Customer thisOtherCustomer = thisBankEngine.createNewCustomer("Jessica","Campos","9999");
        AccountManager accountManager = new AccountManager();
        Account firstThisCustomerAccount = accountManager.createNewAccount(thisCustomer.getCustomerID(),Account.AccountType.CHECKING, 500);
        Account firstAccount = accountManager.createNewAccount(thisOtherCustomer.getCustomerID(),Account.AccountType.CHECKING, 500);
        Account secondAccount = accountManager.createNewAccount(thisOtherCustomer.getCustomerID(),Account.AccountType.INVESTMENT, 1000);
        boolean successful = accountManager.transfer(secondAccount, firstAccount, 500);
        Assert.assertTrue(successful);

        Assert.assertEquals(secondAccount.getAccountBalance(), 900,.01);
        Assert.assertEquals(firstAccount.getAccountBalance(), 600.0, .01);
    }
}
