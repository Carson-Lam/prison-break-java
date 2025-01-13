package prisonbreak;
import javax.swing.*;
import java.awt.*;
/**
 @author Carson Lam
 @version 1.1.0
 */
//Bricks is a GameObject
public class Bricks extends GameObject {
    private JLabel brickImage;

    // Constructor that accepts the image icon
    public Bricks(ImageIcon icon) {
        this.brickImage = new JLabel(icon);
    }

    // Getter method for the brick image
    public JLabel getBrickImage() {
        return brickImage;
    }

    @Override
    public void setLocation(int x, int y) {
        super.setLocation(x, y);  // Set GameObject location
        if (brickImage != null) {
            brickImage.setLocation(x, y);  // Sync JLabel location
        }
    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(width, height);  // Set GameObject size
        if (brickImage != null) {
            brickImage.setSize(width, height);  // Sync JLabel size
        }
    }

    /***
     * Override paint method for color
     * @param g  the <code>Graphics</code> context in which to paint
     */
    public void paint(Graphics g) {
        Rectangle r = this.getBounds();
        c = new Color(102,30,12,0);
        g.setColor(c);
        g.fillRect(0, 0, (int)r.getWidth(), (int)r.getHeight());
    }

    public void act() {

    }

}