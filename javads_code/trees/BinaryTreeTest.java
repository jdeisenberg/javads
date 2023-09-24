public class BinaryTreeTest {
    
    public static void main(String[] args) {
        BinaryTree<String> aTree = new BinaryTree<>("a");
        
        System.out.println(aTree.getRootValue()); // "a"
        System.out.println(aTree.getLeftChild()); // null
        
        aTree.insertLeft("b");
        System.out.println(aTree.getLeftChild()); // reference to BinaryTree
        System.out.println(aTree.getLeftChild().getRootValue()); // "b"
        
        aTree.insertRight("c");
        System.out.println(aTree.getRightChild()); // reference to BinaryTree
        System.out.println(aTree.getRightChild().getRootValue()); // "c"
        
        aTree.getRightChild().setRootValue("d");
        System.out.println(aTree.getRightChild().getRootValue()); // "d"
        
    }
}
