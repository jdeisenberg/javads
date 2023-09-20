public class SequentialSearchExample {
    
    public static boolean sequentialSearch(int[] list, int item) {
        int index = 0;
        while (index < list.length) {
            if (list[index] == item) {
                return true;
            }
            index = index + 1;
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[] testList = {1, 2, 32, 8, 17, 19, 42, 13, 0};
        
        System.out.println("Search for 3 returns " + 
            sequentialSearch(testList, 3));
        System.out.println("Search for 13 returns " +
            sequentialSearch(testList, 13));
    }
}
