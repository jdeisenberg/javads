import java.util.HashMap;

public class MismatchedLinks {
    public static HashMap<Integer, Integer> mismatchedLinks(String pattern) {
        String aug_pattern = "0" + pattern;
        HashMap<Integer, Integer> links = new HashMap<>();
        links.put(1, 0);
        for (int k = 2; k < aug_pattern.length(); k++) {
            int s = links.get(k - 1);
            while (s >= 1 && aug_pattern.charAt(s) != aug_pattern.charAt(k - 1)) {
                if (aug_pattern.charAt(s) != aug_pattern.charAt(k - 1)) {
                    s = links.get(s);
                }
            }
            links.put(k, s + 1);
        }
        return links;
    }
    
    public static void main(String[] args) {
        HashMap<Integer, Integer> result = mismatchedLinks("ACATA");
        System.out.println(result);
    }
}

    
