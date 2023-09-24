      
public static void preorder(BinaryTree<String> tree) {
    if (tree != null) {
        System.out.println(tree.getRootValue());
        preorder(tree.getLeftChild());
        preorder(tree.getRightChild());
    }
}


public void preorder() {
    System.out.println(this.key);
    if (this.leftChild != null) {
        this.leftChild.preorder();
    }
    if (this.rightChild != null) {
        this.rightChild.preorder();
    }
}

public static void postOrder(BinaryTree<String> tree) {
    if (tree != null) {
        postOrder(tree.getLeftChild());
        postOrder(tree.getRightChild());
        System.out.println(tree.getKeyValue());
    }
}
