package holloway.nate.atm;

import java.util.ArrayList;

/**
 * Created by nathanielholloway on 9/18/16.
 * This class is responsible for the intermediate logic of translating
 * what the Bank Engine wants to do with the Accounts.
 */
public class AccountManager {

    private boolean successful = false;
    private String operationCannotBePerformed = "This operation cannot be performed.";


    private ArrayList<Account> accounts;

    AccountManager(){
        accounts = new ArrayList<Account>();
    }

    public final Account getAccountById(int accountId){

        for (Account a: accounts) {
            if (accountId == a.getAccountID())
                return a;
        }
        return null;
    }

    public final ArrayList<Account> getCustomerAccounts(int customerId){
        ArrayList<Account> thisCustomersAccounts = new ArrayList<Account>();
        for (Account a: accounts) {
            if (customerId == a.getCustomerID()){
                thisCustomersAccounts.add(a);
            }
        }

        return thisCustomersAccounts;
    }

    public void addAccount(Account a){
        accounts.add(a);
    }

    public Account createNewAccount( int customerID, Account.AccountType type, double amount){
        Account newAccount = Account.createAccount(customerID, type, amount);
        addAccount(newAccount);
        return newAccount;
    }

    public boolean closeAccount(int accountId){
        Account  thisAccount = getAccountById(accountId);
        boolean successful =false;
        assert thisAccount != null;
        if(balanceInquiry(accountId) < 0 ){
            this.print(operationCannotBePerformed);
        }
        else {
            successful = true;
            thisAccount.setStatus(Account.AccountStatus.CLOSED);
        }

        return successful;
    }

    public double balanceInquiry(int accountId){
        Account thisAccount = getAccountById(accountId);
        double currentBalance;
        assert thisAccount != null;
        currentBalance = thisAccount.getAccountBalance();

        return currentBalance;
    }

    public boolean deposit(int accountId, double amount){
        Account thisAccount = getAccountById(accountId);
        assert thisAccount != null;
        return thisAccount.depositToAccount(amount);
    }

    public boolean withdrawal(int accountId, double amount){
        Account thisAccount = getAccountById(accountId);
        assert thisAccount != null;
        if(thisAccount.getAccountBalance() > amount){
            successful = true;
            thisAccount.withdrawalFromAccount(amount);
        } else{
            this.print(operationCannotBePerformed);
        }
        return successful;
    }

    public boolean transfer(Account accountToWithdrawalFrom, Account accountToDepositInto, double amount){
        successful = false;
        if (accountToWithdrawalFrom.getAccountBalance() > amount){
            successful = true;
            accountToWithdrawalFrom.withdrawalFromAccount(amount);
            accountToDepositInto.depositToAccount(amount);
        } else{
            this.print(operationCannotBePerformed);
        }
        return successful;
    }

    private void print(String msg){
        System.out.println(msg);
    }

    private void print(int msg){

        System.out.println(msg + "");
    }

    private void print(Double msg){

        System.out.println(msg + "");
    }


}
