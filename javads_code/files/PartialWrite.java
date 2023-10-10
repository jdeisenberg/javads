/**
 * Write data to a file without closing it;
 * put the close() method call in a comment
 * so that it can be uncommented to try the program
 * with a correct close() call.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PartialWrite {

    public static void main(String[] args) {        
        File f = new File("write_test.txt");
        try {
            PrintWriter output = new PrintWriter(f);
            output.println("Example of writing to a file.");
            output.close(); // uncomment this line 
        }
        catch (FileNotFoundException ex) {
            System.out.println("Can't open file write_test.txt");
        }
    }
}
