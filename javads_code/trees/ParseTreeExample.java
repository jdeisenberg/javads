public class ParseTreeExample {

    private static Double apply(String operator, Double leftOperand,
        Double rightOperand) {
            
        Double result;
        
        if (operator.equals("+")) {
            result = leftOperand + rightOperand;
        } else if (operator.equals("-")) {
            result = leftOperand - rightOperand;
        } else if (operator.equals("*")) {
            result = leftOperand * rightOperand;
        } else {
            result = leftOperand / rightOperand;
        }
        return result;
    }
    
    public static Double evaluate(BinaryTree<String> parseTree) {
        BinaryTree<String> leftChild = parseTree.getLeftChild();
        BinaryTree<String> rightChild = parseTree.getRightChild();
        
        if (leftChild != null && rightChild != null) {
            String operator = parseTree.getRootValue();
 
            double leftOperand = evaluate(leftChild);
            double rightOperand = evaluate(rightChild);
            
            return apply(operator, leftOperand, rightOperand);
        } else {
            return Double.valueOf(parseTree.getRootValue());
        }
    }

    public static Double postorderEvaluate(BinaryTree<String> tree) {
        Double leftValue = null;
        Double rightValue = null;
        Double result;
        if (tree != null) {
            leftValue = postorderEvaluate(tree.getLeftChild());
            rightValue = postorderEvaluate(tree.getRightChild());
            if (leftValue != null && rightValue != null) {
                String operator = tree.getRootValue();
                return apply(operator, leftValue, rightValue);
            }
            return Double.parseDouble(tree.getRootValue());
        } else {
            return null;
        }
    }
            
    
    public static void inorder(BinaryTree<String> tree) {
        if (tree != null) {
            inorder(tree.leftChild);
            System.out.println(tree.key);
            inorder(tree.rightChild);
        }
    }
        
    public static String expressionToString(BinaryTree<String> tree) {
        String result = "";
        if (tree != null) {
            result = result + "(" + expressionToString(tree.leftChild);
            result = result + tree.key;
            result = result + expressionToString(tree.rightChild) + ")";
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTree<String> parseTree =
            ParseTreeBuilder.buildParseTree("( 3 + ( 4 * 5 ) )");
        System.out.println(evaluate(parseTree));
        System.out.println(postorderEvaluate(parseTree));
        System.out.println(expressionToString(parseTree));
    }

}

