class ParseTreeBuilder {
    /*
     * Given a fully-parenthesized expression, return its
     * parse tree.
     */
    public static BinaryTree<String> buildParseTree(String expr) {
        String[] tokenList = expr.split(" ");
        Stack<BinaryTree<String>> parentStack = new Stack<>();
        BinaryTree<String> exprTree = new BinaryTree<String>("");

        parentStack.push(exprTree);

        BinaryTree<String> currentTree = exprTree;

        for (String token: tokenList) {
            if (token.equals("(")) {
                currentTree.insertLeft("");
                parentStack.push(currentTree);
                currentTree = currentTree.leftChild;
            }
            else if ("+-*/".indexOf(token) >= 0) {
                currentTree.setRootValue(token);
                currentTree.insertRight("");
                parentStack.push(currentTree);
                currentTree = currentTree.rightChild;
            }
            else if (isNumber(token)) {
                currentTree.setRootValue(token);
                BinaryTree<String> parent = parentStack.pop();
                currentTree = parent;
            }
            else if (token.equals(")")) {
                currentTree = parentStack.pop();
            } else {
                throw new IllegalArgumentException("Unknown token "
                    + token);
            }
        }
        return exprTree;
    }

    public static boolean isNumber(String token) {
        try {
            Integer.valueOf(token);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
