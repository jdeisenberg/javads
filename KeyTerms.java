/*
 * Given a file of key terms for a chapter,
 * create a PreTeXt table with three items per row.
 */
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class KeyTerms {
    public static void main(String[] args) {
		int nColumns = 3;
        if (args.length < 1 || args.length > 2) {
            System.out.println("Usage: java KeyTerms inputfile nColumns");
        } else {
            String fileName = args[0];
			if (args.length == 2) {
				nColumns = Integer.parseInt(args[1]);
			}
            ArrayList<String> terms = new ArrayList<>();
            try {
                Scanner inFile = new Scanner(new File(fileName));
                while (inFile.hasNextLine()) {
                    terms.add(inFile.nextLine());
                }
                inFile.close();
            }
            catch (Exception ex) {
               System.out.println(ex);
            }

                
            System.out.println("""
  <table>
    <tabular>""");
            int nRows = (terms.size() + nColumns -1) / nColumns;
            System.err.println("n rows: " + nRows);
            for (int row = 0; row  < nRows; row++) {
                System.out.println("    <row>");
                for (int col = 0; col < nColumns; col++) {
                    int itemNumber = col * nRows + row;
                    String str = "";
                    if (itemNumber < terms.size()) {
                        str = terms.get(itemNumber);
                    }
                    System.out.println("      <cell>" + str + "</cell>");
                }
                System.out.println("    </row>");
            }
            System.out.println("""
    </tabular>
</table>""");

        }
    }
}

