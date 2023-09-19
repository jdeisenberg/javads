import java.util.HashMap;
import java.util.ArrayList;

public class EvaluatePostfix {
    
    public static Integer postfixEval(String postfixExpr) {
        
        final String DIGITS = "012356789";
        
        Stack<Integer> operandStack = new Stack<Integer>();
        
        String[] tokenList = postfixExpr.split(" ");
        
        for (String token: tokenList) {
            if (DIGITS.indexOf(token) >= 0) {
                operandStack.push(Integer.valueOf(token));
            }
            else {
                Integer operand2 = operandStack.pop();
                Integer operand1 = operandStack.pop();
                Integer result = doMath(token, operand1, operand2);
                operandStack.push(result);
            }
        }
        return operandStack.pop();
    }

    public static Integer doMath(String operator, Integer operand1, Integer operand2) {
        if (operator.equals("*")) {
            return operand1 * operand2;
        }
        else if (operator.equals("/")) {
            return operand1 / operand2;
        }
        else if (operator.equals("+")) {
            return operand1 + operand2;
        }
        else {
            return operand1 - operand2;
        }
    }

    public static void main(String[] args) {
        System.out.println(postfixEval("7 8 + 3 2 + /"));
    }
}


/*
 * from pythonds3.basic import Stack

def postfix_eval(postfix_expr):
    operand_stack = Stack()
    token_list = postfix_expr.split()

    for token in token_list:
        if token in "0123456789":
            operand_stack.push(int(token))
        else:
            operand2 = operand_stack.pop()
            operand1 = operand_stack.pop()
            result = do_math(token, operand1, operand2)
            operand_stack.push(result)
    return operand_stack.pop()


def do_math(op, op1, op2):
    if op == "*":
        return op1 * op2
    elif op == "/":
        return op1 / op2
    elif op == "+":
        return op1 + op2
    else:
        return op1 - op2


print(postfix_eval("7 8 + 3 2 + /"))
*/
