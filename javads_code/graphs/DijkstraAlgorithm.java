import java.util.ArrayList;

public class DijkstraAlgorithm<T extends Comparable<T>> {
    
    public DijkstraAlgorithm() {
    }
    
    public void dijkstra(Graph<T> graph, Vertex<T> start) {
        PriorityQueue<Vertex<T>> pq = new PriorityQueue<>();
        ArrayList<Vertex<T>> vertices = graph.getVertexList();
        start.distance = 0;
        pq.heapify(vertices);

        while (pq != null) {
            Vertex<T> currentVertex = pq.dequeue();
            for (Vertex<T> nextVertex: currentVertex.getNeighbors()) {
                int newDistance = currentVertex.distance +
                    currentVertex.getNeighbor(nextVertex);
                if (newDistance < nextVertex.distance) {
                    nextVertex.distance = newDistance;
                    nextVertex.previous = currentVertex;
                    pq.changePriority(nextVertex, newDistance);
                }
            }
        }
    }
}

