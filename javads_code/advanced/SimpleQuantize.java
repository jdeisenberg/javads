import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SimpleQuantize {

    public static void simpleQuant(BufferedImage img) {
        int w = img.getWidth();
        int h = img.getHeight();
        
        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w; col++) {
                int argb = img.getRGB(col,row);
                int r = (argb >> 16) & 0xff;
                int g = (argb >> 8) & 0xff;
                int b = argb & 0xff;
                r = r / 36 * 36;
                g = g / 42 * 42;
                b = b / 42 * 42;
                img.setRGB(col, row, (r << 16 | g << 8 | b));
            }
        }
    }
 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String filename = "";
        do {
            System.out.print("File name: ");
            filename = input.nextLine();
            if (!filename.equals("")) {
                JFrame f = new JFrame("Simple Quantize");
                     
                f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                ImageComponent img = new ImageComponent(filename);
                simpleQuant(img.getImage());
                f.add(img);
                f.pack();
                f.setVisible(true);
                String newFile = "sq_" + filename;
                try {
                    ImageIO.write(img.getImage(), "JPG", new File(newFile));
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } while (!filename.equals(""));
    }
    
}
