import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class DFSDebuggingGraph<T extends Comparable<T>>  extends Graph<T> {

    int time; // for depth-first search
    
    public DFSDebuggingGraph() {
        super();
    }

    public void dfs() {
        time = 0;
        Vertex<T> vertex;
        
        for (T key: getVertexKeys()) {
            vertex = vertices.get(key);
            vertex.setColor(VertexColor.WHITE);
            vertex.setPrevious(null);
        }
        
        for (T key: getVertexKeys()) {
            vertex = vertices.get(key);
            if (vertex.color == VertexColor.WHITE) {
                dfsVisit(vertex, 0);
            }
        }
    }
    
    String indent(int n) {
        return ("                        ".substring(0, 2 * n));
    }
    
    void dfsVisit(Vertex<T> startVertex, int level) {
        System.out.println(indent(level) + "Entering dfsVisit with vertex " + startVertex);
        startVertex.setColor(VertexColor.GRAY);
        time = time + 1;
        startVertex.discoveryTime = time;
        System.out.println(indent(level) + "Discovered " + startVertex + " at time " + time);
        for (Vertex<T> nextVertex: startVertex.getNeighbors()) {
            System.out.println(indent(level) + "Looking at neighbor " + nextVertex);
            if (nextVertex.color == VertexColor.WHITE) {
                nextVertex.previous = startVertex;
                dfsVisit(nextVertex, level + 1);
            }
        }
        startVertex.setColor(VertexColor.BLACK);
        time = time + 1;
        startVertex.closingTime = time;
        System.out.println(indent(level) + "Closed " + startVertex + " at time " + time);
    }
}
