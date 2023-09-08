public class FindSum {
    public static int sumOfN(int n) {
        int theSum = 0;
        for (int i = 1; i <= n; i++) {
            theSum = theSum + i;
        }
        return theSum;
    }

    public static void main(String[] args) {
        System.out.println(sumOfN(10));
    }
}
