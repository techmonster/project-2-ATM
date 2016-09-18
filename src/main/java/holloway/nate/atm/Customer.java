package holloway.nate.atm;

/**
 * Created by nathanielholloway on 9/17/16.
 * This is the Customer class.
 * This class is responsible for holding customer information.
 */


public class Customer {

    private static int startingId = 100000;
    private int customerID;
    private String firstName;
    private String lastName;
    private String userName;
    private String pin;

    private Customer(String firstName, String lastName, String pin){
        this.firstName = firstName;
        this.lastName = lastName;
        this.pin = pin;
        customerID = ++startingId;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPin() {
        return pin;
    }

    public final static Customer createCustomer(String firstName, String lastName, String pin){
        return new Customer( firstName, lastName, pin);
    }


}
