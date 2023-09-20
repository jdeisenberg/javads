import java.util.Arrays;

public class SelectionSortExample {

    public static void selectionSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int item = list[i];
            int minIndex = list.length - 1;
            
            // find index of smallest item in range
            for (int j = i; j < list.length; j++) {
                if (list[j] < list[minIndex]) {
                    minIndex = j;
                }
            }
            
            // if it's not this item, swap them
            if (minIndex != i) {
                int temporary = list[i];
                list[i] = list[minIndex];
                list[minIndex] = temporary;
            }
        }
    }

    public static void main(String[] args) {
        int[] testList = {54, 26, 93, 17, 77, 31, 44, 55, 20};
        System.out.println("Start point:  " + Arrays.toString(testList));
        selectionSort(testList);
        System.out.println("Final result: " + Arrays.toString(testList));
    }
}
