public class Shooter extends DefaultCritter {

    boolean moveRight;
    boolean moveLeft;

    public Shooter(int x, int y, int s) {
        super(x, y, s);                         //reads values into super class (DefaultCritter)

        moveLeft = false;
        moveRight = false;
    }

}
