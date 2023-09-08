import java.util.Scanner;

class ArrayAccessTryCatch {

    public static void main(String[] args) {
        int[] data = {10, 66, 47, 11, 505, 217};
        
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an index: ");
        int index = input.nextInt();

        try {
            int value = data[index];
            System.out.printf("The element is %d.%n", value);
        }
        catch (Exception ex) {
            System.out.printf("Index must be from 0 to %d.%n",
                data.length);
        }
    }
}
