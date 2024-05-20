package GUI;
import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel{
 
    public MyPanel(){
        this.setPreferredSize(new Dimension(500,500));
        this.setOpaque(false);
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
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
