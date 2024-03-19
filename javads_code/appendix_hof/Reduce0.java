import java.util.ArrayList;
import java.util.Arrays;


public class Reduce0 {

    public static Integer reduceSum(ArrayList<Integer> data, Integer start) {
        Integer result = start;
        
        for (Integer item: data) {
            result = result + item;
        }
        return result;
    }

    public static Integer reduceProduct(ArrayList<Integer> data, Integer start) {
        Integer result = start;
        
        for (Integer item: data) {
            result = result * item;
        }
        return result;
    }
            
    public static void main(String[] args) {
        Integer[] data = {1, 5, 2, 3, 4};
        ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(data));
        
        Integer sum = reduceSum(numbers, 0);
        System.out.println("sum: " + sum);
        
        Integer product = reduceProduct(numbers, 1);
        System.out.println("product: " + product);
    }
}
