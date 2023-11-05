public class ExtGCDTest {
    
    public static int[] extGcd(int x, int y) {
        if (y == 0) {
            return(new int[] {x, 1, 0});
        } else {
            int[] info = extGcd(y, x % y);
            int d = info[0];
            int a = info[1];
            int b = info[2];
            return(new int[] {d, b, a - (x / y) * b});
        }
    }
    
    public static void main(String[] args) {
        
    }
}
