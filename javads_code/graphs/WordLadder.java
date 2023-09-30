import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WordLadder {
    
    public Graph<String> buildGraph(String fileName) {
        Graph<String> wordGraph = null;
        HashMap<String, Set<String>> buckets = new HashMap<>();
        
        File inFile = new File(fileName);
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
            for (String s: buckets.keySet()) {
                System.out.println(s + ":" +  buckets.get(s));
            }
                    
        }
        catch (Exception ex) {
            System.out.println("Cannot open file " + fileName + ".");
        }
        return wordGraph;
    }
    
    public static void main(String[] args) {
        WordLadder ladder = new WordLadder();
        ladder.buildGraph("wordlist.txt");
    }
}
/*


    # add edges between different words in the same bucket
    for similar_words in buckets.values():
        for word1 in similar_words:
            for word2 in similar_words - {word1}:
                the_graph.add_edge(word1, word2)
    return the_graph
*/
