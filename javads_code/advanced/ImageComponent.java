import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

class ImageComponent extends JComponent {
    BufferedImage image;
    
    public ImageComponent(String filename) {
        try {
            this.image = ImageIO.read(new File(filename));
        } catch (IOException e) {
            System.out.println("Unable to open file.");
            this.image = new BufferedImage(400, 100,
                BufferedImage.TYPE_INT_ARGB);
        }
    }

    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, null);
    }

    public Dimension getPreferredSize() {
        if (image == null) {
             return new Dimension(100,100);
        } else {
           return new Dimension(image.getWidth(null),
            image.getHeight(null));
       }
    }
    
    public BufferedImage getImage() {
        return this.image;
    }
}
