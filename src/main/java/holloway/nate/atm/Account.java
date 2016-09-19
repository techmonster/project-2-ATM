package holloway.nate.atm;

/**
 * Created by nathanielholloway on 9/18/16.
 * This class is responsible for holding the Account information.
 */
public class Account {

    private int accountID = 100;
    private double accountBalance;
    public enum AccountType{CHECKING, SAVINGS, INVESTMENT}
    private AccountType accountType;
    public enum AccountStatus{OPEN, CLOSED, OFAC}
    private AccountStatus accountStatus;
    private boolean success = false;
    private final int customerID;

    private Account(int customerID, AccountType type, double amount){
        accountID = ++accountID;
        accountType = type;
        accountStatus = AccountStatus.OPEN;
        accountBalance = amount;
        this.customerID = customerID;
    }


    public final static Account createAccount(int customerID, AccountType type, double amount){
        return new Account(customerID, type, amount);
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public int getAccountID() {
        return accountID;
    }
    public int getCustomerID() {
        return customerID;
    }

    public boolean depositToAccount(double amount){
        accountBalance += amount;
        success = true;
        return success;
    }
    public boolean withdrawalFromAccount(double amount){
        accountBalance -= amount;
        return success;
    }
    public double getAccountBalance() {
        return accountBalance;
    }
    public void setStatus(AccountStatus status){
        accountStatus = status;
    }
}
