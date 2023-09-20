public class OrderedSequentialSearchExample {
    
    public static boolean orderedSequentialSearch(int[] list, int item) {
        int index = 0;
        while (index < list.length) {
            if (list[index] == item) {
                return true;
            }
            if (list[index] > item) {
                return false;
            }
            index = index + 1;
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[] testList = {0, 1, 2, 8, 13, 17, 19, 32, 42};
        
        System.out.println("Search for 3 returns " + 
            orderedSequentialSearch(testList, 3));
        System.out.println("Search for 13 returns " +
            orderedSequentialSearch(testList, 13));
    }
}
