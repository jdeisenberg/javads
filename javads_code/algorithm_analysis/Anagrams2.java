import java.util.Arrays;

public class Anagrams2 {
    
    public static boolean anagramSolution2(String s1, String s2) {
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        
        Arrays.sort(s1Array);
        Arrays.sort(s2Array);
        
        int pos = 0;
        boolean matches = true;
        
        while (pos < s1.length() && matches) {
            if (s1Array[pos] == s2Array[pos]) {
                pos = pos + 1;
            } else {
                matches = false;
            }
        }
        return matches;
    }
        
    public static void main(String[] args) {
        System.out.println(anagramSolution2("taster", "treats"));  // expected: true
        System.out.println(anagramSolution2("abcd", "dcab")); // expected: true
        System.out.println(anagramSolution2("abcd", "dcda"));  // expected: false
    }
}


