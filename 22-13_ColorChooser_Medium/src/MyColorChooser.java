import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

/**
 * MyColorChooser - Creates a JFrame that holds 2 JPanels, one containing JSliders, JTextFields, and JLabels, and another containing a Rectangle object.
 */
public class MyColorChooser extends JPanel {
    /**
     * red - the red value of the Color shown.
     */
    private int red = 255;
    /**
     * blue - the blue value of the Color shown.
     */
    private int blue = 255;
    /**
     * green - the green value of the Color shown.
     */
    private int green = 255;
    /**
     * redSlider - the Red slider.
     */
    private JSlider redSlider = new JSlider(0, 255, red);
    /**
     * redTextField - the Red text area.
     */
    private JTextField redTextField = new JTextField("" + redSlider.getValue());
    /**
     * redLabel - the Red value label.
     */
    private JLabel redLabel = new JLabel(" Red Value");
    /**
     * greenSlider - the Green value slider.
     */
    private JSlider greenSlider = new JSlider(0, 255, blue);
    /**
     * greenTextField - the Green text area.
     */
    private JTextField greenTextField = new JTextField("" + greenSlider.getValue());
    /**
     * greenLabel - the Green value label.
     */
    private JLabel greenLabel = new JLabel(" Green Value");
    /**
     * blueSlider - the Blue slider.
     */
    private JSlider blueSlider = new JSlider(0, 255, green);
    /**
     * blueTextField - the Blue text area.
     */
    private JTextField blueTextField = new JTextField("" + blueSlider.getValue());
    /**
     * blueLabel - the Blue value label.
     */
    private JLabel blueLabel = new JLabel(" Blue Value");
    /**
     * frame - JFrame that holds the rectangle JPanel and ColorChooser JPanel.
     */
    JFrame frame = new JFrame("Color Chooser");
    /**
     * myRect - the rectangle object.
     */
    private Rectangle myRect = new Rectangle(red, blue, green);
    /**
     * sliderList - Listener for any changes made to a JSlider.
     */
    private ChangeListener slideList = new SliderListener();
    /**
     * textListener - Listener for any changes made to a JTextField.
     */
    private TextFieldListener textListener = new TextFieldListener();

    /**
     * Constructor - Creates a new MyColoChooser JFrame and JPanel.
     */
    public MyColorChooser()
    {
        //Set all attributes for main JFrame.
        frame.setSize(500, 675);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);

        //Set all attributes for red value JSlider and JTextField.
        setAttributes(redSlider, redTextField);

        //Set all attributes for green value JSlider and JTextField.
        setAttributes(greenSlider, greenTextField);

        //Set all attributes for blue value JSlider and JTextField.
        setAttributes(blueSlider, blueTextField);

        //Add Rectangle to JFrame.
        frame.add(myRect, BorderLayout.NORTH);

        //Add JSliders, JTextFields and JLabels to JFrame.
        JPanel centeringLayout = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JPanel colorChooser = new JPanel();
        colorChooser.setLayout(new GridLayout(3,3));
        colorChooser.add(redSlider);
        colorChooser.add(redTextField);
        colorChooser.add(redLabel);
        colorChooser.add(greenSlider);
        colorChooser.add(greenTextField);
        colorChooser.add(greenLabel);
        colorChooser.add(blueSlider);
        colorChooser.add(blueTextField);
        colorChooser.add(blueLabel);
        centeringLayout.add(colorChooser);
        frame.add(centeringLayout, BorderLayout.SOUTH);

        //Set frame as visible.
        frame.setVisible(true);
    }

    /**
     * setAttributes - Set attributes for JFrame and JSlider, JTextField, and JLabel of each color.
     * @param slider JSlider to have attributes set.
     * @param textField JTextArea to have attributes set.
     */
    private void setAttributes(JSlider slider, JTextField textField) {
        slider.addChangeListener(slideList);
        slider.setPaintTrack(true);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(51);
        slider.setMinorTickSpacing(5);
        textField.addActionListener(textListener);
        textField.setHorizontalAlignment(JTextField.CENTER);
    }

    /**
     * SliderListener - detects any changes made to a red, green, or blue JSlider, then applies the changed value
     * to the corresponding JTextField. Then calls setColor() on the Rectangle and updates the current color.
     * Lastly, calls repaint() to update the shown Color on the Rectangle.
     */
    private class SliderListener implements ChangeListener {
        /**
         * stateChanged - detects when the state of a JSlider has changed, then set the Color value, and set the
         * JTextField value to the JSlider value.
         * @param event - detects if an event happens in the program.
         */
        public void stateChanged(ChangeEvent event) {
            if (event.getSource() == redSlider) {
                red = ((JSlider)event.getSource()).getValue();
                redTextField.setText(Integer.toString(red));
            } else if (event.getSource() == greenSlider) {
                green = ((JSlider)event.getSource()).getValue();
                greenTextField.setText(Integer.toString(green));
            } else if (event.getSource() == blueSlider) {
                blue = ((JSlider) event.getSource()).getValue();
                blueTextField.setText(Integer.toString(blue));
            }
            myRect.setColor(redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue());
            myRect.repaint();
        }
    }

    /**
     * TextFieldListener - detects any changes made to a red, green, or blue JTextField, then applies the changed value
     * to the corresponding JSlider. Then calls setColor() on the Rectangle and updates the current color.
     * Lastly, calls repaint() to update the shown Color on the Rectangle.
     */
    private class TextFieldListener implements ActionListener {
        /**
         * actionPerformed - detects if an action in a JTextField has happened, then set the Color value, and set the
         * JSlider value to the JTextField value. The ActionEvent will most likely be an enter key press.
         * @param event - detects if an event happens in the program.
         */
        @Override
        public void actionPerformed(ActionEvent event) {
            // check which text field has input
            if (event.getSource() == redTextField) {
                red = Integer.parseInt(((JTextField)event.getSource()).getText());
                redSlider.setValue(red);
            } else if (event.getSource() == greenTextField) {
                green = Integer.parseInt(((JTextField)event.getSource()).getText());
                greenSlider.setValue(green);
            } else if (event.getSource() == blueTextField) {
                blue = Integer.parseInt(((JTextField)event.getSource()).getText());
                blueSlider.setValue(blue);
            }
            myRect.setColor(redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue());
            myRect.repaint();
        }
    }
}
