package holloway.nate.atm;

/**
 * Created by nathanielholloway on 9/18/16.
 * This class contains the ATM prompt menu.
 */
public class Menu {

    public static void printGreetingMenu(){
        System.out.println("WELCOME TO THE BANK OF NATE!\n1) NEW CUSTOMERS: CREATE AN ACCOUNT\n" +
                "2) EXISTING CUSTOMERS: LOG IN\n ");
    }

    //Create an account choice.
    public static void printFirstNamePrompt(){
        System.out.println("ENTER YOUR FIRST NAME: ");
    }

    //Create an account choice.
    public static void printLastNamePrompt(){
        System.out.println("ENTER YOUR LAST NAME: ");
    }
    //Create an account choice.
    //Log in choice
    public static void printEnterPINPrompt(){
        System.out.println("ENTER YOUR PIN: ");
    }

    public static void printEnterCustomerIDNumberPrompt(){
        System.out.println("ENTER YOUR CUSTOMER ID NUMBER: ");
    }

    public static void printEnterAmount(){
        System.out.println("Enter the amount: ");
    }

    public static void printEnterTypeOfAccount(){
        System.out.println("SELECT TYPE OF ACCOUNT\n 1) CHECKING 2) SAVINGS 3) INVESTING");
    }

    public static void accountOptionMenu(){
        System.out.println("What would you like to do?\n1) CREATE AN ACCOUNT" +
                "\n2) WITHDRAWAL\n3) DEPOSIT\n4) TRANSFER\n5) CHECK BALANCE\n6) PRINT TRANSACTIONS" +
                "\n7) CLOSE ACCOUNT\n8)EXIT");
    }

    public static void cannotBeAuthenticatedMessage(){
        System.out.println("The account could not be authenticated.\n RE-ENTER CUSTOMER ID AND PIN");
    }

}
