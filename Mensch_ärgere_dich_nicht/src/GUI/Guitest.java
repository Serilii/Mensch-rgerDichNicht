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
    ZielKreisPanel zielKreisPanel_1;
    ZielKreisPanel zielKreisPanel_2;
    //JPanel würfelPanel;

    public void actionPerformed(ActionEvent e){};

    JButton button_links_1;
    JButton button_links_2;
    JButton button_links_3;
    JButton button_links_4;
    JButton button_oben;
    //JButton Spieleranzeige;
    
    JLabel Wuerfelanzeige;
   public JLabel label_farbe_am_zug;

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

    public Spielfeld sf;

    //es fehlt noch die funktionalität der buttons, ein JLabel oben um zu zeigen wer dran ist, und vielleicht eine würfel animation

    //generiert das Fenster, zeichnet die Figuren rein vom Spielfeld die man übergibt
    public Guitest(Spielfeld sf) {
        fenster = new JFrame("Ich bin eine GUI");
        fenster.setSize(1100,1100);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.getContentPane().setBackground(Color.PINK);
        fenster.setResizable(false);
    
        this.sf = sf;
        this.sf.GUI = this;
        GUI_vererbungs_kette(this.sf);

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
        button_oben = new JButton("würfeln!" );

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
            panel.setBounds((panel_links.getWidth() + 80 * (1 +panel.figur.feld.x_koordinate)) -3 , 0 + 80 * panel.figur.feld.y_koordinate, panel.getHeight() ,panel.getHeight() );
            layerPane.add(panel, Integer.valueOf(5));
            }
        }

        //füge Zielkreispanele hinzu
        this.zielKreisPanel_1 = new ZielKreisPanel();
        zielKreisPanel_1.setBounds(0, 0, zielKreisPanel_1.getHeight(), zielKreisPanel_1.getHeight());
        layerPane.add(zielKreisPanel_1, Integer.valueOf(4));
        zielKreisPanel_1.setVisible(false);
        zielKreisPanel_1.fillingfarbe = sf.Farbe_am_Zug.colour;

        this.zielKreisPanel_2 = new ZielKreisPanel();
        this.zielKreisPanel_2.setBounds(0, 0, zielKreisPanel_2.getHeight(), zielKreisPanel_2.getHeight());
        layerPane.add(zielKreisPanel_2, Integer.valueOf(4));
        zielKreisPanel_2.setVisible(false);
        zielKreisPanel_2.fillingfarbe = sf.Farbe_am_Zug.colour;
        
        this.Wuerfelanzeige = new JLabel("Der Würfel zeigt eine :  " + this.sf.wuerfel.aktuelle_Zahl);
        panel_oben.add(Wuerfelanzeige);

        this.label_farbe_am_zug = new JLabel("Die Farbe die dran ist :  " + this.sf.Farbe_am_Zug.farbe);
        panel_oben.add(label_farbe_am_zug);

        besetze_alle_buttons();
        besetze_wuerfel_button();

        fenster.add(layerPane);
        fenster.setVisible(true);
    }

    //funktion um einen einzelnen Button zu besetzen (siehe funktion für alle)
    public void besetze_einzelnen_button(JButton button, int x){
        
        button.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e){    
                        if (sf.bewege_figur(x)) {    //bewegt die figur auf Spielfeld sf( wenn legal dann true return)
                            bewege_figur_bild(sf.Farbe_am_Zug.figurenarray[x]);  //bewegt das Bild
                            zielKreisPanel_2.setVisible(false); //aestethiccs
                            dehighlight_panel(x);
                            redraw();
                            sf.spielerwechsel();		//wenn die Figur gezogen ist, dann wehchselt der Spieler. hat von den Abfragen her ma meisten Sinn gemacht das hier zu plazieren
                            label_farbe_am_zug.setText("Die Farbe die dran ist :  " + sf.Farbe_am_Zug.farbe);
                        }
                }});
        button.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
        highlight_panel(x);
        redraw();
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
        dehighlight_panel(x);
        redraw();
        }});
    }

    public void besetze_wuerfel_button(){
        button_oben.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e){
                    sf.wuerfel.wuerfeln();
                    Wuerfelanzeige.setText("Der Würfel zeigt eine :  " + sf.wuerfel.aktuelle_Zahl);
                }
                });
    }

    //funktion um alle Buttons hintereinander einzeln zu besetzen, muss im Moment am Anfang jedes Zuges in der Game Loop neu vergeben werden
    public void besetze_alle_buttons(){
        //signatur (zugehöriger button, figur auf die sich bezogen wird)
        besetze_einzelnen_button(button_links_1, 0);
        besetze_einzelnen_button(button_links_2, 1);
        besetze_einzelnen_button(button_links_3, 2);
        besetze_einzelnen_button(button_links_4, 3);
    }


    //nur zum bugfixen, kann später raus
    public void testbewegung(){
        blau_1.figur.einsteigen();
        blau_1.figur.alle_felder_ziehen(3);
        bewege_figur_bild(blau_1.figur);
        blau_2.figur.einsteigen();
        blau_2.figur.alle_felder_ziehen(2);
        bewege_figur_bild(blau_2.figur);
        blau_3.figur.einsteigen();
        blau_3.figur.alle_felder_ziehen(1);
        bewege_figur_bild(blau_3.figur);
        blau_4.figur.einsteigen();
        blau_4.figur.alle_felder_ziehen(0);
        bewege_figur_bild(blau_4.figur);

        gruen_1.figur.einsteigen();
        bewege_figur_bild(gruen_1.figur);

        gruen_2.figur.einsteigen();
        bewege_figur_bild(gruen_2.figur);

        rot_1.figur.einsteigen();
        bewege_figur_bild(rot_1.figur);

        layerPane.repaint();
        layerPane.revalidate();
    }


    //verschiebt das Panel der übergebenen Figur
    public void bewege_figur_bild(Figur figur) {
        figur.figurpanel.setBounds(76 + 80 * figur.figurpanel.figur.feld.x_koordinate, 0 + 80 * figur.figurpanel.figur.feld.y_koordinate, figur.figurpanel.figur.figurpanel.getHeight() ,figur.figurpanel.figur.figurpanel.getHeight() );  
        layerPane.repaint();
        layerPane.revalidate();
    }


    public void highlight_panel(int a){ 
        //higlighte die Figut
        Figur y = sf.Farbe_am_Zug.figurenarray[a];
        y.figurpanel.aktuelle_Farbe = y.figurpanel.fillingfarbe_highlight;

        //bemale das Zielkreispanel mit der aktuellen Farbe und setze blende es am Ziel ein
        zielKreisPanel_1.fillingfarbe = sf.Farbe_am_Zug.colour;
        zielKreisPanel_2.fillingfarbe = sf.Farbe_am_Zug.colour;
        

        Feld check = sf.Farbe_am_Zug.figurenarray[a].Zielfeld_return(sf.wuerfel.aktuelle_Zahl);
        this.zielKreisPanel_1.setBounds(panel_links.getWidth() + 80 * check.x_koordinate, panel_oben.getHeight() + 80 * check.y_koordinate, this.zielKreisPanel_1.getHeight() ,this.zielKreisPanel_1.getHeight() ); 
        zielKreisPanel_1.setVisible(true);

        Feld dieses = sf.Farbe_am_Zug.figurenarray[a].feld;
        this.zielKreisPanel_2.setBounds(panel_links.getWidth() + 80 * dieses.x_koordinate, panel_oben.getHeight() + 80 * dieses.y_koordinate, this.zielKreisPanel_2.getHeight() ,this.zielKreisPanel_2.getHeight() ); 
        zielKreisPanel_2.setVisible(true);

        redraw();
    };

    public void dehighlight_panel(int a){
        Figur y = sf.Farbe_am_Zug.figurenarray[a];
        y.figurpanel.aktuelle_Farbe = y.figurpanel.fillingfarbe; 
        zielKreisPanel_1.setVisible(false);
        zielKreisPanel_2.setVisible(false);
        redraw();
    }

    private void GUI_vererbungs_kette(Spielfeld sf){
        this.sf.GUI = this;                             //vererbe manuel einen Pointer auf diese GUI für alle Figuren in allen Farben
        for (Farbe farbe: this.sf.farbenarray ) {       
            for (Figur figur : farbe.figurenarray) {
                figur.GUI = this;
            }
        }
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
        wuerfel.aktuelle_Zahl = 6;

        Spielfeld sf = new Spielfeld(wuerfel);
        Guitest Gui = new Guitest(sf);

        Gui.zeichne_Gui();
        Gui.testbewegung();

        // sf.spielerwechsel();
        // sf.Farbe_am_Zug = sf.Grün;
        sf.iterator = 3;
        // sf.Farbe_am_Zug = sf.Rot;
        // Gui.besetze_alle_buttons();
        Gui.redraw();


        // Gui.testbewegung();
                // for (int i = 0; i < 50; i++ ){
                //     Thread.sleep(100);
                //     Gui.testbewegung();
                //     }
    }}
        

                


