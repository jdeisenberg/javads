public class DepthFirstSearchTest {

    public static void main(String[] args) {
        Graph<String> testGraph = new Graph<String>();
        testGraph.addEdge("A", "B");
        testGraph.addEdge("B", "C");
        testGraph.addEdge("A", "D");
        testGraph.addEdge("D", "E");
        testGraph.addEdge("E", "B");
        testGraph.addEdge("E", "F");
        testGraph.addEdge("F", "C");
        
    }
}
        
