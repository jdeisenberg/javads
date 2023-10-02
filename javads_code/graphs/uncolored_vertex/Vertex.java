import java.util.HashMap;
import java.util.Set;

public class Vertex<T extends Comparable<T>>
    implements Comparable<Vertex<T>> {
    
    T key;
    HashMap<Vertex<T>, Integer> neighbors;
    
    Vertex(T key) {
        this.key = key;
        this.neighbors = new HashMap<Vertex<T>, Integer>();
    }
    
    /*
     * Get the weight of the edge from this vertex
     * to the other vertex. Returns null if there is no
     * connection to the other vertex.
     */
    Integer getNeighborWeight(Vertex<T> other) {
        return neighbors.get(other);
    }
    
    /*
     * Set a connection from this vertex to the other
     * vertex with a weight of zero
     */
    void setNeighbor(Vertex<T> other) {
        setNeighbor(other, 0);
    }
    
    /*
     * Set a connection from this vertex to the other
     * vertex with the given weight
     */
    void setNeighbor(Vertex<T> other, Integer weight) {
        neighbors.put(other, weight);
    }
    
    /*
     * Return a Set of the neighbor vertices.
     */
    Set<Vertex<T>> getNeighbors() {
        return neighbors.keySet();
    }

    /*
     * Return the key for this vertex.
     */
    T getKey() {
        return key;
    }
    
    public String toString() {
        String result = this.key.toString();
        if (neighbors.size() > 0) {
            result = result + " connected to: ";
            for (Vertex<T> vertex: this.getNeighbors()) {
                result = result + vertex.key + ", ";
            }
            result = result.substring(0, result.length() - 2);
        } else {
            result = result + " has no connections";
        }
        return result;
    }
    
    public int compareTo(Vertex<T> other) {
        return this.key.compareTo(other.key);
    }

}
