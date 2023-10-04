public class DFSGraph<T extends Comparable<T>> extends Graph<T> {

    int time;
    
    public DFSGraph() {
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
                dfsVisit(vertex);
            }
        }
    }

    void dfsVisit(Vertex<T> startVertex) {
        startVertex.setColor(VertexColor.GRAY);
        time = time + 1;
        startVertex.discoveryTime = time;
        for (Vertex<T> nextVertex: startVertex.getNeighbors()) {
            if (nextVertex.color == VertexColor.WHITE) {
                nextVertex.previous = startVertex;
                dfsVisit(nextVertex);
            }
        }
        startVertex.setColor(VertexColor.BLACK);
        time = time + 1;
        startVertex.closingTime = time;
    }
}
