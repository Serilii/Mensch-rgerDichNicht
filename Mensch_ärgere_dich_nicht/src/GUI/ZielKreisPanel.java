package GUI;
import javax.swing.*;
import java.awt.*;

public class ZielKreisPanel extends JPanel {
    
    Color fillingfarbe;

    public ZielKreisPanel(){
        this.setSize(new Dimension(65,65));
        this.setOpaque(false);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        if (this.fillingfarbe != null){
            g2D.setColor(new Color(
                ((int)(this.fillingfarbe.getRed())), 
                ((int)(this.fillingfarbe.getGreen())), 
                ((int)(this.fillingfarbe.getBlue())),
                ((int)((this.fillingfarbe.getAlpha() * 0.8)) )
            )
            );
        }
        g2D.fillOval(0, 0, 60, 60);

        g2D.setStroke(new BasicStroke(4));
        g2D.setColor(Color.black);
        g2D.drawOval(0, 0, 60, 60);

        g2D.setStroke(new BasicStroke(2));
        g2D.setColor(Color.white);
        g2D.drawOval(18, 18, 23, 23);
    }
}
