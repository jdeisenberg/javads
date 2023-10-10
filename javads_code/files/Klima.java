import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Klima {

    public static void main(String[] args) {        
        File f = new File("klima.txt");
        try {
            Scanner input = new Scanner(f);
            double max = -1000.0;
            double min = 1000.0;
            while (input.hasNextLine()) {
                String oneLine = input.nextLine();
                String[] items = oneLine.split(";");
                if (items.length == 4) {
                    try {
                        double dayMax = Double.parseDouble(items[2]);
                        double dayMin = Double.parseDouble(items[3]);
                        if (dayMax > max) {
                            max = dayMax;
                        }
                        if (dayMin < min) {
                            min = dayMin;
                        }
                    }
                    catch (NumberFormatException ex) {
                        System.out.println("Ignoring non-numeric data "
                            + ex.getMessage());
                    }
                }
            }
            System.out.printf("Max temperature: %.1f\u00b0C\n", max);
            System.out.printf("Min temperature: %.1f\u00b0C\n", min); 
            input.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println("Can't find file klima.txt");
        }
    }
}
