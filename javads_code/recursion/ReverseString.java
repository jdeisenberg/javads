public class ReverseString {
    public static String reverse(String s) {
        // your code here
        return ""; // placeholder
    }

    public static void testEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            System.out.printf("\"%s\" and \"%s\" are equal.%n", s1, s2);
        } else {
            System.out.printf("\"%s\" and \"%s\" are not equal.%n", s1, s2);
        }
    }

    public static void main(String[] args) {
        testEqual(reverse("hello"), "olleh");
        testEqual(reverse("m"), "m");
        testEqual(reverse("follow"), "wollof");
        testEqual(reverse(""), "");
    }
}
