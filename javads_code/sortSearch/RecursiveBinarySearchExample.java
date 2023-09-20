import java.util.Arrays;

public class RecursiveBinarySearchExample {
    
    public static boolean binarySearchRecursive(int[] list, int item) {
        if (list.length == 0) {
            return false;
        }
        int midpoint = list.length / 2;
        if (list[midpoint] == item) {
            return true;
        } else if (item < list[midpoint]) {
            int[] leftHalf = Arrays.copyOfRange(list, 0, midpoint);
            return binarySearchRecursive(leftHalf, item);
        } else {
            int[] rightHalf = Arrays.copyOfRange(list, midpoint + 1,
                list.length);
            return binarySearchRecursive(rightHalf, item);
        }
    }
    
    public static void main(String[] args) {
        int[] testList = {0, 1, 2, 8, 13, 17, 19, 32, 42};
        
        System.out.println("Binary search for 3 returns " + 
            binarySearchRecursive(testList, 3));
        System.out.println("Binary search for 13 returns " +
            binarySearchRecursive(testList, 13));
    }
}
