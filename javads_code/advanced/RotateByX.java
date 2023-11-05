public class RotateByX {

    public static String encrypt(String message, int rotate) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String result = "";
        for (int i = 0; i < message.length(); i++) {
            int position = alphabet.indexOf(message.charAt(i));
            if (position >= 0) {
                result = result + alphabet.charAt((position + rotate) % 26);
            } else {
                result = result + message.charAt(i);
            }
        }
        return result;
    }

    public static String decrypt(String message, int rotate) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String result = "";
        for (int i = 0; i < message.length(); i++) {
            int position = alphabet.indexOf(message.charAt(i));
            if (position >= 0) {
                result = result +
                    alphabet.charAt((position + 26 - rotate) % 26);
            } else {
                result = result + message.charAt(i);
            }
        }
        return result;
    }
    
    public static void main(String [] args) {
        String test = "let us encrypt this.";
        String encrypted = encrypt(test, 10);
        System.out.println(encrypted);
        String decrypted = decrypt(encrypted, 10);
        System.out.println(decrypted);
    }
}
