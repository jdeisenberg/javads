import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiFunction;

public class StringJoiner {

    public static BiFunction<String, String, String> makeReducer(String delim) {
        return 
            (String result, String item) -> {
                if (result.equals("")) {
                    result = item;
                } else {
                    result = result + delim + item;
                }
                return result;
            };
    }
    
    public static <T, R> R reduce(ArrayList<T> data, R start,
        BiFunction<R, T, R> f) {
        R result = start;
        
        for (T item: data) {
            result = f.apply(result, item);
        }
        return result;
    }
            
    public static void main(String[] args) {
        String[] wordArr = {"cat", "moose", "giraffe", "dog"};
        
        ArrayList<String> words = new ArrayList<>(Arrays.asList(wordArr));
        
        BiFunction<String, String, String> joiner = makeReducer("--");
        String joined = reduce(words, "", joiner);
        System.out.println(joined);

    }
}
