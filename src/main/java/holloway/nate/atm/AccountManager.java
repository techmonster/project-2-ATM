package holloway.nate.atm;

import java.util.ArrayList;

/**
 * Created by nathanielholloway on 9/18/16.
 */
public class AccountManager {

    private boolean successful = false;

    private ArrayList<Account> accounts;

    private AccountManager(){
        accounts = new ArrayList<Account>();
    }

    public final Account getAccountById(int id){

        for (Account a: accounts) {
            if (id == a.getAccountID())
                return a;
        }
        return null;
    }

    public void addAccount(Account a){
        accounts.add(a);
    }

    public Account createNewAccount( Account.AccountType type, double amount){
        Account newAccount = Account.createAccount(type, amount);
        addAccount(newAccount);
        return newAccount;
    }

    public boolean closeAccount(Account account){
        return successful;
    }

}
