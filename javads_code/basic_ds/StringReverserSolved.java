public class StringReverserSolved {

    public static String reverseString(String str) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.substring(i, i + 1));
        }
        String result = "";
        while (!stack.isEmpty()) {
            result = result + stack.pop();
        }
        return result; // placeholder
    }

    public static void testEqual(String str1, String str2) {
        if (str1.equals(str2)) {
            System.out.printf("%s and %s are equal.%n", str1, str2);
        } else {
            System.out.printf("%s and %s are not equal.%n", str1, str2);
        }
    }

    public static void main(String[] args) {
        testEqual(reverseString("apple"), "elppa");
        testEqual(reverseString("x"), "x");
        testEqual(reverseString("1234567890"), "0987654321");
    }
}
