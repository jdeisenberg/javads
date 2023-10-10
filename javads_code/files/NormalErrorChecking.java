import java.util.Scanner;

public class NormalErrorChecking {

    public static void main(String[] args) {
        int[] data = {10, 66, 47, 11};
        int index = 0;
        int divisor = 0;
        boolean valid = false;
        
        Scanner input = new Scanner(System.in);
        
        do {
            System.out.print("Enter index 0-3: ");
            if (input.hasNextInt()) {
                index = input.nextInt();
                if (index < 0 || index > 3) {
                    System.out.println("Index not from 0-3.");
                } else {
                    valid = true;
                }
            } else {
                System.out.println("Please use digits.");
                input.nextLine(); // clear the input stream
            }
        } while (!valid);
        
        input.nextLine(); // clear input stream
        
        valid = false;
        do {
            System.out.print("Enter number to divide by: ");
            if (input.hasNextInt()) {
                divisor = input.nextInt();
                if (divisor == 0) {
                    System.out.println("You cannot divide by zero.");
                } else {
                    valid = true;
                }
            } else {
                System.out.println("Please use digits.");
                input.nextLine(); // clear input stream
            }
        } while (!valid);
        
        int result = data[index] / divisor;
        System.out.printf("quotient of %d and %d is %d\n",
            data[index], divisor, result);
    }
}
