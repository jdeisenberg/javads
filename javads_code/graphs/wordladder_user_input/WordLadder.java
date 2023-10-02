import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WordLadder {
    
    public Graph<String> buildGraph(String fileName) {
        Graph<String> wordGraph = new Graph<String>();
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
                    
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return wordGraph;
    }
    
    public static void traverse(Vertex<String> start) {
        Vertex<String> current = start;
        while (current != null) {
            System.out.println(current.key);
            current = current.previous;
        }
    }

    public static void clearSearch(Graph<String> graph) {
        for (String s: graph.getVertexKeys()) {
            Vertex<String> v = graph.getVertex(s);
            v.setColor(VertexColor.WHITE);
        }
    }
    
    public static void main(String[] args) {
        WordLadder ladder = new WordLadder();
        Graph<String> wordGraph = ladder.buildGraph("wordlist.txt");
        Scanner keyboard = new Scanner(System.in);
        
        boolean finished = false;
        while (!finished) {
            System.out.print("Enter start word (or press ENTER to quit): ");
            String startWord = keyboard.nextLine().trim().toLowerCase();
            if (!startWord.equals("")) {
                if (wordGraph.getVertex(startWord) != null) {
                
                    System.out.print("Enter end word: ");
                    String endWord = keyboard.nextLine().trim().toLowerCase();
                    if (wordGraph.getVertex(endWord) != null) {
                        /*
                         * Because traverse uses the previous reference,
                         * we reverse end and start words here.
                         */
                        clearSearch(wordGraph);
                        wordGraph.bfs(wordGraph.getVertex(endWord));
                        traverse(wordGraph.getVertex(startWord));
                    } else {
                        System.out.printf("\"%s\" is not in the word list.%n",
                            endWord);
                    }
                } else {
                    System.out.printf("\"%s\" is not in the word list.%n",
                        startWord);
                }
            } else {
                finished = true;
            }
        }
        keyboard.close();
    }
}
