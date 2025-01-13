package prisonbreak;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 @author Carson Lam
 @version 1.1.0
 */
public abstract class Game extends JFrame {
    private boolean _isSetup = false;
    private boolean _initialized = false;
    private ArrayList _ObjectList = new ArrayList();
    private Timer _t;
    private boolean p1Left = false;
    private boolean p1Right = false;
    private boolean p2Left = false;
    private boolean p2Right = false;

    public boolean ZKeyPressed() {
        return this.p1Left;
    }
    public boolean XKeyPressed() {
        return this.p1Right;
    }

    /**
     * New Method --> Key detection changed to A and D
     * @return p2.left
     */
    public boolean AKeyPressed() {
        return this.p2Left;
    }

    public boolean DKeyPressed() {
        return this.p2Right;
    }

    public abstract void setup();

    public abstract void act();

    public void initComponents() {
        this.getContentPane().setBackground(Color.black);
        this.setup();

        for(int i = 0; i < this._ObjectList.size(); ++i) {
            GameObject o = (GameObject)this._ObjectList.get(i);
            o.repaint();
        }

        this._t.start();
    }

    public void add(GameObject o) {
        this._ObjectList.add(o);
        this.getContentPane().add(o);
    }

    public void remove(GameObject o) {
        this._ObjectList.remove(o);
        this.getContentPane().remove(o);
    }

    public void setDelay(int delay) {
        this._t.setDelay(delay);
    }

    //Debugged with https://stackoverflow.com/questions/42181035/intellij-idea-jar-doesnt-load-images-when-run-outside-of-ide
    public void setBackground(Color c) {
        setContentPane(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("BackgroundV2.png"))));
        this.getContentPane().setBackground(c);
    }

    public Game() {
        this.setSize(400, 400);
        this.getContentPane().setBackground(Color.black);
        this.getContentPane().setLayout((LayoutManager)null);
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenuItem menuFileExit = new JMenuItem("Exit");
        menuBar.add(menuFile);
        menuFile.add(menuFileExit);
        this.setJMenuBar(menuBar);
        this.setResizable(false);
        this.setTitle("Prison Break");
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        menuFileExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        this._t = new Timer(1, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Game.this.act();

                for(int i = 0; i < Game.this._ObjectList.size(); ++i) {
                    GameObject o = (GameObject)Game.this._ObjectList.get(i);
                    o.act();
                }

            }
        });
        this.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
                char pressed = Character.toUpperCase(e.getKeyChar());
                switch (pressed) {
                    case 'D':
                        Game.this.p2Right = true;
                        break;
                    case 'A':
                        Game.this.p2Left = true;
                        break;
                    case 'X':
                        Game.this.p1Right = true;
                        break;
                    case 'Z':
                        Game.this.p1Left = true;
                }

            }

            public void keyReleased(KeyEvent e) {
                char released = Character.toUpperCase(e.getKeyChar());
                switch (released) {
                    case 'D':
                        Game.this.p2Right = false;
                        break;
                    case 'A':
                        Game.this.p2Left = false;
                        break;
                    case 'X':
                        Game.this.p1Right = false;
                        break;
                    case 'Z':
                        Game.this.p1Left = false;
                }

            }
        });
    }

    public void startGame() {
        this._t.start();
    }

    public void stopGame() {
        this._t.stop();
    }

    public int getFieldWidth() {
        return this.getContentPane().getBounds().width;
    }

    public int getFieldHeight() {
        return this.getContentPane().getBounds().height;
    }

    /**
     * New Method for resetting paddle state
     */
    public void resetPaddle() {
        p2Left = false;
        p2Right = false;

    }

    class _WinDialog extends JDialog {
        JButton ok = new JButton("OK");

        _WinDialog(JFrame owner, String title) {
            super(owner, title);
            Rectangle r = owner.getBounds();
            this.setSize(200, 100);
            this.setLocation(r.x + r.width / 2 - 100, r.y + r.height / 2 - 50);
            this.getContentPane().add(this.ok);
            this.ok.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    _WinDialog.this.setVisible(false);
                }
            });
        }
    }
}
