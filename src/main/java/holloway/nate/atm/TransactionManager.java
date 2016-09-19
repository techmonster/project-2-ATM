package holloway.nate.atm;

import java.util.ArrayList;

/**
 * Created by nathanielholloway on 9/18/16.
 */
public class TransactionManager {

    private ArrayList<Transaction> transactions;



    public TransactionManager(){
        transactions = new ArrayList<Transaction>();
    }
    public final void printTransactions(){

            for (Transaction t: transactions) {
                System.out.println("Transaction ID: "+t.getTransactionID()+
                        "Transaction Type: "+t.getTransactionType()+
                        "Transaction Date: "+t.getTransactionDate()+
                        "Transaction Amount: "+t.getTransactionAmount()+
                        "Transaction Result: "+(t.isSuccess() ? "Approved" : "Denied"));
            }

    }

    public void addTransaction(Transaction t){transactions.add(t);}

    public Transaction createNewTransaction(double amount, Transaction.TransactionType type, boolean success){
        Transaction newTransaction = Transaction.createTransaction(amount, type, success);
        addTransaction(newTransaction);
        return newTransaction;
    }



}
