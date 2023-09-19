public class RecursivePalindromesSolution {

    /*
     * Given a String, return the string with only letters,
     * and all in lower case.
     */
    public static String lettersOnly(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch)) {
                result = result + Character.toLowerCase(ch);
            }
        }
        return result;
    }
    
    /*
     * Return true if the given string is a palindrome,
     * false otherwise.
     */
    public static boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        } else {
            if (s.charAt(0) == s.charAt(s.length() - 1)) {
                return isPalindrome(s.substring(1, s.length() - 1));
            } else {
                return false;
            }
        }
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
