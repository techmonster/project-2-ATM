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

    private Account(AccountType type, double amount){
        accountID = ++accountID;
        accountType = type;
        accountStatus = AccountStatus.OPEN;
        accountBalance = amount;
    }


    public final static Account createAccount(AccountType type, double amount){
        return new Account(type, amount);
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

    public boolean addToAccountBalance(double amount){
        accountBalance += amount;
        return success;
    }
    public boolean withdrawlFromAccountBalance(double amount){
        accountBalance -= amount;
        return success;
    }
    public double getAccountBalance() {
        return accountBalance;
    }
}
