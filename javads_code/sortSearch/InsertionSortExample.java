import java.util.Arrays;

public class InsertionSortExample {

    public static void insertionSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int value = list[i];
            int position = i;

            while (position > 0 && list[position - 1] > value) {
                list[position] = list[position - 1];
                position = position - 1;
            }
            list[position] = value;
        }
    }
    
    public static void main(String[] args) {
        int[] testList = {54, 26, 93, 17, 77, 31, 44, 55, 20};
        System.out.println("Start point:  " + Arrays.toString(testList));
        insertionSort(testList);
        System.out.println("Final result: " + Arrays.toString(testList));
    }
}
