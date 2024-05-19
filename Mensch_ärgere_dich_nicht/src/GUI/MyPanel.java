package GUI;
import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel{
 
    public MyPanel(){
        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(Color.PINK);
        // this.setPreferredSize(new Dimension(500,500));
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(Color.BLUE);
        g2D.setStroke(new BasicStroke(5));
        // g2D.drawLine(0,0,500,500);
        // g2D.drawRect(50, 50, 50, 50);
        // g2D.fillRect(100, 100, 100, 100);
    
        g2D.fillOval(50, 50, 100, 100);
    }


    // public static void main (String args []){

    //     MyFrame fenster = new MyFrame();
    //     MyPanel testpanel = new MyPanel();
    //     testpanel.setBackground(Color.BLACK);
    //     BorderLayout layout = new BorderLayout();
    //     fenster.setLayout(layout);
    //     fenster.add(testpanel);
    //     fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //         fenster.getContentPane().add(testpanel);
    //     fenster.setVisible(true);

    // }
}
