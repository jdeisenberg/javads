import java.util.ArrayList;
import java.util.Collections;

public class DepthFirstSearchTest<T> {

    public static void main(String[] args) {
        DFSGraph<String> testGraph = new DFSGraph<String>();
        testGraph.addEdge("A", "B");
        testGraph.addEdge("A", "D");
        testGraph.addEdge("B", "C");
        testGraph.addEdge("B", "D");
        testGraph.addEdge("D", "E");
        testGraph.addEdge("E", "B");
        testGraph.addEdge("E", "F");
        testGraph.addEdge("F", "C");
        testGraph.dfs();
        
        ArrayList<Vertex<String>> sortList = testGraph.getVertexList();
        for (Vertex<String> v: sortList) {
            System.out.println(v);
        }
        
        Collections.sort(sortList, new ByClosingTime());
        System.out.println("=====");
        for (Vertex<String> v: sortList) {
            System.out.println(v.key + " " + v.discoveryTime + "/" + v.closingTime);
        }
        
        Collections.sort(sortList, new ByDiscoveryTime());
        System.out.println("=====");
        for (Vertex<String> v: sortList) {
            System.out.println(v.key + " " + v.discoveryTime + "/" + v.closingTime);
        }
   }
}
        
