import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.stream.Stream;

public class Testor {

	public static int test(int[] a, int v) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == v)
				return i;
			else return -1;
		}
		return -1;
	}

	public static LinkedList<Integer> process(LinkedList<Integer> theList, Predicate<Integer> p) {
		LinkedList<Integer> result = new LinkedList<Integer>();
		for (Integer i: theList) {
			if (p.test(i)) {
				result.add(i);
			}
		}
		return result;
	}
	
	
	public static LinkedList<Integer> map(LinkedList<Integer> theList, Function<Integer, Integer> f) {
		LinkedList<Integer> result = new LinkedList<Integer>();
		for (Integer i: theList) {
			result.add(f.apply(i));
		}
		return result;
	}
	
	public static void main(String[] args) {
		Predicate<Integer> isEven = (Integer n) -> {
			return n % 2 == 0;
		};
		
		Predicate<Integer> bigTest = new Predicate<Integer>() {
			public boolean test(Integer n) {
				return (n > 20);
			}
		};
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(10);
		list.add(66);
		list.add(47);
		list.add(11);
		LinkedList<Integer> list2 = process(list, isEven); 
		System.out.println(list2);
		
		list2 = process(list, bigTest);
		System.out.println(list2);
		
		Predicate<Integer> smallTest = bigTest.negate();
		list2 = process(list, smallTest);
		System.out.println(list2);
		
		Function<Integer, Integer> square = new Function<>() {
			public Integer apply(Integer n) {
				return n * n;
			}
		};
		
		list2 = map(list, square);
		System.out.println(list2);
		
		list2 = map(list, (n) -> n / 2);
		System.out.println(list2);
		
	}
}
