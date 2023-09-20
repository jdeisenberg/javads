import java.util.Arrays;

public class MergeSortExample {

    public static void printLeadingBlanks(int level) {
        System.out.printf("%" + (3 * (level + 1)) + "s", "");
    }
    
    public static void mergeSort(int[] list, int level) {
        printLeadingBlanks(level);
        System.out.println("Sorting " + Arrays.toString(list));
        
        if (list.length > 1) {
            int middle = list.length / 2;
            int[] leftHalf = Arrays.copyOfRange(list, 0, middle);
            int[] rightHalf = Arrays.copyOfRange(list, middle, list.length);
            
            mergeSort(leftHalf, level + 1);
            mergeSort(rightHalf, level + 1);
            
            int i = 0; // index into left half
            int j = 0; // index into right half
            int resultIndex = 0;
            
            while (i < leftHalf.length && j < rightHalf.length) {
                if (leftHalf[i] <= rightHalf[j]) {
                    list[resultIndex] = leftHalf[i];
                    i = i + 1;
                } else {
                    list[resultIndex] = rightHalf[j];
                    j = j + 1;
                }
                resultIndex = resultIndex + 1;
            }
            
            // run out the remaining elements
            while (i < leftHalf.length) {
                list[resultIndex] = leftHalf[i];
                i = i + 1;
                resultIndex = resultIndex + 1;
            }
            
            while (j < rightHalf.length) {
                list[resultIndex] = rightHalf[j];
                j = j + 1;
                resultIndex = resultIndex + 1;
            }
            
            printLeadingBlanks(level);
            System.out.println("Merged into: " + Arrays.toString(list));
        }
    }
    
    public static void main(String[] args) {
        int[] testList = {54, 26, 93, 17, 77, 31, 44, 55, 20};
        System.out.println("Start point:  " + Arrays.toString(testList));
        System.out.println();
        
        mergeSort(testList, 0);
        
        System.out.println();
        System.out.println("Final result: " + Arrays.toString(testList));
    }
}
