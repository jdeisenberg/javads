public class Anagrams1 {
    
    public static boolean anagramSolution1(String s1, String s2) {
        boolean isAnagram = true;
        
        if (s1.length() != s2.length()) {
            isAnagram = false;
        } else {
            int pos1 = 0;
            char[] s2Array = s2.toCharArray();
            while (pos1 < s1.length() && isAnagram) {
                int pos2 = 0;
                boolean found = false;
                while (pos2 < s2.length() && !found) {
                    if (s1.charAt(pos1) == s2Array[pos2]) {
                        found = true;
                    } else {
                        pos2 = pos2 + 1;
                    }
                }
                if (found) {
                    s2Array[pos2] = '-';
                } else {
                    isAnagram = false;
                }
                pos1 = pos1 + 1;
            }
        }
        return isAnagram;
    }
    
    public static void main(String[] args) {
        System.out.println(anagramSolution1("taster", "treats"));  // expected: true
        System.out.println(anagramSolution1("abcd", "dcab")); // expected: true
        System.out.println(anagramSolution1("abcd", "dcda"));  // expected: false
    }
}


