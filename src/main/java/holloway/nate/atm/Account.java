package holloway.nate.atm;

/**
 * Created by nathanielholloway on 9/18/16.
 * This class is responsible for holding the Account information.
 */
final class Account {

    private int accountID;
    private static int startingID = 100;
    private double accountBalance;
    enum AccountType{CHECKING, SAVINGS, INVESTMENT}
    private AccountType accountType;
    enum AccountStatus{OPEN, CLOSED, OFAC}
    private AccountStatus accountStatus;
    private final int customerID;

    private Account(int customerID, AccountType type, double amount){
        accountID = ++startingID;
        accountType = type;
        accountStatus = AccountStatus.OPEN;
        accountBalance = amount;
        this.customerID = customerID;
    }


     final static Account createAccount(int customerID, AccountType type, double amount){
        return new Account(customerID, type, amount);
    }

    AccountType getAccountType() {
        return accountType;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    int getAccountID() {
        return accountID;
    }
    int getCustomerID() {
        return customerID;
    }

    boolean depositToAccount(double amount){
        accountBalance += amount;
        return true;
    }
    boolean withdrawalFromAccount(double amount){
        accountBalance -= amount;
        return true;
    }
    double getAccountBalance() {
        return accountBalance;
    }
    void setStatus(AccountStatus status){
        accountStatus = status;
    }
}
