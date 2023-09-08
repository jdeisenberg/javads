class FormatExamples {

    public static void main(String[] args) {
        String word = "Java";
        int number = 123456;
        double value = 12345.678901234;
        
        /*
         * The vertical bars in the output let you see the
         * alignment more clearly.
         */
         
        System.out.format("|%s|%n", word);
        System.out.format("|%10s|%n", word);    // right-aligned
        System.out.format("|%-10s|%n", word);   // left-aligned
        
        System.out.println(); // blank line for readability
        
        System.out.format("|%d|%n", number);
        System.out.format("|%10d|%n", number);
        System.out.format("|%-10d|%n", number);
        System.out.format("|%,10d|%n", number);
        
        System.out.println();
        
        System.out.format("|%f|%n", value);
        System.out.format("|%10.3f|%n", value);
        System.out.format("|%,10.3f|%n", value);
        System.out.format("|%10.3e|%n", value);
        System.out.format("|%10.7f|%n", value);
    }
}
