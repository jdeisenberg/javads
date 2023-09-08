import java.util.Scanner;

class SumUntilNegative {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        double sum = 0.0;
        
        System.out.print("Enter a number, or zero to quit: ");
        double n = input.nextDouble();
        while (n != 0) {
            sum = sum + n;
            System.out.print("Enter another number, or zero to quit: ");
            n = input.nextDouble();
        }
        
        System.out.printf("The sum is %.3f%n", sum);
    }
}
