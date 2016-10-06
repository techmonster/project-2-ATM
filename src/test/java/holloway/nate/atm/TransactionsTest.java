package holloway.nate.atm;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nathanielholloway on 9/18/16.
 * This class was created to test the Transaction class.
 */
public class TransactionsTest {

    @Test
    public void createTransactionsTest(){
        Transaction firstTransaction = Transaction.createTransaction(250, Transaction.TransactionType.DEPOSIT,true);
        Assert.assertNotNull(firstTransaction);
    }


}
