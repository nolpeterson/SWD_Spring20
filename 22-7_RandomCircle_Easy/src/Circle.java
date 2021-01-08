import javax.swing.*;
import java.awt.*;

/**
 * Circle - Creates a circle of a random radius, and calculates attributes about the circle.
 */
public class Circle extends JPanel {
    /**
     * The Radius of the Circle.
     */
    private int radius;
    /**
     * The Diameter of the Circle.
     */
    private int diameter;
    /**
     * The Area of the Circle.
     */
    private double area;
    /**
     * The Circumference of the Circle.
     */
    private double circumference;

    /**
     * Constructor - Creates a new Circle and sets all information about it.
     */
    Circle(){
        setRadius();
        setArea();
        setDiameter();
        setCircumference();
    }

    /**
     * paintComponent - generates a black filled Circle of random size..
     * @param g a Graphics object that allows the Circle to be drawn.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setSize(500,400);
        g.setColor(Color.RED);
        g.fillOval(250-getRadius(), 200-getRadius(), getRadius()*2, getRadius()*2);
    }

    /**
     * setRadius - generates a random radius from size 1 to 100 using the Math.random function.
     */
    public void setRadius(){
        radius = (int)(Math.random() * ((100 - 1) + 1)) + 1;
    }

    /**
     * Gets radius.
     * @return radius of circle.
     */
    public int getRadius() {
        return radius;
    }

    /**
     * setDiameter - calculates the diameter of the Circle using 2r.
     */
    public void setDiameter() {
        diameter = 2*radius;
    }

    /**
     * Gets diameter.
     * @return the diameter of the Circle.
     */
    public int getDiameter() {
        return diameter;
    }

    /**
     * setArea - calculates the area of the Circle using PIr^2.
     */
    public void setArea() {
        area = Math.PI * radius * radius;
    }

    /**
     * Gets area.
     * @return the area of the Circle.
     */
    public double getArea() {
        return area;
    }

    /**
     * setCircumference - calculates the circumference the Circle using 2PIr.
     */
    public void setCircumference() {
        circumference = 2 * Math.PI * radius;
    }

    /**
     * Gets circumference.
     * @return the circumference of the Circle.
     */
    public double getCircumference() {
        return circumference;
    }
}
