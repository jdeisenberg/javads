/*
 * Given a file of key terms for a chapter,
 * create a PreTeXt table with three items per row.
 */
import java.util.Scanner;
import java.io.File;

public class KeyTerms {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java KeyTerms inputfile");
        } else {
            String fileName = args[0];
            try {
                Scanner inFile = new Scanner(new File(fileName));
                System.out.println("""
  <table>
    <tabular>
      <row>""");
                int nItems = 0;
                while (inFile.hasNextLine()) {
                    String str = inFile.nextLine();
                    System.out.println("      <cell>" + str + "</cell>");
                    nItems++;
                    if (nItems == 3) {
                        System.out.println("    </row>");
                        System.out.println("    <row>");
                        nItems = 0;
                    }
                }
                
                if (nItems != 0) {
                    for (int n = nItems; n < 3; n++) {
                        System.out.println("      <cell></cell>");
                    }
                }
                System.out.println("""
      </row>
    </tabular>
</table>""");

                inFile.close();
            }
            catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
}

