package holloway.nate.atm;

import java.util.ArrayList;

/**
 * Created by nathanielholloway on 9/18/16.
 */
public class BankEngine {

    CustomerManager customerManager;
    AccountManager accountManager;
    TransactionManager transactionManager;

    public BankEngine(){
        customerManager = new CustomerManager();
        accountManager = new AccountManager();
        transactionManager = new TransactionManager();
    }

    public Customer createNewCustomer(String firstName, String lastName, String pin){
        return customerManager.createNewCustomer(firstName,lastName,pin);
    }

    public Account createNewAccount(int customerId, Account.AccountType type, double amount){
        return accountManager.createNewAccount(customerId, type, amount);
    }

    public boolean withdrawal(int id, double amount){
        return accountManager.withdrawal(id, amount);
    }

    public boolean deposit(int id, double amount){
        return accountManager.deposit(id, amount);
    }

    public boolean transfer( Account account1, Account account2, double amount){
        if(account1.getCustomerID()==account2.getCustomerID()) {
            return accountManager.transfer(account1, account2, amount);
        } else {
            System.out.println("This operation cannot be performed.");
            return false;
        }
    }

    public double checkBalance(Account account){
        return accountManager.balanceInquiry(account.getAccountID());
    }

    public boolean authenticate(int customerNumber, String pin){

        try{
            Customer thisCustomer = customerManager.getCustomerById(customerNumber);
            if (thisCustomer != null && thisCustomer.getPin().equals(customerManager.findPin(pin))) {
                return true;
            }
        }
        catch (Exception e){
            return false;
        }

        return false;
    }

    public Account getAccountByID(int id){
        return accountManager.getAccountById(id);
    }

    public ArrayList<Account> getCustomerAccounts(Customer customer){
        return accountManager.getCustomerAccounts(customer.getCustomerID());

    }
}
