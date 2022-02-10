import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Test2 extends JFrame {

    private DrawingPanel drawingPanel = new DrawingPanel();


    public Test2() {
        this.setTitle("TestShape");
        this.setSize(400,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void init() {
        this.add(drawingPanel);
        this.setVisible(true);
    }

    class DrawingPanel extends JPanel implements MouseListener {
        private Color[] colourArr = {Color.RED, Color.GREEN, Color.BLUE};
        private int colourTracker = 0;

        private Rectangle2D rect = new Rectangle2D.Double(100,100,50,70);
        private Rectangle2D square = new Rectangle2D.Double(100,100,50,50);
        private Ellipse2D circle = new Ellipse2D.Double(100,100,50,50);
        private Shape[] shape = {rect, square, circle};

        int randomNum =  (int) (Math.random() * shape.length);

        public DrawingPanel() {
            this.addMouseListener(this);
            this.setBackground(Color.GRAY);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            //this.setBackground(colourArr[colourTracker]);

            Graphics2D g2d = (Graphics2D) g;

            g2d.setColor(colourArr[colourTracker]);

            if(shape != null){
                g2d.fill(shape[randomNum]);
            }



        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if(shape[randomNum].contains(e.getPoint())) {
                colourTracker = (colourTracker + 1) % colourArr.length;
                repaint();
            }

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {


            repaint();
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    class Point{
        int x, y;

        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    } // end class Point

    public static void main(String[] args) {
        new Test2().init();
    }
}
