public class Testor {
    public static String toString(int n, int base, int level) {
        String [] digitStrings = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        System.out.print("level " + level + ": ");
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.print(n + " " + base);
        if (n < base) {
            System.out.println(" base case " + n);
            return digitStrings[n];
        } else {
            int remainder = n % base;
            System.out.println("Adding " + remainder);
            return toString(n / base, base, level + 1) + digitStrings[remainder];
        }
    }

    public static void main(String[] args) {
        System.out.println(toString(13, 2, 0));     // 1101
    }
}
