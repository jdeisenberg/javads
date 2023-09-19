import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * A world for turtles to play inside of.
 * Usage example:
 * <pre>
 * World basic = new World();
 * World fancy = new World(640, 480, Color.YELLOW);
 * 
 * Turtle t1 = new Turtle(basic);
 * Turtle t2 = new Turtle(fancy);
 * 
 * t1.forward(100);
 * basic.erase();
 * t1.turnLeft(90);
 * t1.forward(100);
 * 
 * t2.forward(100);
 * t2.turnLeft(90);
 * t2.forward(100);
 * 
 * basic.saveAs("basicWorld.png");
 * fancy.saveAs("fancyWorld.png");
 * </pre>
 * 
 * 
 * @author Luther Tychonievich. Released to the public domain.
 */
public class World extends JFrame {
	/// version number based on date of creation
	private static final long serialVersionUID = 20130902L; 
	
	private BufferedImage overlay, ground, back, front;
	private Graphics2D og, gg, bg, fg;
	
	private ArrayList<Turtle> turtles;
    
    private int width;
    private int height;
    
    private double lowerLeftX;
    private double lowerLeftY;
    private double upperRightX;
    private double upperRightY;
    
    // these variables determine how to scale and offset
    // coordinates from the coordinate system to the screen
    private double scaleX;
    private double offsetX;
    private double scaleY;
    private double offsetY;
    
    private boolean updating;

	
	/**
	 * Creates a new World for Turtles to play in.
	 */
	public World() {
		this(600, 600);
	}
    
	public World(int width, int height) {
		this(width, height, Color.WHITE, -width / 2, -height / 2,
            width / 2, height / 2);
	}
    
	public World(int width, int height, Color backgroundColor,
     double lowerLeftX, double lowerLeftY, double upperRightX, double upperRightY) {
		super("Turtle World");
        this.width = width;
        this.height = height;
        this.setWorldCoordinates(lowerLeftX, lowerLeftY, upperRightX, upperRightY);
        
		this.overlay = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		this.ground = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		this.back =  new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		this.front = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		
		this.og = (Graphics2D)this.overlay.getGraphics();
		this.gg = (Graphics2D)this.ground.getGraphics();
		this.bg = (Graphics2D)this.back.getGraphics();
		this.fg = (Graphics2D)this.front.getGraphics();
		og.setBackground(new Color(0,0,0,0));
		gg.setBackground(backgroundColor);
		
		Graphics2D[] gs = {og, gg};
		for (Graphics2D g : gs) {
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
			g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
			g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
		}

		this.setContentPane(new JLabel(new ImageIcon(this.front)));
		this.pack();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.addKeyListener(new java.awt.event.KeyListener() {
			@Override public void keyPressed(KeyEvent arg0) { }
			@Override public void keyReleased(KeyEvent arg0) { }
			@Override public void keyTyped(KeyEvent arg0) { World.this.dispose(); }
		});

        this.updating = true;
		this.clearOverlay();
		this.erase();

		this.repaint();
		this.setVisible(true);
		
		this.turtles = new ArrayList<Turtle>();
	}
	
	/**
	 * Erases all existing paths
	 */
	public void erase() {
		this.gg.clearRect(0, 0, this.ground.getWidth(), this.ground.getHeight());
	}
    
	/**
	 * Erases all existing paths
	 */
	private void clearOverlay() {
		this.og.clearRect(0, 0, this.overlay.getWidth(), this.overlay.getHeight());
	}
	
	
	/**
	 * Should only be called by the Turtle class constructor 
	 */
	void addTurtle(Turtle t) {
		this.turtles.add(t);
		this.turtleMoved();
	}
    
	/**
	 * Should only be called by Turtle class methods 
	 */
	void drawLine(Point2D p1, Point2D p2, double width, Color color) {
		// draw the line
		this.gg.setColor(color);
		this.gg.setStroke(new BasicStroke((float)width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		Line2D.Double line = new Line2D.Double(p1, p2);
		this.gg.draw(line);

		// show the drawn lines
		if (this.updating) {
            this.blit();
        }
	}
	
    void fill(Path2D path, Color c) {
        Color saveColor = this.gg.getColor();
        this.gg.setColor(c);
        this.gg.fill(path);
        this.gg.setColor(saveColor);
        if (this.updating) {
            this.blit();
        }
    }
    
	private void blit() {
		this.bg.drawImage(this.ground,0,0, null);
		this.bg.drawImage(this.overlay, 0,0, null);
		this.fg.drawImage(this.back, 0,0, this);
		this.repaint();
	}
	
	/**
	 * Should only be called by Turtle class methods 
	 */
	void drawLine(Point2D p1, double nx, double ny, double width, Color color) {
		this.drawLine(p1, new Point2D.Double(nx,ny), width, color);
	}
    

	/**
	 * Should only be called by Turtle class methods 
	 */
	void turtleMoved() {
		// show the drawn lines
		this.clearOverlay();
		// add the turtles over top
		for(Turtle t : this.turtles) {
            if (t.isVisible()) {
                t._how_world_draw_turtles(this.og);
            }
		}
		// force the OS to show what's shown
		if (updating) {
            this.blit();
        }
	}
	
	/**
	 * Saves the current image to the specified file
	 * 
	 * @param filename The name of the file to write
	 * @throws IllegalArgumentException if any parameter is null or if the filename is not an image filename
	 */
	public void saveAs(String filename) {
		try {
			int dot = filename.lastIndexOf('.');
			if (dot < 0 || dot == filename.length()-1) {
				throw new IllegalArgumentException("The filename must end in a valid image extension, like .png or .jpg");
			}
			String ext = filename.substring(dot+1).toLowerCase();
			File f = new File(filename);
			ImageIO.write(this.front, ext, f);
		} catch(Throwable t) {
			System.err.println("Error saving file: " + t.getMessage());
		}
	}
	
	/**
	 * To be used by Turtle class only
	 * @param img the Image to draw
	 * @param placement the Affine Transform to use in drawing it 
	 */
	void drawImage(Image img, AffineTransform placement) {
		this.gg.drawImage(img, placement, this);
		if (updating) {
            this.blit();
        }
	}
    
    /**
     *  Set the lower left and upper right coordinates to use
     * as the system of coordinates for the turtle.
     * @param lowerLeftX the x-coordinate of the lower left of the world
     * @param lowerLeftY the y-coordinate of the lower left of the world
     * @param upperRightX the x-coordinate of the upper right of the world
     * @param upperRightY the y-coordinate of the upper right of the world
     */
    void setWorldCoordinates(double lowerLeftX, double lowerLeftY,
        double upperRightX, double upperRightY) {
        System.err.printf(
           "set world coords: %d x %d:  (%.1f, %.1f) to (%.1f, %.1f).%n",
            width, height, lowerLeftX, lowerLeftY, upperRightX, upperRightY);
            
        this.lowerLeftX = lowerLeftX;
        this.lowerLeftY = lowerLeftY;
        this.upperRightX = upperRightX;
        this.upperRightY = upperRightY;
        
        this.scaleX = (double) this.width / (upperRightX - lowerLeftX);
        this.offsetX = -this.scaleX * lowerLeftX;
        
        this.scaleY = (double) this.height / (lowerLeftY - upperRightY);
        this.offsetY = -this.scaleY * upperRightY;
        System.err.printf("Scale factor: %.3fx + %.3f, %.3fy + %.3f%n",
            this.scaleX, this.offsetX, this.scaleY, this.offsetY);
    }
    
    double getScaleX() {
        return this.scaleX;
    }
    
    double getOffsetX() {
        return this.offsetX;
    }
    
    double getScaleY() {
        return this.scaleY;
    }
    
    double getOffsetY() {
        return this.offsetY;
    }
    
    /**
     * Should we update every time a line is drawn?
     * If yes, then do a blit to force a repaint.
     * @param status true to update, false otherwise
     */
    void setUpdating(boolean updating) {
        this.updating = updating;
        if (updating) {
            this.blit();
        }
    }
    
    /**
     * Determine whether updating or not
     * @return updating status; true if yes, false if no
     */
    boolean getUpdating() {
        return this.updating;
    }
    
}
