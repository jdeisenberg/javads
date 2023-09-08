import java.util.Scanner;

class InputValidation {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a non-negative integer: ");
        int n = input.nextInt();
        while (n < 0) {
            System.out.print("Please enter a non-negative integer: ");
            n = input.nextInt();
        }
        
        System.out.printf("The square root of %d is %.3f.%n",
            n, Math.sqrt(n));
    }
}
