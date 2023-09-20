public class BinarySearchExample {
    
    public static boolean binarySearch(int[] list, int item) {
        int first = 0;
        int last = list.length - 1;
        while (first <= last) {
            int midpoint = (first + last) / 2;
            if (list[midpoint] == item) {
                return true;
            } else if (list[midpoint] < item) {
                last = midpoint - 1;
            } else {
                first = midpoint + 1;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[] testList = {0, 1, 2, 8, 13, 17, 19, 32, 42};
        
        System.out.println("Binary search for 3 returns " + 
            binarySearch(testList, 3));
        System.out.println("Binary search for 13 returns " +
            binarySearch(testList, 13));
    }
}
