public class RecursivePalindromes {

    /*
     * Given a String, return the string with only letters,
     * and all in lower case.
     */
    public static String lettersOnly(String s) {
        return ""; // placeholder
    }
    
    /*
     * Return true if the given string is a palindrome,
     * false otherwise.
     */
    public static boolean isPalindrome(String s) {
        return false; // placeholder
    }
    
    public static void testResult(String s, boolean given, boolean expected) {
        System.out.printf("isPalindrome(\"%s\") returns %s; expected %s.%n",
            s, given, expected);
    }

    public static void main(String[] args) {
        testResult("x", isPalindrome(lettersOnly("x")), true);
        testResult("radar", isPalindrome(lettersOnly("radar")), true);
        testResult("hello", isPalindrome(lettersOnly("hello")), false);
        testResult("", isPalindrome(lettersOnly("")), true);
        testResult("hannah", isPalindrome(lettersOnly("hannah")), true);
        testResult("Madam, I'm Adam",
            isPalindrome(lettersOnly("Madam, I'm Adam.")), true);
    }
}
