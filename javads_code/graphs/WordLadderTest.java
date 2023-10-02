import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WordLadderTest {
    
    public Graph<String> buildGraph(String fileName) {
        Graph<String> wordGraph = new Graph<>();
        HashMap<String, Set<String>> buckets = new HashMap<>();
        
        File inFile = new File(fileName);
        System.out.println("Building graph...");
        try (Scanner input = new Scanner(inFile);) {
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String word = line.trim();
                for (int i = 0; i < word.length(); i++) {
                    String bucket = word.substring(0, i) + "_" +
                        word.substring(i + 1);
                    if (!buckets.containsKey(bucket)) {
                        buckets.put(bucket, new HashSet<String>());
                    }
                    buckets.get(bucket).add(word);
                }
            }
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
            
        int nEdges = 0;
        for (Set<String> similarWords: buckets.values()) {
            if (similarWords.size() > 1) {
                for (String word1: similarWords) {
                    for (String word2: similarWords) {
                        if (!word1.equals(word2)) {
                            wordGraph.addEdge(word1, word2);
                        }
                        nEdges++;
                    }
                }
            }
        }
        System.out.println("# of buckets: " + buckets.size());
        System.out.println("# of edges: " + nEdges);

        return wordGraph;
    }
    
    public static void traverse(Vertex<String> start) {
        Vertex<String> current = start;
        while (current != null) {
            System.out.println(current.key);
            current = current.previous;
        }
    }

    public static void main(String[] args) {
        WordLadderTest ladder = new WordLadderTest();
        Graph<String> wordGraph = ladder.buildGraph("wordlist.txt");
        
        /*
         * Because traverse uses the previous reference,
         * we reverse end and start words here.
         */
        String startWord = "fool";
        String endWord = "sage";
        wordGraph.bfs(wordGraph.getVertex(endWord));
        traverse(wordGraph.getVertex(startWord));
    }
}
