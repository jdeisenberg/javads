public class ConvertViaStack {

    public static String convert(int n, int base) {
        Stack<String> rStack = new Stack<>();
        
        String [] digitStrings = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        
        while (n > 0) {
            if (n < base) {
                rStack.push(digitStrings[n]);
            } else {
                rStack.push(digitStrings[n % base]);
            }
            n = n / base;
        }
        
        String result = "";
        while (! rStack.isEmpty()) {
            result = result + rStack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(convert(13, 2));
    }
}
