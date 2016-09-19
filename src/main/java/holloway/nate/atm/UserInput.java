package holloway.nate.atm;

import java.util.Scanner;

/**
 * Created by nathanielholloway on 9/18/16.
 * This class holds pre-defined methods for handling user input.
 */
public class UserInput {
    Scanner scanner;

    public int promptInt(){
        return scanner.nextInt();
    }
    public double promptDouble(){
        return scanner.nextDouble();
    }

    public String prompt(){
        return scanner.next();
    }


}
