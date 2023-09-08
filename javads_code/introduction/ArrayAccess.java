import java.util.Scanner;

class ArrayAccess {

    public static void main(String[] args) {
        int[] data = {10, 66, 47, 11, 505, 217};
        
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an index: ");
        int index = input.nextInt();

        int value = data[index];
        System.out.printf("The element is %d%n", value);
    }
}
