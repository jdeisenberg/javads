import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Graph<T extends Comparable<T>> {
    
    HashMap<T, Vertex<T>> vertices;
    int time; // for depth-first search
    
    public Graph() {
        this.vertices = new HashMap<T, Vertex<T>>();
    }

    public void setVertex(T key) {
        Vertex<T> v = new Vertex<T>(key);
        vertices.put(key, v);
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
    
    public ArrayList<Vertex<T>> getVertexList() {
        ArrayList<Vertex<T>> result = new ArrayList<>();
        for (T key: vertices.keySet()) {
            result.add(vertices.get(key));
        }
        return result;
    }
    
    public Set<T> getVertexKeys() {
        return this.vertices.keySet();
    }
    
    public void bfs(Vertex<T> start) {
        start.color = VertexColor.GRAY;
        start.distance = 0;
        start.previous = null;
        
        Queue<Vertex<T>> vertexQueue = new Queue<>();
        vertexQueue.enqueue(start);
        while (vertexQueue.size() > 0) {
            Vertex<T> current = vertexQueue.dequeue();
            for (Vertex<T> neighbor: current.getNeighbors()) {
                if (neighbor.color == VertexColor.WHITE) {
                    neighbor.color = VertexColor.GRAY;
                    neighbor.distance = current.distance + 1;
                    neighbor.previous = current;
                    vertexQueue.enqueue(neighbor);
                }
            }
                    
            current.color = VertexColor.BLACK;
        }
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
