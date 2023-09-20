import java.util.Arrays;

public class QuickSortExample {

    public static void quickSort(int[] list) {
        quickSortHelper(list, 0, list.length - 1);
    }
    
    public static void quickSortHelper(int[] list, int first, int last) {
        if (first < last) {
            int split = partition(list, first, last);
            quickSortHelper(list, first, split - 1);
            quickSortHelper(list, split + 1, last);
        }
    }
    
    public static int partition(int [] list, int first, int last) {
        int pivotValue = list[first];
        int leftMark = first + 1;
        int rightMark = last;
        boolean done = false;
        
        while (!done) {
            while (leftMark <= rightMark && list[leftMark] <= pivotValue) {
                leftMark = leftMark + 1;
            }
            while (leftMark <= rightMark && list[rightMark] >= pivotValue) {
                rightMark = rightMark - 1;
            }
            
            if (rightMark < leftMark) {
                done = true;
            } else {
                int temporary = list[leftMark];
                list[leftMark] = list[rightMark];
                list[rightMark] = temporary;
            }
        }
        
        int temporary = list[first];
        list[first] = list[rightMark];
        list[rightMark] = temporary;
        
        return rightMark;
    }
 
    public static void main(String[] args) {
        int[] testList = {54, 26, 93, 17, 77, 31, 44, 55, 20};
        System.out.println("Start point:  " + Arrays.toString(testList));
        
        quickSort(testList);
        
        System.out.println("Final result: " + Arrays.toString(testList));
    }
}
