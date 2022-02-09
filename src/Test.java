import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Test extends JFrame {

    private CanvasPanel canvasPanel = new CanvasPanel();

    public Test() {
        this.setTitle("Draw Shape");
        this.setSize(400,400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    } // end constructor

    public void init() {
        this.add(canvasPanel);
        this.setVisible(true);
    }// end init

    class CanvasPanel extends JPanel implements MouseListener {

        private ArrayList<Point> points = new ArrayList();
        private Color [] colors = {Color.BLUE, Color.RED, Color.GREEN};
        private Rectangle2D rect = new Rectangle2D.Double();
        private Point2D dot = new Point2D.Double();

        public CanvasPanel() {
            addMouseListener(this);
            this.setBackground(Color.GRAY);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;

            //g2d.setColor(Color.RED);

            //g2d.fill(rect);

            for(Point p : points)
            {
                g2d.setColor(Color.RED);
                g2d.fillRect(p.x -5, p.y - 5, 10,10);
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            points.add(new Point(e.getX(),e.getY()));
            repaint();
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    } // end class Canvas

    class Point{
        int x, y;

        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    } // end class Point


    public static void main(String[] args) {
        new Test().init();
    } // end main method
} // end class Test