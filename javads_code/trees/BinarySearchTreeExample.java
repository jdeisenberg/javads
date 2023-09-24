import java.util.Iterator;

public class BinarySearchTreeExample {

    public static void main(String[] args) {
        BinarySearchTree<String, String> tree = new BinarySearchTree<>();
        
        tree.put("France", "Paris");
        tree.put("Japan", "Tokyo");
        tree.put("Albania", "Tirana");
        tree.put("Madagascar", "Antananarivo");
        tree.put("Zimbabwe", "Harare");
        tree.put("South Korea", "Seoul");
        
        System.out.println(tree.get("Japan"));  // "Tokyo"
        System.out.println(tree.get("Brazil")); // null
        
        for (BinarySearchTree.TreeNode node: tree) {
            System.out.println(node.getKey() + " -> "
                + node.getValue());
        }
        
        System.out.println("-----------------------------");
        
        Iterator<BinarySearchTree<String, String>.TreeNode> iter =
            tree.iterator();
        
        while (iter.hasNext()) {
            BinarySearchTree.TreeNode node = iter.next();
            System.out.println(node.getKey() + " -> " + node.getValue());
        }
    }
}
