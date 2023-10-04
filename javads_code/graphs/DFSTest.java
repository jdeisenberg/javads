import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DFSTest {

    
    public static boolean knightTour(int currentDepth, ArrayList<Vertex<Integer>> path,
        Vertex<Integer> vertex, int nodesInPath) {
        boolean done;
        
        vertex.color = VertexColor.GRAY;
        path.add(vertex);
        
        if (currentDepth < nodesInPath) {
            ArrayList<Vertex<Integer>> neighbors =
              new ArrayList<>(vertex.getNeighbors());
            Collections.sort(neighbors);
            int i = 0;
            done = false;
            while (i < neighbors.size() && !done) {
                if (neighbors.get(i).color == VertexColor.WHITE) {
                    done = knightTour(currentDepth + 1, path, neighbors.get(i), nodesInPath);
                }
                i = i + 1;
            }
            if (!done) { // prepare to backtrack
                path.remove(path.size() - 1);
                vertex.setColor(VertexColor.WHITE);
            }
        } else {
            done = true;
        }
        return done;
        
    }
    
    public static void main(String[] args) {
        Graph<Integer> knightGraph = makeKnightGraph(5);
        System.out.println(knightGraph.getVertices().size());
        ArrayList<Vertex<Integer>> path = new ArrayList<>();
        knightTour(0, path, knightGraph.getVertex(0), 25);
        System.out.println(path);
    }

}

    
/*
def knight_tour(n, path, u, limit):
    u.color = "gray"
    path.append(u)
    if n < limit:
        neighbors = sorted(list(u.get_neighbors()))
        i = 0
        done = False
        while i < len(neighbors) and not done:
            if neighbors[i].color == "white":
                done = knight_tour(n + 1, path, neighbors[i], limit)
            i = i + 1
        if not done:  # prepare to backtrack
            path.pop()
            u.color = "white"
    else:
        done = True
    return done
    
*/
