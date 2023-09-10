import java.util.Arrays;

public class Anagrams4 {
    
    public static boolean anagramSolution4(String s1, String s2) {
        int[] count1 = new int[26]; // initialized to all zeros
        int[] count2 = new int[26];
        
        for (int i = 0; i < s1.length(); i++) {
            int index = s1.charAt(i) - 'a';
            count1[index] = count1[index] + 1;
        }
        
        for (int i = 0; i < s2.length(); i++) {
            int index = s2.charAt(i) - 'a';
            count2[index] = count2[index] + 1;
        }
        
        int j = 0;
        boolean isAnagram = true;
        while (j < 26 && isAnagram) {
            if (count1[j] == count2[j]) {
                j = j + 1;
            } else {
                isAnagram = false;
            }
        }
        return isAnagram;
    }

    public static void main(String[] args) {
        System.out.println(anagramSolution4("taster", "treats"));  // expected: true
        System.out.println(anagramSolution4("abcd", "dcab")); // expected: true
        System.out.println(anagramSolution4("abcd", "dcda"));  // expected: false
    }
}


