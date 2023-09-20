import java.util.Arrays;

public class BubbleSortExample {

    public static void bubbleSort(int[] list) {
        for (int i = list.length - 1; i > 0; i--) {
            System.out.printf("Scanning from 0 to %d%n", i);
            for (int j = 0; j < i; j++) {
                System.out.printf("   Compare %d and %d", list[j],
                    list[j + 1]);
                if (list[j] > list[j + 1]) {
                    System.out.printf(" -- must swap");
                    int temporary = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temporary;
                }
                System.out.println();
            }
            System.out.println(Arrays.toString(list));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] testList = {54, 26, 93, 17, 77, 31, 44, 55, 20};
        System.out.println("Start point:  " + Arrays.toString(testList));
        bubbleSort(testList);
        System.out.println("Final result: " + Arrays.toString(testList));
    }
}
