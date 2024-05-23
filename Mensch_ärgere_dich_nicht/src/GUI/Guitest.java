package GUI;
import klassen.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Guitest implements ActionListener {
    JFrame fenster;
    JPanel panel_border_main;
    JPanel panel_oben;
    JPanel panel_links;
    Spielbrett_Panel panel_mitte;
    //JPanel würfelPanel;

    public void actionPerformed(ActionEvent e){};

    JButton button_links_1;
    JButton button_links_2;
    JButton button_links_3;
    JButton button_links_4;
    JButton button_oben;
    //JButton Spieleranzeige;

    BoxLayout layout_links;

    JLayeredPane layerPane;
    JLayeredPane layerPane_buffer;

    FigurPanel blau_1; 
    FigurPanel blau_2;
    FigurPanel blau_3; 
    FigurPanel blau_4; 
    FigurPanel[] array_FigurPanele_blau ;

    FigurPanel gruen_1; 
    FigurPanel gruen_2;
    FigurPanel gruen_3;
    FigurPanel gruen_4;
    FigurPanel[] array_FigurPanele_gruen ;

    FigurPanel rot_1; 
    FigurPanel rot_2;
    FigurPanel rot_3;
    FigurPanel rot_4;
    FigurPanel[] array_FigurPanele_rot;

    FigurPanel gelb_1; 
    FigurPanel gelb_2;
    FigurPanel gelb_3;
    FigurPanel gelb_4; 
    FigurPanel[] array_FigurPanele_gelb ;

    Spielfeld sf;

    //es fehlt noch die funktionalität der buttons, ein JLabel oben um zu zeigen wer dran ist, und vielleicht eine würfel animation

    //generiert das Fenster, zeichnet die Figuren rein vom Spielfeld die man übergibt
    public Guitest(Spielfeld sf) {
        fenster = new JFrame("Ich bin eine GUI");
        fenster.setSize(1100,1100);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.getContentPane().setBackground(Color.PINK);
        fenster.setResizable(false);
    
        this.sf = sf;

        panel_border_main = new JPanel();
        panel_border_main.setBounds(0,0,1100,1100);
        panel_border_main.setLayout(new BorderLayout());
        
        //Unterpanele 
        panel_oben  = new JPanel();
        panel_links = new JPanel();
        panel_mitte = new Spielbrett_Panel();
        panel_mitte.setDoubleBuffered(true);

        //buttons  
        button_links_1 = new JButton("Figur 1");
        button_links_2 = new JButton("Figur 2");
        button_links_3 = new JButton("Figur 3");
        button_links_4 = new JButton("Figur 4");
        button_oben = new JButton("oben" );

        layout_links = new BoxLayout(panel_links, BoxLayout.Y_AXIS);

        // panel_links.add(Box.createRigidArea(new Dimension(0,5)));           // <--- damit kann man manuel Abstände zwischen Buttons machen
    
        layerPane = new JLayeredPane(); 
        layerPane.setBounds(0,0,1100, 1100);
        layerPane.setDoubleBuffered(true);

        layerPane_buffer = new JLayeredPane(); 
        layerPane_buffer.setBounds(0,0,1100, 1100);
        layerPane.setDoubleBuffered(true);

        //erstelle die FigurenPanele, verbinde sie hin undzurück mit den übergebenen Figuren, und packe sie in arrays zum iterieren
        blau_1 = new FigurPanel(sf.Blau.figur_1);
        blau_2 = new FigurPanel(sf.Blau.figur_2);
        blau_3 = new FigurPanel(sf.Blau.figur_3);
        blau_4 = new FigurPanel(sf.Blau.figur_4);
        array_FigurPanele_blau = new FigurPanel[] {blau_1, blau_2,  blau_3, blau_4};

        gruen_1 = new FigurPanel(sf.Grün.figur_1);
        gruen_2= new FigurPanel(sf.Grün.figur_2);
        gruen_3= new FigurPanel(sf.Grün.figur_3);
        gruen_4= new FigurPanel(sf.Grün.figur_4);
        array_FigurPanele_gruen = new FigurPanel[] { gruen_1,  gruen_2,   gruen_3,  gruen_4};

        rot_1 = new FigurPanel(sf.Rot.figur_1);
        rot_2 = new FigurPanel(sf.Rot.figur_2);
        rot_3 = new FigurPanel(sf.Rot.figur_3);
        rot_4 = new FigurPanel(sf.Rot.figur_4);
        array_FigurPanele_rot = new FigurPanel[] {rot_1, rot_2,  rot_3, rot_4};

        gelb_1 = new FigurPanel(sf.Gelb.figur_1);
        gelb_2 = new FigurPanel(sf.Gelb.figur_2);
        gelb_3 = new FigurPanel(sf.Gelb.figur_3);
        gelb_4 = new FigurPanel(sf.Gelb.figur_4);
        array_FigurPanele_gelb = new FigurPanel[] {gelb_1, gelb_2,  gelb_3, gelb_4};

        //ich schmeisse alle arrays[] in ein array[][] damit der code schöner aussieht bei 4 Iterationen hintereinander
        FigurPanel[][] array_alle_FigurenPanel_arrays_lol = new FigurPanel[][] {array_FigurPanele_blau, array_FigurPanele_gelb, array_FigurPanele_gruen, array_FigurPanele_rot};

        //iteriere die arrays[] in der liste der arrays[][]  ///was man nicht alles tut für Übersichtlichkeit
        for (FigurPanel[] array: array_alle_FigurenPanel_arrays_lol) {
        for (FigurPanel panel : array){
            panel.setBounds(76 + 80 * panel.figur.feld.x_koordinate, 0 + 80 * panel.figur.feld.y_koordinate, panel.getHeight() ,panel.getHeight() );
            layerPane.add(panel, Integer.valueOf(5));
            }
        }

        fenster.add(layerPane);
        fenster.setVisible(true);
    }

    //nur zum bugfixen, kann später raus
    public void testbewegung(){
        blau_1.figur.einsteigen();
        blau_1.figur.alle_felder_ziehen(3);
        blau_2.figur.einsteigen();
        blau_2.figur.alle_felder_ziehen(2);
        blau_3.figur.einsteigen();
        blau_3.figur.alle_felder_ziehen(1);
        blau_4.figur.einsteigen();
        blau_4.figur.alle_felder_ziehen(0);
        bewege_figur_bild(blau_1);
        bewege_figur_bild(blau_2);
        bewege_figur_bild(blau_3);
        bewege_figur_bild(blau_4);
        layerPane.repaint();
        layerPane.revalidate();
    }

    //verschiebt das Panel der übergebenen Figur
    public void bewege_figur_bild(FigurPanel bild) {
        bild.setBounds(76 + 80 * bild.figur.feld.x_koordinate, 0 + 80 * bild.figur.feld.y_koordinate, bild.figur.figurpanel.getHeight() ,bild.figur.figurpanel.getHeight() );  
        layerPane.repaint();
        layerPane.revalidate();
    }

    public void highlight_panel(){
        sf.Farbe_am_Zug.figur_1.figurpanel.aktuelle_Farbe = sf.Farbe_am_Zug.figur_1.figurpanel.fillingfarbe_highlight; 
        redraw();
    };

    public void dehighlight_panel(){
        sf.Farbe_am_Zug.figur_1.figurpanel.aktuelle_Farbe = sf.Farbe_am_Zug.figur_1.figurpanel.fillingfarbe; 
        redraw();
    }

    //zeichnet 
    public void zeichne_Gui(){
           
        panel_links.setLayout(layout_links);
        panel_links.add(button_links_1);
        panel_links.add(button_links_2);
        panel_links.add(button_links_3);
        panel_links.add(button_links_4);
        panel_oben.add(button_oben);

        panel_border_main.add(panel_mitte, BorderLayout.CENTER);
        panel_border_main.add(panel_links, BorderLayout.WEST);
        panel_border_main.add(panel_oben, BorderLayout.NORTH);
        layerPane.add(panel_border_main, Integer.valueOf(0));

        
        gruen_1.figur.einsteigen();

        button_links_1.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("Ich returne jetzt Figur Blau 1!");
                sf.bewege_figur_1();    //bewegt die figur auf Spielfeld sf
                bewege_figur_bild(blau_1);  //bewegt das Bild
            }});

        button_links_1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
        highlight_panel();
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
        dehighlight_panel();
        }
});

        layerPane.repaint();
        layerPane.revalidate();
    }

    //vielleicht später nützlich zum bugfixen
    public void redraw(){            
            layerPane.repaint();
            layerPane.revalidate();
    }

    public static void main (String args []) throws InterruptedException {

        Wuerfel wuerfel = new Wuerfel();
        wuerfel.wuerfeln();

        Spielfeld sf = new Spielfeld(wuerfel);
        Guitest Gui = new Guitest(sf);

        Gui.zeichne_Gui();
        Gui.testbewegung();
        Gui.redraw();
        // Gui.testbewegung();
                // for (int i = 0; i < 50; i++ ){
                //     Thread.sleep(100);
                //     Gui.testbewegung();
                //     }
                }}
        

                


