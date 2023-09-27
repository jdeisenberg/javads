import java.util.Iterator;

public class Testor {

    public static void main(String[] args) {
        AVLTree<String, String> tree = new AVLTree<>();
        tree.put("Japan", "Tokyo");
        tree.put("France", "Paris");
        
        AVLTree.AVLTreeNode node = (AVLTree.AVLTreeNode) tree.get("Japan", tree.root);
       
    }
}
