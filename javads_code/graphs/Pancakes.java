import java.util.ArrayList;
import java.util.Collections;

public class Pancakes {

    public static void main(String[] args) {
        DFSGraph<String> pancake = new DFSGraph<String>();
        pancake.addEdge("3/4 cup milk", "1 cup mix");
        pancake.addEdge("1 egg", "1 cup mix");
        pancake.addEdge("1 Tbsp oil", "1 cup mix");
        pancake.addEdge("1 cup mix", "pour 1/4 cup");
        pancake.addEdge("1 cup mix", "heat syrup");
        pancake.addEdge("heat griddle", "pour 1/4 cup");
        pancake.addEdge("pour 1/4 cup", "turn when bubbly");
        pancake.addEdge("turn when bubbly", "eat");
        pancake.addEdge("heat syrup", "eat");
        pancake.dfs();
        
        ArrayList<Vertex<String>> sortList = pancake.getVertexList();
        Collections.sort(sortList, new ByClosingTime());
        Collections.reverse(sortList);
        for (Vertex<String> v: sortList) {
            System.out.println(v.key + " (" + v.discoveryTime +
                "/" + v.closingTime + ")");
        }
   }
}
        
