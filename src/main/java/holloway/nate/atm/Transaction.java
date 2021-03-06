package holloway.nate.atm;

import java.util.Date;

/**
 * Created by nathanielholloway on 9/18/16.
 * This class holds the data for the transactions class.
 */
public class Transaction {
    private static int transId = 1;
    private int transactionID;
    private double transactionAmount;
    public enum TransactionType{WITHDRAWAL, DEPOSIT, };
    private TransactionType transactionType;
    private Date transactionDate;
    private boolean success = false;

    private Transaction(double amount, TransactionType type, boolean success){
        transactionID = transId++;
        transactionAmount = amount;
        transactionDate = new Date();
        transactionType = type;
        this.success = success;
    }


    public int getTransactionID() {
        return transactionID;
    }
    public TransactionType getTransactionType() {
        return transactionType;
    }

    public boolean isSuccess() {
        return success;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }


    public final static Transaction createTransaction(double amount, TransactionType type, boolean success){
        Transaction thisTransaction = new Transaction(amount, type, success);
        return thisTransaction;
    }
}
