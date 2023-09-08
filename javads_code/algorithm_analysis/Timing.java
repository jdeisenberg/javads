import java.util.Scanner;

public class Timing {
    public static long sumOfN(long n) {
        /*long theSum = 0;
        for (int i = 1; i <= n; i++) {
            theSum = theSum + i;
        }
        return theSum;
        */
        
        long theSum = n * (n + 1) / 2;
        return theSum;
        
    }

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.print("Find sum from 1 to n: ");
        long n = input.nextInt();
        
        for (int trial = 0; trial < 25; trial++) {
            long startTime = System.nanoTime();
            long result = sumOfN(n);
            
            double elapsed = (System.nanoTime() - startTime) / 1.0E9;
            System.out.printf("Trial %d: Sum %d: time %.6f sec.%n",
                trial, result, elapsed);
        }
    }
}
