import java.util.HashMap;
import java.util.Set;

public class Graph<T> {
    HashMap<T, Vertex<T>> vertices;
    
    public Graph() {
        this.vertices = new HashMap<T, Vertex<T>>();
    }

    public void setVertex(T key) {
        vertices.put(key, new Vertex<T>(key));
    }
    
    public Vertex<T> getVertex(T key) {
        return vertices.get(key);
    }

    public boolean containsVertex(T key) {
        return vertices.containsKey(key);
    }
    
    public void addEdge(T fromVertex, T toVertex) {
        addEdge(fromVertex, toVertex, 0);
    }
    
    public void addEdge(T fromVertex, T toVertex,
        Integer weight) {
        if (!vertices.containsKey(fromVertex)) {
            setVertex(fromVertex);
        }
        if (!vertices.containsKey(toVertex)) {
            setVertex(toVertex);
        }
        Vertex<T> from = vertices.get(fromVertex);
        Vertex<T> to = vertices.get(toVertex);
        from.setNeighbor(to, weight);
    }
    
    public HashMap<T, Vertex<T>> getVertices() {
        return this.vertices;
    }
    
    public Set<T> getVertexKeys() {
        return this.vertices.keySet();
    }
}
