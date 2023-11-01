import java.util.Arrays;

public class ShellSortExample {

    public static void shellSort(int[] list) {
        int sublistCount = list.length / 2;
        while (sublistCount > 0) {
            for (int startPos = 0; startPos < sublistCount; startPos++) {
                gapInsertionSort(list, startPos, sublistCount);
            }
            System.out.printf("After increments of size %d, the list is %s%n",
                sublistCount, Arrays.toString(list));
            sublistCount = sublistCount / 2;
        }
    }
    
    private static void gapInsertionSort(int[] list, int start, int gap) {
        for (int i = start + gap; i < list.length; i = i + gap) {
            int value = list[i];
            int position = i;
            while (position >= gap && list[position - gap] > value) {
                list[position] = list[position - gap];
                position = position - gap;
            }
            list[position] = value;
        }
    }
    
    public static void main(String[] args) {
        int[] testList = {54, 26, 93, 17, 77, 31, 44, 55, 20};
        System.out.println("Start point:  " + Arrays.toString(testList));
        shellSort(testList);
        System.out.println("Final result: " + Arrays.toString(testList));
    }
}
