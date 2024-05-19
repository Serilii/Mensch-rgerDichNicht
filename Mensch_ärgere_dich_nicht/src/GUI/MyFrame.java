package GUI;
import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame{


    MyPanel panel;

    //constructor
    public MyFrame() {;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        panel = new MyPanel();
        panel.setBackground(Color.PINK);
        this.add(panel);
        this.pack();
    }    



    // public void paint(Graphics g){
    //     Graphics2D g2D = (Graphics2D) g;
    //     g2D.drawLine(0,10,500,500);
    //     g2D.setStroke(new BasicStroke(5));
    // }


    public static void main (String args []){


        MyFrame meinframe = new MyFrame();
        meinframe.panel.setBackground(Color.PINK);
        meinframe.add(meinframe.panel);

        meinframe.setVisible(true);

    }

}
