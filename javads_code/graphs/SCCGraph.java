import java.util.ArrayList;
import java.util.Collections;

public class SCCGraph<T extends Comparable<T>> extends DFSGraph<T> {

    int time;
    
    public SCCGraph() {
        super();
    }

    public ArrayList<ArrayList<T>> sccDfs() {
        time = 0;
        Vertex<T> vertex;
        ArrayList<ArrayList<T>> result = new ArrayList<>();
        
        for (T key: getVertexKeys()) {
            vertex = vertices.get(key);
            vertex.setColor(VertexColor.WHITE);
            vertex.setPrevious(null);
        }
        
        ArrayList<Vertex<T>> vertexList = this.getVertexList();
        Collections.sort(vertexList, new Vertex.ByClosingTime());
        Collections.reverse(vertexList);
        
        for (Vertex<T> visit: vertexList) {
            if (visit.color == VertexColor.WHITE) {
                ArrayList<T> forest = new ArrayList<>();
                dfsVisit(visit, forest);
                result.add(forest);
            }
        }
        return result;
    }

    void dfsVisit(Vertex<T> startVertex, ArrayList<T> forest) {
        startVertex.setColor(VertexColor.GRAY);
        forest.add(startVertex.key);
        time = time + 1;
        startVertex.discoveryTime = time;
        for (Vertex<T> nextVertex: startVertex.getNeighbors()) {
            if (nextVertex.color == VertexColor.WHITE) {
                nextVertex.previous = startVertex;
                dfsVisit(nextVertex, forest);
            }
        }
        startVertex.setColor(VertexColor.BLACK);
        time = time + 1;
        startVertex.closingTime = time;
    }
}
