package prisonbreak;
/**
 @author Carson Lam
 @version 1.1.0
 */
public class Paddle extends GameObject {

    //Field setting up speed of paddle
    private int paddleSpeed = 8;

    //Field setting up paddle pausing
    //Set to false to allow paddle movement
    private boolean paused = false;
    public Paddle() {
    }

    public void act() {
    }

    /***
     * Getter method for paddle speed
     * @return returns speed of paddle
     */
    public int getPaddleSpeed() {
        return paddleSpeed;
    }



    /***
     * Setter method for paddle speed
     * Sets speed to new int parameter
     * @param newSpeedP new speed of paddle
     */
    public void setPaddleSpeed(int newSpeedP){
        paddleSpeed = newSpeedP;
    }

    //

    /***
     * Move left method, increments paddle left by paddle speed
     * Only executes if not in paused state
     */
    public void moveLeft() {
        if (!paused) {
            setX(getX() - paddleSpeed);
        }
    }

    //

    /***
     * Move right method, increments paddle right by paddle speed
     * Only executes if not in paused state
     */
    public void moveRight() {
        if (!paused) {
            setX(getX() + paddleSpeed);
        }
    }


    //

    /***
     * Setter method for paused state
     * Used to freeze paddle
     * @param newState the new state of the paddle - paused or unpaused
     */
    public void setPaddlePaused(boolean newState) {
        paused = newState;
    }
}
