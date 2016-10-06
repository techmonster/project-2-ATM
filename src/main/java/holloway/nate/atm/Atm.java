package holloway.nate.atm;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by nathanielholloway on 9/17/16.
 * This class will is a model of an ATM interface.
 */
class Atm {
    private BankEngine bankEngine;
    private Scanner scanner;
    private int customerId;
    private ArrayList<Account> currentAccounts;
    private boolean quit = false;
    private boolean success = false;

    Atm(){
        bankEngine = new BankEngine();
        scanner = new Scanner(System.in);
    }

    void start(){
        while(!quit) {
            Menu.printGreetingMenu();
            int intAnswer ;
            intAnswer = scanner.nextInt();
            switchInitialResponse(intAnswer);
        }
    }

    private void switchInitialResponse(int initAnswer){
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

    private void createAnAccount(){
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

    private void logIn(){
        String stringAnswer;
        int count = 0;
        boolean noSuccess = true;
        while (noSuccess && count < 3) {
            Menu.printEnterCustomerIDNumberPrompt();
            customerId = scanner.nextInt();
            Menu.printEnterPINPrompt();
            stringAnswer = scanner.next();

            if (bankEngine.authenticate(customerId, stringAnswer)) {
                noSuccess = false;
                System.out.printf("WELCOME BACK %s %s%n", bankEngine.getCustomerNameById(customerId), bankEngine.getCustomerNameById(customerId));
                displayOptionMenu();
            } else {
                Menu.cannotBeAuthenticatedMessage();
            }
            count++;
        }
    }
    private void displayOptionMenu(){
        displayCurrentAccounts();
        System.out.println();
        Menu.accountOptionMenu();
        int accountOptionAnswer = scanner.nextInt();
        evaluateOptions(accountOptionAnswer);       //evaluate options method call
    }
    
    private void displayCurrentAccounts(){
        currentAccounts = bankEngine.getCustomerAccounts(bankEngine.getCustomerById(customerId));
        System.out.println("You currently have these types of accounts: ");
        for (Account a:currentAccounts) {
            System.out.println(a.getAccountType().toString());
        }
    }

    private void evaluateOptions(int i) {
        Account one = null;
        Account two = null;
        Account.AccountType thisType;
        double amount;


        switch (i) {
            case 1: //CREATE NEW ACCOUNT
                Menu.printEnterTypeOfAccount();
                thisType = switchType(scanner.nextInt());
                Menu.printEnterAmount();
                amount = scanner.nextDouble();
                Account thisAccount = bankEngine.createNewAccount(customerId,thisType, amount);
                if (thisAccount!=null){
                    success = true;
                }
                bankEngine.createNewTransaction(amount, Transaction.TransactionType.DEPOSIT,success);
                success = false;
                break;
            case 2: //WITHDRAWAL
                Menu.printEnterTypeOfAccount();
                thisType = switchType(scanner.nextInt());
                Menu.printEnterAmount();
                amount = scanner.nextDouble();
                for (Account a:currentAccounts) {
                    if (a.getAccountType() == thisType) {
                        success = bankEngine.withdrawal(a.getAccountID(), amount);
                        bankEngine.createNewTransaction(-amount, Transaction.TransactionType.WITHDRAWAL, success);
                        break;
                    }
                }
                break;
            case 3: //DEPOSIT
                Menu.printEnterTypeOfAccount();
                thisType = switchType(scanner.nextInt());
                Menu.printEnterAmount();
                amount = scanner.nextDouble();
                for (Account a:currentAccounts) {
                    if (a.getAccountType() == thisType) {
                        success = bankEngine.deposit(a.getAccountID(), amount);
                        break;
                    }
                }
                bankEngine.createNewTransaction(amount, Transaction.TransactionType.DEPOSIT,success);
                break;
            case 4: //TRANSFER
                Menu.printEnterTypeOfAccount();
                thisType = switchType(scanner.nextInt());

                Menu.printEnterTypeOfAccount();
                Account.AccountType thisType2 = switchType(scanner.nextInt());

                Menu.printEnterAmount();
                amount = scanner.nextDouble();

                for (Account a:currentAccounts) {
                    if (a.getAccountType() == thisType) {
                        one = a;
                    }
                    if (a.getAccountType() == thisType2){
                        two = a;
                    }
                }
                success = bankEngine.transfer(one, two, amount);
                bankEngine.createNewTransaction(amount, Transaction.TransactionType.DEPOSIT,success);
                bankEngine.createNewTransaction(-amount, Transaction.TransactionType.WITHDRAWAL,success);

                break;
            case 5: //CHECK BALANCE
                Menu.printEnterTypeOfAccount();
                thisType = switchType(scanner.nextInt());
                for (Account a:currentAccounts) {
                    if (a.getAccountType() == thisType) {
                        System.out.println(bankEngine.checkBalance(a));
                        break;
                    }
                }
                break;
            case 6: //PRINT TRANSACTIONS
                bankEngine.printTransactions();
                break;
            case 7: //CLOSE ACCOUNT
                Menu.printEnterTypeOfAccount();
                thisType = switchType(scanner.nextInt());
                bankEngine.closeAccount(customerId,thisType);
                break;
            case 8: //QUIT
                quit = true;
                System.out.println("Have a nice day!");
                break;
        }
    }   
        private Account.AccountType switchType(int selection){
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
