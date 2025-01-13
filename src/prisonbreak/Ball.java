package prisonbreak;
import java.awt.*;
import javax.swing.*;
/**
@author Carson Lam
@version 1.1.0
 */
public class Ball extends GameObject {

    //Fields
    private int dx = 4;
    private int dy = 4;

    private int accel = 1;

    private ImageIcon ballImage;

    private boolean paused = false;

    //Constructors
    public Ball(int x, int y, int size) {
        setX(x);
        setY(y);
        setSize(size, size);
    }

    //Paint ball
    public void paint(Graphics g) {
        c = new Color(0,0,0,0);
        g.setColor(c);
        g.fillRoundRect(0,0,getWidth(),getHeight(),getHeight(),getHeight());
    }

    //Methods
    /***
     * getter method for dx
     * @return dy, the vertical movement of the ball
     */
    public int getDx() {
        return dx;
    }

    /***
     * getter method for dy
     * @return dy, the vertical movement of the ball
     */
    public int getDy() {
        return dy;
    }

    /***
     * setter method for dx
     * @param newSpeed the new desired horizontal speed of the ball
     */
    public void setDx(int newSpeed) {
        dx = newSpeed;
    }

    /***
     * setter method for dy
     * @param newSpeed the new desired horizontal speed of the ball
     */
    public void setDy(int newSpeed) {
        dy =  newSpeed;
    }

    /***
     * Sets ball to a paused state
     * Paused state prevents ball from moving
     * @param newState the new desired state of ball
     */
    public void setBallPaused(boolean newState) {
        paused = newState;
    }

    /***
     * Act method repeats every so often, moving the ball by incrementing d values
     * Only moves ball if not paused
     */
    public void act() {
        if (!paused) {
            setX(getX() + dx);
            setY(getY() + dy);
        }
    }

    /***
     * Bouncing method for ball's dy value, inverts dy
     */
    public void bounceY() {
        dy = -dy;
    }

    /***
     * Bouncing method for ball's dx value, inverts dx
     */
    public void bounceX(){
        dx = -dx;
    }

    //

    /***
     * Accelerate method is used to affect ball speed after new level
     * Checks ball's current dx and dy to increment correctly
     */
    public void accelerate() {
        if (dx < 0) {
            dx -= accel;
        } else if (dx > 0) {
            dx += accel;
        }
        if (dy < 0) {
            dy -= accel;
        } else if (dy > 0) {
            dy += accel;
        }
    }

    /***
     * Method to instantly adjust the dy of the ball
     * Used so that the ball always starts going down
     */
    public void justifyDirection() {
        if (dy < 0) {
            dy = -dy;
        }
    }

    /***
     * getter method for current acceleration of ball
     * @return accel, the acceleration of ball
     */
    public int getAccel() {
        return accel;
    }
}

