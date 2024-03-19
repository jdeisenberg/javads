import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class FunctionalKeepItems {
    public static <T> ArrayList<T> keep(ArrayList<T> data,
      Predicate<T> p) {
          
        ArrayList<T> result = new ArrayList<T>();

        for (T item: data) {
            if (p.test(item)) {
                result.add(item);
            }
        }
        return result;
    }
    
	public static void main(String[] args) {
		Integer[] data = {10, 47, -311, 66, 254, -99, 140};
		ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(data));
		
		ArrayList<Integer> evens = keep(numbers,
			(Integer n) -> {
				return n % 2 == 0;
			});
		System.out.println("Even elements: " + evens);
		
		Predicate<Integer> isNegative = (Integer n) -> {
			return (n < 0);
		};
		ArrayList<Integer> negatives = keep(numbers, isNegative);
		System.out.println("Negative elements: " + negatives);
		
		Predicate<Integer> isTwoDigits = (Integer n) -> {
			return (Math.abs(n) > 9 && Math.abs(n) < 100);
		};
		ArrayList<Integer> twoDigits = keep(numbers, isTwoDigits);
		System.out.println("Two-digit elements: " + twoDigits);

		
	}
}
