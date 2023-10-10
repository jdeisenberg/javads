import java.util.ArrayList;

public class PrimsAlgorithm<T extends Comparable<T>> {
    
    public PrimsAlgorithm() {
    }
    
    public void prim(Graph<T> graph, Vertex<T> start) {
        PriorityQueue<Vertex<T>> pq = new PriorityQueue<>();
        ArrayList<Vertex<T>> vertices = graph.getVertexList();
        for (Vertex<T> vertex: vertices) {
            vertex.distance = Integer.MAX_VALUE;
            vertex.previous = null;
        }
        start.distance = 0;
        pq.heapify(vertices);

        while (!pq.isEmpty()) {
            Vertex<T> currentVertex = pq.dequeue();
            for (Vertex<T> nextVertex: currentVertex.getNeighbors()) {
                int newDistance = currentVertex.getNeighbor(nextVertex);
                if (pq.contains(nextVertex) && newDistance < nextVertex.distance) {
                    nextVertex.distance = newDistance;
                    nextVertex.previous = currentVertex;
                    pq.changePriority(nextVertex, newDistance);
                }
            }
        }
    }
}


/*
 * import sys
from pythonds3.graphs import PriorityQueue


def prim(graph, start):
    pq = PriorityQueue()
    for vertex in graph:
        vertex.distance = sys.maxsize
        vertex.previous = None
    start.distance = 0
    pq.heapify([(vertex.distance, vertex) for vertex in graph])
    while not pq.is_empty():
        distance, current_v = pq.delete()
        for next_v in current_v.get_neighbors():
            new_distance = current_v.get_neighbor(next_v)
            if next_v in pq and new_distance &lt; next_v.distance:
                next_v.previous = current_v
                next_v.distance = new_distance
                pq.change_priority(next_v, new_distance)
*/
