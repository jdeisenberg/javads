import java.util.Arrays;

public class SumWithRecursion {
    public static int arraySum(int [] numArray) {
        if (numArray.length == 1) {
            return numArray[0];
        } else {
            return numArray[0] +
                arraySum(Arrays.copyOfRange(numArray, 1, numArray.length));
        }
    }

    public static void main(String[] args) {
        int[] data = {1, 3, 5, 7, 9};
        System.out.println(arraySum(data));
    }
}
