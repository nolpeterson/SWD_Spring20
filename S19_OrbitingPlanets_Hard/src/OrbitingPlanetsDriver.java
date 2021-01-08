import javax.swing.*;

public class OrbitingPlanetsDriver {
    public static void main(String[] args) {
        OrbitingPlanets orbital = new OrbitingPlanets();
        orbital.setSize(600, 600);
        orbital.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        orbital.setResizable(false);
        orbital.setVisible(true);
    }
}
