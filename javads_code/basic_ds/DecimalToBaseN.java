public class DecimalToBaseN {

    public static String baseConvert(int decimal, int base) {
        final String digits = "0123456789ABCDEF";
        
        Stack<Integer> digitStack = new Stack<Integer>();
        
        while (decimal > 0) {
            digitStack.push(decimal % base);
            decimal = decimal / base;
        }
        
        String resultString = "";
        while (!digitStack.isEmpty()) {
            Integer digit = digitStack.pop();
            resultString = resultString +
                digits.substring(digit, digit + 1);
        }
        return resultString;
    }

    public static void main(String[] args) {
        System.out.println(baseConvert(30, 2));  // expect 11110
        System.out.println(baseConvert(30, 8));  // expect 36
        System.out.println(baseConvert(30, 16)); // expect 1e
    }
}
