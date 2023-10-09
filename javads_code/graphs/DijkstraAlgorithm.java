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

/*
def dijkstra(graph, start):
   pq = PriorityQueue()
   start.distance = 0
   pq.heapify([(v.distance, v) for v in graph])
   while pq:
      distance, current_v = pq.delete()
      for next_v in current_v.get_neighbors():
            new_distance = current_v.distance + current_v.get_neighbor(next_v)
            if new_distance &lt; next_v.distance:
               next_v.distance = new_distance
               next_v.previous = current_v
               pq.change_priority(next_v, new_distance)
*/
