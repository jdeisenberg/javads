import java.util.Scanner;

public class ErrorProneMultipleExceptions {

    public static void main(String[] args) {
        int[] data = {10, 66, 47, 11};
        
        Scanner input = new Scanner(System.in);
        
        try {
            System.out.print("Enter index 0-3: ");
            int index = input.nextInt();
            
            System.out.print("Enter number to divide by: ");
            int divisor = input.nextInt();
            
            int result = data[index] / divisor;
            System.out.printf("quotient of %d and %d is %d\n",
                data[index], divisor, result);
        }
        catch (ArithmeticException ex) {
            System.out.println("Number to divide by cannot be zero.");
        }
        catch (NumberFormatException ex) {
            System.out.println("You must enter digits for numbers.");
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            System.out.printf("Index must be in range 0-%d\n", data.length);
        }
    }
}
