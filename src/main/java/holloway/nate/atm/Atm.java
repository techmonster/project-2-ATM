package holloway.nate.atm;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by nathanielholloway on 9/17/16.
 * This class will is a model of an ATM interface.
 */
public class Atm {
    BankEngine bankEngine;
    Scanner scanner;
    int intAnswer ;
    double doubleAnswer;
    String stringAnswer;
    int customerId;
    ArrayList<Account> currentAccounts;
    boolean quit = false;

    public Atm(){
        bankEngine = new BankEngine();
        scanner = new Scanner(System.in);
    }

    public void start(){
        while(!quit) {
            Menu.printGreetingMenu();
            intAnswer = scanner.nextInt();
            switchInitialResponse(intAnswer);
        }
    }

    public void switchInitialResponse(int initAnswer){
        switch (initAnswer){
            case 1:
                createAnAccount();
                break;
            case 2:
                logIn();
                break;
            case 3:
                quit = true;
                break;
            default:
                System.out.println("Invalid entry. Try again.");
            }
    }

    public void createAnAccount(){
        Menu.printFirstNamePrompt();
        String firstName = scanner.next();
        Menu.printLastNamePrompt();
        String lastName = scanner.next();
        Menu.printEnterPINPrompt();
        String pin = scanner.next();
        Customer thisCustomer = bankEngine.createNewCustomer(firstName,lastName,pin);
        System.out.println("Your Customer ID is: "+thisCustomer.getCustomerID());
        logIn();
    }

    public void logIn(){
        int count = 0;
        boolean noSuccess = true;
        while (noSuccess && count < 3) {
            Menu.printEnterCustomerIDNumberPrompt();
            customerId = scanner.nextInt();
            Menu.printEnterPINPrompt();
            stringAnswer = scanner.next();

            if (bankEngine.authenticate(customerId, stringAnswer)) {
                noSuccess = false;
                displayOptionMenu();
            } else {
                Menu.cannotBeAuthenticatedMessage();
            }
            count++;
        }
    }
    public void displayOptionMenu(){
        displayCurrentAccounts();
        System.out.println();
        Menu.accountOptionMenu();
        evaluateOptions(scanner.nextInt());
    }
    
    public void displayCurrentAccounts(){
        currentAccounts = bankEngine.getCustomerAccounts(bankEngine.customerManager.getCustomerById(customerId));
        System.out.println("You currently have these types of accounts: ");
        for (Account a:currentAccounts) {
            System.out.println(a.getAccountType().toString());
        }
    }

    public void evaluateOptions(int i) {
        Account one = null;
        Account two = null;
        Menu.printEnterAmount();
        double amount = scanner.nextDouble();
        switch (i) {
            case 1:
                Menu.printEnterTypeOfAccount();
                Account.AccountType thisType = switchType(scanner.nextInt());
                bankEngine.createNewAccount(customerId,thisType, amount);
                break;
            case 2:
                Menu.printEnterTypeOfAccount();
                thisType = switchType(scanner.nextInt());
                amount = scanner.nextDouble();
                for (Account a:currentAccounts) {
                    if (a.getAccountType() == thisType) {
                        bankEngine.withdrawal(a.getAccountID(), amount);
                        break;
                    }
                }
                break;
            case 3:
                Menu.printEnterTypeOfAccount();
                thisType = switchType(scanner.nextInt());
                scanner.nextDouble();
                for (Account a:currentAccounts) {
                    if (a.getAccountType() == thisType) {
                        bankEngine.deposit(a.getAccountID(), amount);
                        break;
                    }
                }
                break;
            case 4:
                Menu.printEnterTypeOfAccount();
                thisType = switchType(scanner.nextInt());
                Account.AccountType thisType2 = switchType(scanner.nextInt());
                for (Account a:currentAccounts) {
                if (a.getAccountType() == thisType) {
                    one = a;
                    break;
                }
                if (a.getAccountType() == thisType2){
                    two = a;
                    break;
                }
                }
                bankEngine.transfer(one, two, amount);
                break;
            case 5:
                Menu.printEnterTypeOfAccount();
                thisType = switchType(scanner.nextInt());
                for (Account a:currentAccounts) {
                    if (a.getAccountType() == thisType) {
                        bankEngine.checkBalance(a);
                        break;
                    }
                }
                break;
            case 6:
                bankEngine.transactionManager.printTransactions();
                break;
            case 7:
                Menu.printEnterTypeOfAccount();
                thisType = switchType(scanner.nextInt());
                for (Account a:currentAccounts) {
                    if (a.getAccountType() == thisType) {
                        bankEngine.accountManager.closeAccount(a.getAccountID());
                        break;
                    }
                }
                break;
            case 8:
                System.out.println("Have a nice day!");
                break;
        }
    }   
        public Account.AccountType switchType(int selection){
            int count = 0;
            Account.AccountType type = null;
            while(type == null && count < 3){
            switch(selection) {
                case 1:
                    type = Account.AccountType.CHECKING;
                    break;
                case 2:
                    type = Account.AccountType.SAVINGS;
                    break;
                case 3:
                    type = Account.AccountType.INVESTMENT;
                    break;
                default:
                    System.out.println("Not a valid selection");
                    count++;
            }
            }
                return type;
            }
}
