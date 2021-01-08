import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

/**
 * DrawCircle - Responsible for creating JFrame window, and outputting the Circle and information about the Circle.
 */
public class DrawCircle extends JFrame{
    /**
     * Constructor that runs the drawing aspects of the program.
     */
    public DrawCircle()
    {
        //Create frame titled "Random Circle"
        JFrame frame = new JFrame("Random Circle");
        frame.setSize(500, 500);

        //Create new Circle object
        Circle myCircle = new Circle();

        //Create a DecimalFormat for the area and circumference outputs
        DecimalFormat dec = new DecimalFormat("#0.00");

        //Create output text for info about circle
        JTextArea textArea = new JTextArea(0, 1);
        textArea.setEditable(false);
        textArea.setText( "Radius: " + myCircle.getRadius() + "\nDiameter: " + myCircle.getDiameter()
                + "\nArea: " + dec.format(myCircle.getArea()) + "\nCircumference: " + dec.format(myCircle.getCircumference()));

        //Output the circle and info
        frame.add(myCircle, BorderLayout.NORTH);
        frame.add(textArea, BorderLayout.SOUTH);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
