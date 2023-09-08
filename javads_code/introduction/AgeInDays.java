import java.util.Scanner;

class AgeInDays {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your age in years: ");
        int years = input.nextInt();

        int days = years * 365;
        System.out.println("Your age in days is approximately "
            + days + ".");
    }
}
