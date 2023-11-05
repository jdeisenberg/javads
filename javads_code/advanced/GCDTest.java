public class GCDTest {
    
    /*
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        else if (a < b) {
            return gcd(b, a);
        }
        return gcd(a - b, b);
    }
    */
    
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    
    public static void main(String[] args) {
        System.out.println("gcd of 12 and 60 is " + 
            gcd(12, 60));
        
        System.out.println("gcd of 12 and 35 is " +
            gcd(12, 35));
    }
}
