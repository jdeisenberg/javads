public class Palindrome {

    public static boolean isPalindrome(String str) {
        Deque<Character> charDeque = new Deque<Character>();
        
        for (int i = 0; i < str.length(); i++) {
            charDeque.addTail(str.charAt(i));
        }
        
        while (charDeque.size() > 1) {
            Character first = charDeque.removeHead();
            Character last = charDeque.removeTail();
            if (!first.equals(last)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println("Is \"regular\" a palindrome? " +
            isPalindrome("regular"));
        System.out.println("Is \"rotator\" a palindrome? " +
            isPalindrome("rotator"));
        System.out.println("Is \"deed\" a palindrome? " +
            isPalindrome("deed"));
    }
}
