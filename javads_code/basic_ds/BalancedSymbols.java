public class BalancedSymbols {
    
    static String openers = "({[";
    static String closers = ")}]";
    
    public static boolean matches(Character openSymbol, Character closeSymbol) {
        return openers.indexOf(openSymbol) == closers.indexOf(closeSymbol);
    }
    
    public static boolean balanceCheck(String symbolString) {
        Stack<Character> symStack = new Stack<>();
        
        for (int i = 0; i < symbolString.length(); i++) {
            Character symbol = symbolString.charAt(i);
            
            if (openers.indexOf(symbol) != -1) {
                symStack.push(symbol);
            } else if (closers.indexOf(symbol) != -1) {
                if (symStack.isEmpty()) {
                    return false;
                } else {
                    if (!matches(symStack.pop(), symbol)) {
                       return false;
                    }
                }
            } else {
                // not a parenthesis; skip over it
            }
        }

        return symStack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(balanceCheck("{({([][])}())}")); // expect true
        System.out.println(balanceCheck("[{()]")); // expect false
        System.out.println(balanceCheck("[{()]]")); // expect false
    }
}
/*
from pythonds3.basic import Stack


def balance_checker(symbol_string):
    s = Stack()
    for symbol in symbol_string:
        if symbol in "([{":
            s.push(symbol)
        else:
            if s.is_empty():
                return False
            else:
                if not matches(s.pop(), symbol):
                    return False

    return s.is_empty()

def matches(sym_left, sym_right):
    all_lefts = "([{"
    all_rights = ")]}"
    return all_lefts.index(sym_left) == all_rights.index(sym_right)
*/

