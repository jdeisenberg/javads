public class ModExpTest {
    
    public static int modExp(int x, int n, int p) {
        System.out.printf("n is %d\n", n);
        if (n == 0) {
            return 1;
        }
        int t = (x * x) % p;
        int result = modExp(t, n / 2, p);
        if (n % 2 != 0) {
            result = (result * x) % p;
        }
        return result;
    }
    
    public static void main(String[] args) {
        int small = modExp(3, 4, 10);
        System.out.println("last digit of 3**4 is " + small);
        
        int big = modExp(3, 1_254_906, 10);
        System.out.println("last digit of 3**1,254,906 is " + big);
    }
}
