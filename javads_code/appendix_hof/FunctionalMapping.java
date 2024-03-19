import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;

public class FunctionalMapping {
    public static <T, R> ArrayList<R> map(ArrayList<T> data,
      Function<T, R> f) {

        ArrayList<R> result = new ArrayList<R>();

        for (T item: data) {
            result.add(f.apply(item));
        }
        return result;
    }
    
	public static void main(String[] args) {
		Integer[] data = {16, 144, 25, 2};
		ArrayList<Integer> numbers = new ArrayList<Integer>
		  (Arrays.asList(data));
		
		ArrayList<Double> roots = map(numbers,
			(Integer n) -> {
				return Math.sqrt(Math.abs(n));
			});
		System.out.println("Square roots: " + roots);
		
		String[] wordArr = {"Java", "C++", "Python", "COBOL"};
		ArrayList<String> words = new ArrayList<>(Arrays.asList(wordArr));
		
		Function<String, Integer> strLen = (String str) -> {
			return str.length();
		};
		ArrayList<Integer> lengths = map(words, strLen);
		System.out.println("Word lengths: " + lengths);
		
	}
}
