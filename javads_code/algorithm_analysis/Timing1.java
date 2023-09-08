

public class Timing {
    public static int sumOfN(int n) {
        int theSum = 0;
        for (int i = 1; i <= n; i++) {
            theSum = theSum + i;
        }
        return theSum;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(sumOfN(10000));
        
        long elapsed = System.nanoTime() - startTime;
        System.out.printf("Elapsed time: %d nanosec.%n", elapsed);
    }
}
