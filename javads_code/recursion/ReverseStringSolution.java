public class ReverseStringSolution {
    public static String reverse(String s) {
        if (s.length() <= 1) {
            return s;
        } else {
            return reverse(s.substring(1)) + s.substring(0, 1);
        }
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
