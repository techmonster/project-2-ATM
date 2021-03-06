package holloway.nate.atm;

import java.util.ArrayList;

/**
 * Created by nathanielholloway on 9/17/16.
 * This is the Customer Manager class.
 * This class is responsible for communication with the customer class.
 * This class will create, store, and return customer objects.
 */
 class CustomerManager {
    private ArrayList<Customer> customers;

    CustomerManager(){
        customers = new ArrayList<Customer>();
    }


    final Customer getCustomerById(int id){

        for (Customer c: customers) {
            if (id == c.getCustomerID())
                return c;
        }
        return null;
    }

    String findPin(String pin){
        String success = "Failed to find pin.";
         for(Customer c: customers){
            if(c.getPin().equals(pin)){
                return c.getPin();
            }
        }
        return success;
    }

    private void addCustomer(Customer c){
        customers.add(c);
    }

    Customer createNewCustomer( String firstName, String lastName, String pin){
        Customer newCustomer = Customer.createCustomer(firstName, lastName, pin);
        addCustomer(newCustomer);
        return newCustomer;
    }
}
