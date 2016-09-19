package holloway.nate.atm;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nathanielholloway on 9/18/16.
 */
public class TransactionsTest {

    @Test
    public void createTransactionsTest(){
        Transaction firstTransaction = Transaction.createTransaction(250, Transaction.TransactionType.DEPOSIT,true);
        Assert.assertNotNull(firstTransaction);
    }

    @Test
    public void printTransactionTest(){
        Transaction firstTransaction = Transaction.createTransaction(250, Transaction.TransactionType.DEPOSIT,true);

    }
}
