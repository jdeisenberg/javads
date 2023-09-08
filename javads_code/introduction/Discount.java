import java.util.Scanner;

class Discount {

    public static void main(String[] args) {
        final double DISCOUNT_RATE = 0.0725;
        
        Scanner input = new Scanner(System.in);

        System.out.print("Enter price: $");
        double price = input.nextDouble();

        double newPrice = price * (1.0 - DISCOUNT_RATE);
        System.out.println("Your new price is $" + newPrice + ".");
    }
}
