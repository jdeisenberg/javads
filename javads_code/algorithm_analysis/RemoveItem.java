import java.util.Scanner;
import java.util.ArrayList;

public class RemoveItem {

    
    public static double timeRemove(int len, boolean removeFirst) {
        final int N_TRIALS = 25;
        final int N_IGNORE = 20; // let system stabilize
        long totalTime = 0;
        
        ArrayList<Integer> list = new ArrayList<>(len);
        
        for (int trial = 0; trial < N_TRIALS; trial++) {
            int start = list.size();
            for (int i = start; i < len; i++) {
                list.add(i);
            }
            System.gc();
           
            long startTime = System.nanoTime();
            for (int count = 0; count < 1000; count++) {
                if (removeFirst) {
                    list.remove(0);
                } else {
                    list.remove(list.size() - 1);
                }
            }

            if (trial >= N_IGNORE) {
               totalTime = totalTime + (System.nanoTime() - startTime); 
            }
            
        }
        return (totalTime / (N_TRIALS - N_IGNORE)) / 1.0E9;
    }
            

    public static void main(String[] args) {
        System.out.println("2,000,000 items");
        System.out.printf("Remove first time: %.7f%n",
            timeRemove(2_000_000, true));
        System.out.printf("Remove last time: %.7f%n",
            timeRemove(2_000_000, false));
        System.out.println();

        System.out.println("1,000,000 items");
        System.out.printf("Remove first time: %.7f%n",
            timeRemove(1_000_000, true));
        System.out.printf("Remove last time: %.7f%n",
            timeRemove(1_000_000, false));
        System.out.println();
        
        System.out.println("100,000 items");
        System.out.printf("Remove first time: %.7f%n",
            timeRemove(100_000, true));
        System.out.printf("Remove last time: %.7f%n",
            timeRemove(100_000, false));
        System.out.println();
    }
}
