import java.util.Arrays;

public class ShortBubbleExample {
    public static void bubbleSortShort(int[] list) {
        for (int i = list.length - 1; i > 0; i--) {
            boolean exchanges = false;
            System.out.printf("Scanning from 0 to %d%n", i);
            for (int j = 0; j < i; j++) {
                System.out.printf("   Compare %d and %d", list[j],
                    list[j + 1]);
                if (list[j] > list[j + 1]) {
                    System.out.printf(" -- must swap");
                    int temporary = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temporary;
                    exchanges = true;
                }
                System.out.println();
            }
            System.out.println(Arrays.toString(list));
            System.out.println();
            if (!exchanges) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] testList = {20, 30, 40, 90, 50, 60, 70, 80, 100, 110};
        System.out.println("Start point: " + Arrays.toString(testList));
        bubbleSortShort(testList);
        System.out.println("Final result: " + Arrays.toString(testList));
    }
}
