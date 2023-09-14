public class DecimalToBinary {
    public static String divideBy2(int decimal) {
        Stack<Integer> digitStack = new Stack<Integer>();
        
        while (decimal > 0) {
            digitStack.push(decimal % 2);
            decimal = decimal / 2;
        }
        
        String resultString = "";
        while (!digitStack.isEmpty()) {
            Integer digit = digitStack.pop();
            resultString = resultString + digit.toString();
        }
        return resultString;
    }

    public static void main(String[] args) {
        System.out.println(divideBy2(42));
        System.out.println(divideBy2(31));
    }
}
