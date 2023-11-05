import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.util.Scanner;
import javax.imageio.ImageIO;
import java.io.File;

public class OctreeQuantize {

    public static void octreeQuant(BufferedImage img) {
        int w = img.getWidth();
        int h = img.getHeight();
        
        Octree ot = new Octree();
        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w; col++) {
                int argb = img.getRGB(col,row);
                int r = (argb >> 16) & 0xff;
                int g = (argb >> 8) & 0xff;
                int b = argb & 0xff;
                ot.insert(r, g, b);
            }
        }
        
        ot.reduce(256);
            
        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w; col++) {
                int argb = img.getRGB(col,row);
                int r = (argb >> 16) & 0xff;
                int g = (argb >> 8) & 0xff;
                int b = argb & 0xff;
                
                int[] newRgb = ot.find(r, g, b);
               
                img.setRGB(col, row, (newRgb[0] << 16 |
                    newRgb[1] << 8 | newRgb[2]));
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
                octreeQuant(img.getImage());
                f.add(img);
                f.pack();
                f.setVisible(true);
                String newFile = "ot_" + filename;
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
