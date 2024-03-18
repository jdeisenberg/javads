import java.util.ArrayList;
import java.util.Arrays;


public class KeepItems {

	public static ArrayList<Integer> keepEven(ArrayList<Integer> data) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for (Integer item: data) {
			if (item % 2 == 0) {
				result.add(item);
			}
		}
		return result;
	}

	public static ArrayList<Integer> keepNegative(ArrayList<Integer> data) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for (Integer item: data) {
			if (item < 0) {
				result.add(item);
			}
		}
		return result;
	}

	public static ArrayList<Integer> keepTwoDigit(ArrayList<Integer> data) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for (Integer item: data) {
			if (Math.abs(item) > 9 && Math.abs(item) < 100) {
				result.add(item);
			}
		}
		return result;
	}
			
	public static void main(String[] args) {
		Integer[] data = {10, 47, -311, 66, 254, -99, 140};
		ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(data));
		
		ArrayList<Integer> evens = keepEven(numbers);
		System.out.println("Even elements: " + evens);
		
		ArrayList<Integer> negative = keepNegative(numbers);
		System.out.println("Negative elements: " + negative);
		
		ArrayList<Integer> twoDigit = keepTwoDigit(numbers);
		System.out.println("Two-digit numbers: " + twoDigit);
	}
}
