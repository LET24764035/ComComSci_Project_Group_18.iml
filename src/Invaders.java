import javax.swing.*;

//Invaders is the MAIN class of game and runs all classes within it.
//JFrame is the window on which the game-board and game will be displayed.
public class Invaders extends JFrame {

    public Invaders() {

        add(new InvaderGameState());                   //calling the game-board and game class.
        setTitle("ComSci Project Group 18");           //title of the window.
        setDefaultCloseOperation(EXIT_ON_CLOSE);       //exit the window by clicking the 'x'.
        setSize(1200, 800);                            //the size of the window (x,y). Aim to fill window screen.
        setLocationRelativeTo(null);                   //locates the window to the center of the screen.
        setVisible(true);                              //makes the window visible to the user.
        setResizable(false);                           //prevents the user to change size of window.
    }

    public static void main(String[] args) {
        new Invaders();
    }
}
