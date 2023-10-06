import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class StronglyConnectedComponents {

    public static SCCGraph<String> transpose(SCCGraph<String> g) {
        SCCGraph<String> result = new SCCGraph<>();
        Set<String> keys = g.getVertexKeys();
        for (String s: keys) {
            Vertex<String> v = g.getVertex(s);
            for (Vertex<String> neighbor: v.getNeighbors()) {
                result.addEdge(neighbor.key, v.key);
                /* 
                 * At this point, we are guaranteed that neighbor
                 * and v are both in the result. Copy the discovery
                 * time and closing time.
                 */
                Vertex<String> resultV = result.getVertex(s);
                Vertex<String> resultNeighbor = result.getVertex(neighbor.key);
                resultV.closingTime = v.closingTime;
                resultV.discoveryTime = v.discoveryTime;
                resultNeighbor.closingTime = neighbor.closingTime;
                resultNeighbor.discoveryTime = neighbor.discoveryTime;
            }
        }
        return result;
    }
    
    public static void showGraph(SCCGraph<String> g) {
        Set<String> keys = g.getVertexKeys();
        for (String s: keys) {
            Vertex<String> v = g.getVertex(s);
            System.out.println(v + " (" + v.discoveryTime + "/" +
                v.closingTime + ")");
        }
    }
        
    public static void main(String[] args) {
        SCCGraph<String> g = new SCCGraph<>();
        SCCGraph<String> gT;
        
        g.addEdge("A", "B");
        g.addEdge("B", "E");
        g.addEdge("E", "A");
        g.addEdge("D", "B");
        g.addEdge("D", "G");
        g.addEdge("E", "D");
        g.addEdge("B", "C");
        g.addEdge("G", "E");
        g.addEdge("C", "C");
        g.addEdge("C", "F");
        g.addEdge("F", "H");
        g.addEdge("H", "I");
        g.addEdge("I", "F");

        g.dfs();
        gT = transpose(g);
        
        System.out.println("==== after transpose ====");
        showGraph(gT);

        ArrayList<ArrayList<String>> forests = gT.sccDfs();
        
        System.out.println("==== forests ====");
        
        for (ArrayList<String> forest: forests) {
            for (String s: forest) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
