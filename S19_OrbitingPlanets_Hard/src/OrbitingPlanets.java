import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OrbitingPlanets extends JFrame implements Runnable{
    ExecutorService executorService = Executors.newCachedThreadPool();
    private static ArrayList<Planet> planetList = new ArrayList<>();
    private static Planet myPlanet;
    private final int NUMPLANETS = 8;
    private JPanel panel;
    private JLabel instructions;
    MouseListener mouseListener = new MouseListener();

    public OrbitingPlanets() {
        super("Orbiting Planets");
        instructions = new JLabel("Click the mouse to add a planet");
        panel = new JPanel();
        panel.add(instructions);
        add(panel);
        panel.addMouseListener(mouseListener);

        //Add a test planet
        myPlanet = new Planet();
        planetList.add(myPlanet);

//        executorService.execute();
//        executorService.shutdown();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Planet myCircle: planetList) {
            g.setColor(myCircle.getRandColor());
            g.fillOval(250, 200, 100, 100);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.currentThread().sleep(100);
                for (Planet myPlanet: planetList) {
                    myPlanet.move(myPlanet.getSpeed());
                }
                repaint();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public class MouseListener implements java.awt.event.MouseListener {
        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
                if (planetList.size() < 8) {
                    myPlanet = new Planet();
                    planetList.add(myPlanet);
                }
            }
            else if (mouseEvent.getButton() == MouseEvent.BUTTON3) {
                if (planetList.size() < 8) {
                    myPlanet = new Planet();
                    planetList.add(myPlanet);
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }
}
