import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ListVsMap {
    
    public static void main(String[] args) {

        System.out.println("size      list       map");
        for (int size = 10_000; size < 1_000_001; size += 20_000) {
            ArrayList<Integer> list = new ArrayList<>(size);
            HashMap<Integer, Integer> map = new HashMap<>();
            
            for (int key = 0; key < size; key++) {
                list.add(key);
                map.put(key, key); // key and value are the same
            }
            System.gc();
            Random generator = new Random();
            
            long startListTime = System.nanoTime();
            for (int i = 0; i < 1000; i++) {
                int lookFor = generator.nextInt(size);
                boolean found = list.contains(lookFor);
            }
            long elapsedListTime = System.nanoTime() - startListTime;
            
            long startMapTime = System.nanoTime();
            for (int i = 0; i < 1000; i++) {
                Integer lookFor = generator.nextInt(size);
                boolean found = map.containsKey(lookFor);
            }
            long elapsedMapTime = System.nanoTime() - startMapTime;
            System.out.printf("%8d %9.7f %9.7f%n",
                size, elapsedListTime / 1.0E9, elapsedMapTime / 1.0E9);
        }
    }
}
 
