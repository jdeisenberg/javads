import java.util.Iterator;

public class BinarySearchDeleteTest {

    public static BinarySearchTree<Integer, Integer> makeTree(int[] numbers) {
        BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<>();
        for (int i = 0; i < numbers.length; i++) {
            tree.put(numbers[i], numbers[i]);
        }
        return tree;
    }
    
    public static void showTree(BinarySearchTree<Integer, Integer> tree) {
        for (BinarySearchTree.TreeNode node: tree) {
                System.out.println(node.getKey() + " -> "
                    + node.getValue());
            }
    }
    
    public static void main(String[] args) {
        BinarySearchTree<Integer, Integer> tree = 
            makeTree(new int[]{10, 8, 7});
        tree.removeKey(8);
        showTree(tree);
        System.out.println("===========");
        
        tree = makeTree(new int[]{10, 12, 11});
        tree.removeKey(12);
        showTree(tree);
        System.out.println("===========");
        
        tree = makeTree(new int[]{10, 8, 9});
        tree.removeKey(8);
        showTree(tree);
        System.out.println("===========");
        
        tree = makeTree(new int[]{10, 8, 9});
        tree.removeKey(10);
        showTree(tree);
        System.out.println("===========");

        tree = makeTree(new int[]{10, 8, 9});
        tree.removeKey(9);
        showTree(tree);
        System.out.println("===========");

        tree = makeTree(new int[] {12, 10, 7, 9, 15, 14, 17});
        tree.removeKey(10);
        showTree(tree);
        System.out.println("==================");
        
    }
        
}
