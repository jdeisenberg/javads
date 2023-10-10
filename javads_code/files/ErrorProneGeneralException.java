import java.util.Scanner;

public class ErrorProneGeneralException {

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
        catch (Exception ex) {
            System.out.println("An error occurred:");
            System.out.println(ex.toString());
        }
    }
}
