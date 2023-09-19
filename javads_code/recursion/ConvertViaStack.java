public class ConvertViaStack {

    public static String toString(int n, int base) {
        Stack<String> rStack = new Stack<>();
        
        String [] digitStrings = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        
        while (n > 0) {
            if (n < base) {
                System.err.printf("pushing %d%n", n);
                rStack.push(digitStrings[n]);
            } else {
                System.err.printf("pushing remainder %d%n", n % base);
                rStack.push(digitStrings[n % base]);
            }
            n = n / base;
        }
        
        String result = "";
        while (! rStack.isEmpty()) {
            System.out.printf("About to pop %s%n", rStack.peek());
            result = result + rStack.pop();
            System.out.println("Result is now " + result);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(toString(13, 2));
    }
}
