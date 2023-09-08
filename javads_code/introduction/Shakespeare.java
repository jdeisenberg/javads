import java.util.Random;

class Shakespeare {
    
    public static String generateString(Random generator, int len) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz ";
        String result = "";
        for (int i = 0; i < len; i++) {
            int charPos = generator.nextInt(alphabet.length());
            result = result + alphabet.substring(charPos, charPos + 1);
        }
        return result;
    }
    
    public static void main(String[] args) {
        Random generator = new Random();
        String goal = "methinks it is like a weasel";
        System.out.println(goal);
        for (int i = 0; i < 10; i++) {
            String phrase = generateString(generator, goal.length());
            System.out.println(phrase);
        }
    }
}
