package holloway.nate.atm;

import java.util.ArrayList;

/**
 * Created by nathanielholloway on 9/18/16.
 * This class is where all of the classes meet.
 */
final class BankEngine {

    private CustomerManager customerManager;
    private AccountManager accountManager;
    private TransactionManager transactionManager;

    BankEngine(){
        customerManager = new CustomerManager();
        accountManager = new AccountManager();
        transactionManager = new TransactionManager();
    }

    Customer createNewCustomer(String firstName, String lastName, String pin){
        return customerManager.createNewCustomer(firstName,lastName,pin);
    }

    Account createNewAccount(int customerId, Account.AccountType type, double amount){
        return accountManager.createNewAccount(customerId, type, amount);
    }

    boolean withdrawal(int accountId, double amount){
        return accountManager.withdrawal(accountId, amount);
    }

    boolean deposit(int accountId, double amount){
        return accountManager.deposit(accountId, amount);
    }

    boolean transfer( Account account1, Account account2, double amount){
        if(account1.getCustomerID()==account2.getCustomerID()) {
            return accountManager.transfer(account1, account2, amount);
        } else {
            System.out.println("This operation cannot be performed.");
            return false;
        }
    }

    double checkBalance(Account account){
        return accountManager.balanceInquiry(account.getAccountID());
    }

    boolean authenticate(int customerNumber, String pin){

        try{
            Customer thisCustomer = customerManager.getCustomerById(customerNumber);
            if (thisCustomer != null && thisCustomer.getPin().equals(customerManager.findPin(pin))) {
                return true;
            }
        }
        catch (Exception e){
            System.out.println("Can not authenticate.");
            return false;
        }

        return false;
    }

    Customer getCustomerById(int id){
        return customerManager.getCustomerById(id);
    }

    String getCustomerNameById(int id){
        return customerManager.getCustomerById(id).getFirstName() +" "+ customerManager.getCustomerById(id).getLastName();
    }

    void closeAccount(int customerID, Account.AccountType type){
        boolean result = false;
        ArrayList<Account> thisCustomersAccounts = getCustomerAccounts(customerManager.getCustomerById(customerID));
        for (Account a:thisCustomersAccounts) {
            if (type==a.getAccountType())
            result = accountManager.closeAccount(a.getAccountID());
            System.out.println(result);
        }
    }

    ArrayList<Account> getCustomerAccounts(Customer customer){
        return accountManager.getCustomerAccounts(customer.getCustomerID());

    }

    void printTransactions(){
        transactionManager.printTransactions();
    }

    void createNewTransaction(double amount, Transaction.TransactionType type, boolean success) {
         transactionManager.createNewTransaction(amount,type,success);
    }


}
