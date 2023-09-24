public class TreeExercise {

    public static BinaryTree<String> buildTree() {
        BinaryTree<String> result = new BinaryTree<>("a");

        result.insertLeft("b");
        result.insertRight("c");
        result.getLeftChild().insertRight("d");
        result.getRightChild().insertLeft("e");
        result.getRightChild().insertRight("f");
        
        return result;
    }

    public static void main(String[] args) {
        BinaryTree<String> testTree = buildTree();
        System.out.println(testTree.getRightChild().getRootValue()); // "c"
        System.out.println(testTree.getLeftChild().getRightChild().
            getRootValue()); // "d"
        System.out.println(testTree.getRightChild().getLeftChild().
            getRootValue()); // "e"
    }
}
