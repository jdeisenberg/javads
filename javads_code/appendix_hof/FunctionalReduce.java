import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiFunction;

public class FunctionalReduce {

    public static <T, R> R reduce(ArrayList<T> data, R start,
        BiFunction<R, T, R> f) {
        R result = start;
        
        for (T item: data) {
            result = f.apply(result, item);
        }
        return result;
    }
            
    public static void main(String[] args) {
        Integer[] data = {1, 5, 2, 3, 4};
        ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(data));
        
        BiFunction<Integer, Integer, Integer> reduceSum =
          (Integer result, Integer n)  -> {
            result += n;
            return result;
        };

        BiFunction<Integer, Integer, Integer> reduceProduct =
          (Integer result, Integer n)  -> {
            result *= n;
            return result;
        };
        
        Integer sum = reduce(numbers, 0, reduceSum);
        System.out.println("sum: " + sum);
        
        Integer product = reduce(numbers, 1, reduceProduct);
        System.out.println("product: " + product);

    }
}
