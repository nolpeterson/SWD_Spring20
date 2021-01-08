import javax.swing.*;
import java.awt.*;

/**
 * Rectangle - Create a rectangle object of set size, and user-defined Color.
 */
public class Rectangle extends JPanel {
    /**
     * The color to generate.
     */
    private Color myColor;

    /**
     * Rectangle - Constructor for making a rectangle of Color myColor.
     * @param red the red component of myColor.
     * @param blue the blue component of myColor.
     * @param green the green component of myColor.
     */
    Rectangle(int red, int blue, int green){
        setColor(red, blue, green);
    }

    /**
     * paintComponent - generates a filled Rectangle of Color myColor.
     * @param g a Graphics object that allows the Rectangle to be drawn.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setSize(500,500);
        g.setColor(getRectColor());
        g.fillRect(0, 0, 500, 500);
    }

    /**
     * setColor - sets the Color of rectangle that is passed by constructor.
     * @param red the red component of myColor.
     * @param green the green component of myColor.
     * @param blue the blue component of myColor.
     */
    public void setColor(int red, int green, int blue) {
        this.myColor =  new Color(red, green, blue);
    }

    /**
     * getRectangle - returns the Color of the rectangle object.
     * @return myColor, the Color of the Rectangle object.
     */
    public Color getRectColor() {
        return myColor;
    }
}
