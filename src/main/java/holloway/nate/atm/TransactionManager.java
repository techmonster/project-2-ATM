package holloway.nate.atm;

import java.util.ArrayList;

/**
 * Created by nathanielholloway on 9/18/16.
 * This class controls the access to the data of the Transactions class.
 */
public class TransactionManager {

    private ArrayList<Transaction> transactions;



    public TransactionManager(){
        transactions = new ArrayList<Transaction>();
    }

    public final void printTransactions(){

            for (Transaction t: transactions) {
                System.out.println("Transaction ID: "+t.getTransactionID()+
                        "\nTransaction Type: "+t.getTransactionType()+
                        "\nTransaction Date: "+t.getTransactionDate()+
                        "\nTransaction Amount: "+t.getTransactionAmount()+
                        "\nTransaction Result: "+(t.isSuccess() ? "Approved" : "Denied"));
            }

    }

    private void addTransaction(Transaction t){transactions.add(t);}

    public Transaction createNewTransaction(double amount, Transaction.TransactionType type, boolean success){
        Transaction newTransaction = Transaction.createTransaction(amount, type, success);
        addTransaction(newTransaction);
        return newTransaction;
    }



}
