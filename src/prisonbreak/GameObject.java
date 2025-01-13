package prisonbreak;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JComponent;

/**
 @author Carson Lam
 @version 1.1.0
 */
public abstract class GameObject extends JComponent {
    Color c;

    public GameObject() {
        c = Color.white;
    }

    public void setSize(int width, int height) {
        super.setSize(width, height);
    }

    public int getX() {
        return getLocation().x;
    }

    public int getY() {
        return getLocation().y;
    }

    public void setX(int x) {
        super.setLocation(x, getLocation().y);
    }

    public void setY(int y) {
        super.setLocation(getLocation().x, y);
    }


    public void paint(Graphics g) {

        Rectangle r = getBounds();
        c = new Color(0,0,0,0);
        g.setColor(c);
        g.fillRect(0, 0, (int)r.getWidth(), (int)r.getHeight());
    }

    public boolean collides(GameObject o) {
        return getBounds().intersects(o.getBounds());
    }

    public abstract void act();
}
