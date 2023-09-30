import java.util.Iterator;

public class AVLTreeExample {

    public static void main(String[] args) {
        AVLTree<String, String> tree = new AVLTree<>();
        
        tree.put("Albania", "Tirana");
        System.out.println(tree);

        tree.put("Bolivia", "La Paz");
        System.out.println(tree);

        tree.put("Germany", "Berlin");
        System.out.println(tree);

        tree.put("Lesotho", "Maseru");
        System.out.println(tree);

        tree.put("Madagascar", "Antananarivo");
        System.out.println(tree);

        tree.put("South Korea", "Seoul");
        System.out.println(tree);
    }
}
