public class ROT13 {

    public static String encrypt(String message) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String result = "";
        for (int i = 0; i < message.length(); i++) {
            int position = alphabet.indexOf(message.charAt(i));
            if (position >= 0) {
                result = result + alphabet.charAt((position + 13) % 26);
            } else {
                result = result + message.charAt(i);
            }
        }
        return result;
    }
    
    public static void main(String [] args) {
        String test = "let us encrypt this.";
        String encrypted = encrypt(test);
        System.out.println(encrypted);
        String decrypted = encrypt(encrypted);
        System.out.println(decrypted);
        
        System.out.println(encrypt("uryybjbeyq"));
    }
}
