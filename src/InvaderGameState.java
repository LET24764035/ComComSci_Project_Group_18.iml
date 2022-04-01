import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

//InvaderGameState is the class where the game-board and game is coded.
//Classes of the shooter, enemy and missile is being called in this class.
public class InvaderGameState extends JPanel implements Runnable, MouseListener {

    boolean ingame = true;
    private Dimension d;                                    //an instance of dimension to create the board.
    int BOARD_WIDTH = 1200;                                 //the width of the game display board.
    int BOARD_HEIGHT = 760;                                 //the height of the game display board.
    int x = 0;
    BufferedImage img;
    String message = "Score:";
    private Thread animator;
    Shooter s;                                       //declare the use of the class.'s' represents the shooter


    public InvaderGameState() {

        addKeyListener(new TAdapter());
        addMouseListener(this);
        setFocusable(true);
        d = new Dimension(BOARD_WIDTH, BOARD_HEIGHT);     //calling dimension to display it
        setBackground(Color.black);                       //background of window

        s = new Shooter(BOARD_WIDTH / 2, BOARD_HEIGHT - 100, 10);   //shooter is being initialise and positioned



           /*
             try {
                img = ImageIO.read(this.getClass().getResource("mount.jpg"));
            } catch (IOException e) {
                 System.out.println("Image could not be read");
            // System.exit(1);
            }
            */
        if (animator == null || !ingame) {
            animator = new Thread(this);
            animator.start();
        }


        setDoubleBuffered(true);
    }

    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.white);                            //background of the game being a white rectangle at the moment
        g.fillRect(0, 0, d.width, d.height);                //position of the rectangle (background)

        g.setColor(Color.yellow);                           //shape and colour of the player/shooter
        g.fillOval(s.x, s.y, 100, 100);                     //'s' is the shooter. Position and size of shooter.

        //still need to limit the shooter to not go of screen.

        //activates the action of movement of the shooter.
        if (s.moveRight == true)
            s.x += s.speed;

        if (s.moveLeft == true)
            s.x -= s.speed;

        Font small = new Font("Helvetica", Font.BOLD, 50);  //creates a font with size
        FontMetrics metr = this.getFontMetrics(small);      //return specific parameters for particular Font odject.
        g.setColor(Color.black);
        g.setFont(small);                                   //calls the font
        g.drawString(message, 10, d.height - 710);          //calls and positions message that wil,be displayed.
        //still need to add fuction to count scores


        if (ingame) {


            //g.drawImage(img, 0, 0, 200, 200, null);


        }
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    private class TAdapter extends KeyAdapter {

        //when keys are being released, the action should not occur.
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            s.moveRight = false;
            s.moveLeft = false;

        }

        //when key is pressed, an action should occur.
        public void keyPressed(KeyEvent e) {

//System.out.println( e.getKeyCode());
            // message = "Key Pressed: " + e.getKeyCode();
            int key = e.getKeyCode();
            if (key == 39) {                                  //the key number represents the right arrow on keyboard
                s.moveRight = true;
            }

            if (key == 37) {                                  //the key number represents the left arrow on keyboard
                s.moveLeft = true;
            }
        }

    }


    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseClicked(MouseEvent e) {

    }

    public void run() {

        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();
        int animationDelay = 50;                            //speed of which the shooter moves left and right.
        long time =
                System.currentTimeMillis();
        while (true) {//infinite loop
            // spriteManager.update();
            repaint();
            try {
                time += animationDelay;
                Thread.sleep(Math.max(0, time -
                        System.currentTimeMillis()));
            } catch (InterruptedException e) {
                System.out.println(e);
            }//end catch
        }//end while loop


    }//end of run

}//end of class

