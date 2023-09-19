public class RecursiveBaseConversion {
    public static String convert(int n, int base) {
        String [] digitStrings = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        if (n < base) {
            return digitStrings[n];
        } else {
            int remainder = n % base;
            return convert(n / base, base) + digitStrings[remainder];
        }
    }

    public static void main(String[] args) {
        System.out.println(convert(13, 2));     // 1101
        System.out.println(convert(1066, 16));  // 42A
    }
}
