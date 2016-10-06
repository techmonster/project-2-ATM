package holloway.nate.atm;

/**
 * Created by nathanielholloway on 9/17/16.
 * This is the Customer class.
 * This class is responsible for holding customer information.
 */


final class Customer {

    private static int startingId = 100000;
    private int customerID;
    private String firstName;
    private String lastName;
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

    String getFirstName() {
        return firstName;
    }

    String getLastName() {
        return lastName;
    }

    String getPin() {
        return pin;
    }

    final static Customer createCustomer(String firstName, String lastName, String pin){
        return new Customer( firstName, lastName, pin);
    }


}
