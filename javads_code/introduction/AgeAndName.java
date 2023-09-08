import java.util.Scanner;

class AgeAndName {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = input.nextLine();
        
        System.out.print("Enter your age in years: ");
        int years = input.nextInt();

        int days = years * 365;
        System.out.printf("You are about %d days old, %s.\n",
            days, name);
    }
}
