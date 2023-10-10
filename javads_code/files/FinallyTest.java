import java.util.Scanner;

public class FinallyTest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        try {
            int result = 17 / 0;
            System.out.printf("quotient of 17 and 5 is %d\n",
               result);
            return; // exits the main() method
        }
        catch (ArithmeticException ex) {
            System.out.println("You can't divide by zero.");
        }
        finally {
            System.out.println("In the finally clause.");
        }
        System.out.println("Does not print if return succeeds.");
    }
}
