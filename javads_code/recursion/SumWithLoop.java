public class SumWithLoop {
    public static int arraySum(int [] numArray) {
        int theSum = 0;
        for (int number: numArray) {
            theSum = theSum + number;
        }
        return theSum;
    }

    public static void main(String[] args) {
        int[] data = {1, 3, 5, 7, 9};
        System.out.println(arraySum(data));
    }
}
