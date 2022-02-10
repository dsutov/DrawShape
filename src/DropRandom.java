import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class DropRandom extends JFrame {

    private ColorCanvas canvas = new ColorCanvas();

    public DropRandom ()
    {
        this.setSize(400,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void init()
    {
        this.add(canvas);
        this.setVisible(true);
    }

    class ColorCanvas extends JPanel implements MouseListener {
        private Rectangle2D rect = new Rectangle2D.Double(100,100,50,70);
        private Rectangle2D square = new Rectangle2D.Double(100,100,50,50);
        private Ellipse2D circle = new Ellipse2D.Double(100,100,50,50);
        private Shape[] shapes = {rect, square, circle};
        int rndNum;
        public ColorCanvas() {
            this.addMouseListener(this);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            rndNum = (int) (Math.random() * shapes.length);
            g2d.fill(shapes[rndNum]);



        }

        @Override
        public void mouseClicked(MouseEvent e) {


        }

        @Override
        public void mousePressed(MouseEvent e) {
            if(rndNum == 0) {
                rect = new Rectangle2D.Double(e.getX(), e.getY(), 50, 70);
            } else if(rndNum == 1) {
                square = new Rectangle2D.Double(e.getX(),e.getY(),50,50);
            } else if( rndNum == 2) {
                circle = new Ellipse2D.Double(e.getX(),e.getY(),50,50);
            }
            repaint();
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

    public static void main(String[] args) {
        new DropRandom().init();
    }
}
