import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Planet extends JPanel {
    private int xPosition;
    private int speed;
    private Color randColor;
    private Random rand;

    public Planet() {
        rand = new Random();
        randColor = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
    }

    public int getSpeed() {
        return speed;
    }

    public Color getRandColor() {
        return randColor;
    }

    public void move(int speed) {
        xPosition = xPosition + speed;
    }
}
