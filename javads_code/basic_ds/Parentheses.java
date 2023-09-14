public class Parentheses {
    public static boolean parenCheck(String symbolString) {
        Stack<Character> symStack = new Stack<>();
        
        for (int i = 0; i < symbolString.length(); i++) {
            Character symbol = symbolString.charAt(i);
            
            if (symbol == '(') {
                symStack.push(symbol);
            } else if (symbol == ')') {
                if (symStack.isEmpty()) {
                    return false;
                } else {
                    symStack.pop();
                }
            } else {
                // not a parenthesis; skip over it
            }
        }

        return symStack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(parenCheck("((()))"));  // expected true
        System.out.println(parenCheck("((()()))"));  // expected true
        System.out.println(parenCheck("(()"));  // expected false
        System.out.println(parenCheck(")("));  // expected false
    }
}
