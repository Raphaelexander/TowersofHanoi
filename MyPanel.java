
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MyPanel extends JPanel implements ActionListener{
    
    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;
    Timer timer;
    int xVelocity = 1;
    int yVelocity = 1;
    int x = 0;
    int y = 0;

    MyPanel(){
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        timer = new Timer(1000, this);
        timer.start();
    }
    public void paint(Graphics g) {

        
        Graphics2D g2D = (Graphics2D) g;

        g2D.setStroke(new BasicStroke(3));
        
        g2D.drawLine(125, 150, 125, 350);//tower and base 1
        g2D.drawLine(100, 350, 150, 350);

        g2D.drawLine(225, 150, 225, 350);//tower and base 2
        g2D.drawLine(200, 350, 250, 350);

        g2D.drawLine(325, 150, 325, 350); //tower and base 3
        g2D.drawLine(300, 350, 350, 350);

        g2D.setPaint(Color.red); //biggest block
        g2D.fillOval(87, 322, 75, 25); //tower1 bottom position

        g2D.setPaint(Color.blue); //middle block
        g2D.fillOval(96, 305, 55, 15); //tower1 middle position
        
        g2D.setPaint(Color.green); //smallest block
        g2D.fillOval(101, 292, 45, 10); //tower1 top position

     }
    //  @Override
    //  public void actionPerformed(ActionEvent e) {
    //     x = x + xVelocity;
    //     repaint();
    //  }
}