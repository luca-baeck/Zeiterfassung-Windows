import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.Icon;
import javax.swing.table.*;
import java.text.ParseException;  
import java.text.SimpleDateFormat;
/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 31.01.2020
 * @author 
 */

public class cTennisstunden extends JFrame {
  // Anfang Attribute
  private JLabel lTennisstunden = new JLabel();
  private JLabel lUebersicht1 = new JLabel();
  private JLabel lGuthaben1 = new JLabel();
  private JButton bZurueck = new JButton();
  private JButton bZurueck1 = new JButton();
 
  private JButton bp = new JButton();
  
  private JButton bm = new JButton();
  private JButton bGuthaben = new JButton();
  private JButton bReload = new JButton();
  private JButton bExit = new JButton();
  private JButton bDaten = new JButton();
  private JButton bZurueck2 = new JButton();
  private JLabel lDaten = new JLabel();
  private JLabel lIhreStundenzahl = new JLabel();
  private JLabel lStunden = new JLabel();
  private JLabel lAktuelleVeraenderung = new JLabel();
  private JButton bReset = new JButton();
  private JLabel lSolldasProgrammwirklichresettetwerden = new JLabel();
  private JButton bJa = new JButton();
  private JButton bNein = new JButton();
  private JLabel lDieswuerdeeinenNeustarterzwingen = new JLabel();
  private JLabel lUhrzeit = new JLabel();
  private JButton bm1 = new JButton();
  private JButton bp1 = new JButton();
    
  private JButton bBackup = new JButton();
  private JLabel lSolleinBackuperstelltwerden = new JLabel();
  private JButton bJa1 = new JButton();
  private JButton bNein1 = new JButton();
  private JLabel lBackupwurdeerfolgreicherstellt = new JLabel();
  private JButton bZurueck3 = new JButton();
  // Ende Attribute
  
  
  
  // Anfang Methoden
  static public int Stunden=0;
  static private int Guthaben= Stunden*7;
  static public String NStunden;
  static private String UStunden;
  static private String uUhrzeit ;
  static private String nUhrzeit;
  static private int iUstunden;
  static private boolean Fertig=false;
  static private String sTennisstunden = "Tennisstunden.txt";
  static private String sBackup = "Tennisstunden-Backup.txt";
  static private  Date dt = new Date();
  static private String date;
  static private String[] Datum= new String[20];
  static private int Datecounter=cTennisstunden.Stunden;
  static private int different=cTennisstunden.Stunden-cTennisstunden.iUstunden;
  static private int Uhrzeit;
 
  public cTennisstunden() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 1000; 
    int frameHeight = 600;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Tennisstunden");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    cp.setBackground(Color.GRAY);
    lTennisstunden.setBounds(200, 225, 600, 75);
    lTennisstunden.setText("Tennisstunden");
    lTennisstunden.setForeground(Color.YELLOW);
    lTennisstunden.setHorizontalAlignment(SwingConstants.CENTER);
    lTennisstunden.setFont(new Font("Verdana", Font.BOLD, 72));
    cp.add(lTennisstunden);
    lUebersicht1.setBounds(347, 4, 280, 63);
    lUebersicht1.setText("Übersicht:");
    lUebersicht1.setFont(new Font("Verdana", Font.BOLD, 48));
    lUebersicht1.setForeground(new Color(0x800080));
    lUebersicht1.setHorizontalTextPosition(SwingConstants.CENTER);
    lUebersicht1.setHorizontalAlignment(SwingConstants.CENTER);
    lUebersicht1.setVisible(false);
    cp.add(lUebersicht1);
  
  
    bGuthaben.setVisible(false);
    bGuthaben.setFont(new Font("Dialog", Font.BOLD, 26));
    cp.add(bGuthaben);
    lGuthaben1.setBounds(275, 120, 210, 50);
    lGuthaben1.setText("Guthaben: "+cTennisstunden.Guthaben+"€");
    lGuthaben1.setBackground(Color.BLUE);
    lGuthaben1.setOpaque(true);
    lGuthaben1.setVisible(false);
    lGuthaben1.setFont(new Font("Dialog", Font.BOLD, 26));
    cp.add(lGuthaben1);
    bZurueck.setBounds(865, 500, 75, 40);
    bZurueck.setText("Zurück");
    bZurueck.setMargin(new Insets(2, 2, 2, 2));
    bZurueck.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bZurueck_ActionPerformed(evt);
      }
    });
    bZurueck.setBackground(Color.MAGENTA);
    bZurueck.setFont(new Font("Dialog", Font.BOLD, 18));
    bZurueck.setVisible(false);
    cp.add(bZurueck);
   
    bZurueck1.setBounds(865, 500, 75, 40);
    bZurueck1.setText("Zurück");
    bZurueck1.setMargin(new Insets(2, 2, 2, 2));
    bZurueck1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bZurueck1_ActionPerformed(evt);
        
      }
    });
    bZurueck1.setBackground(Color.MAGENTA);
    bZurueck1.setFont(new Font("Dialog", Font.BOLD, 18));
    bZurueck1.setVisible(false);
    cp.add(bZurueck1);
    bp.setBounds(530, 490, 70, 34);
    bp.setText("+");
    bp.setMargin(new Insets(2, 2, 2, 2));
    bp.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bp_ActionPerformed(evt);
        
        
        
      }
    });
    bp.setBackground(Color.BLUE);
    bp.setFont(new Font("Dialog", Font.BOLD, 24));
    bp.setVisible(false);
   
   
    cp.add(bp);
    bm.setBounds(400, 490, 70, 34);
    bm.setText("-");
    bm.setMargin(new Insets(2, 2, 2, 2));
    bm.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bm_ActionPerformed(evt);
      }
    });
    bm.setBackground(Color.RED);
    bm.setFont(new Font("Dialog", Font.BOLD, 24));
    bm.setVisible(false);
    cp.add(bm);
    bGuthaben.setBounds(85, 120, 210, 50);
    bGuthaben.setText("Guthaben: "+cTennisstunden.Guthaben+"€");
    bGuthaben.setMargin(new Insets(2, 2, 2, 2));
    bGuthaben.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bGuthaben_ActionPerformed(evt);
        
      }
    });
    bGuthaben.setBackground(new Color(0xFFC800));
    bGuthaben.setHorizontalAlignment(SwingConstants.LEFT);
    cp.add(bGuthaben);
    bReload.setBounds(425, 120, 150, 50);
    bReload.setText("Reload");
    bReload.setMargin(new Insets(2, 2, 2, 2));
    bReload.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bReload_ActionPerformed(evt);
      }
    });
    bReload.setBackground(Color.GREEN);
    bReload.setFont(new Font("Dialog", Font.BOLD, 36));
    cp.add(bReload);
    bExit.setBounds(437, 450, 125, 50);
    bExit.setText("Exit");
    bExit.setMargin(new Insets(2, 2, 2, 2));
    bExit.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bExit_ActionPerformed(evt);
      }
    });
    bExit.setBackground(new Color(0xFFAFAF));
    bExit.setFont(new Font("Dialog", Font.BOLD, 36));
    bExit.setVisible(false);
    cp.add(bExit);
    bDaten.setBounds(715, 120, 200, 50);
    bDaten.setText("Daten");
    bDaten.setMargin(new Insets(2, 2, 2, 2));
     bDaten.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bDaten_ActionPerformed(evt);
      }
    });
    bDaten.setFont(new Font("Dialog", Font.BOLD, 24));
    bDaten.setBackground(Color.MAGENTA);
    bDaten.setVisible(false);
    cp.add(bDaten);
    bZurueck2.setBounds(865, 500, 75, 40);
    bZurueck2.setText("Zurück");
    bZurueck2.setMargin(new Insets(2, 2, 2, 2));
    bZurueck2.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bZurueck2_ActionPerformed(evt);
      }
    });
    bZurueck2.setBackground(Color.MAGENTA);
    bZurueck2.setFont(new Font("Dialog", Font.BOLD, 18));
    bZurueck2.setVisible(false);
    cp.add(bZurueck2);
    lDaten.setBounds(150, 484, 700, 500);
    lDaten.setText("Daten");
    lDaten.setVisible(false);
    lDaten.setHorizontalAlignment(SwingConstants.LEFT);
    lDaten.setFont(new Font("Dialog", Font.BOLD, 18));
    lDaten.setHorizontalTextPosition(SwingConstants.LEFT);
    cp.add(lDaten);
    lDaten.setBounds(200, 59, 600, 500);
    lIhreStundenzahl.setBounds(355, 430, 290, 49);
    lIhreStundenzahl.setText("Ihre Stundenzahl: "+cTennisstunden.Stunden);
    lIhreStundenzahl.setBackground(Color.GREEN);
    lIhreStundenzahl.setOpaque(true);
    lIhreStundenzahl.setFont(new Font("Dialog", Font.BOLD, 26));
    lIhreStundenzahl.setHorizontalAlignment(SwingConstants.CENTER);
    lIhreStundenzahl.setVisible(false);
    cp.add(lIhreStundenzahl);
    lStunden.setBounds(525, 120, 210, 50);
    lStunden.setText("Stunden: "+cTennisstunden.Stunden);
    lStunden.setBackground(Color.RED);
    lStunden.setOpaque(true);
    lStunden.setFont(new Font("Dialog", Font.BOLD, 26));
    lStunden.setVisible(false);
    cp.add(lStunden);
    lAktuelleVeraenderung.setBounds(10, 450, 320, 41);
    lAktuelleVeraenderung.setText("Aktuelle Veränderung: "+cTennisstunden.different);
    lAktuelleVeraenderung.setBackground(Color.MAGENTA);
    lAktuelleVeraenderung.setOpaque(true);
    lAktuelleVeraenderung.setFont(new Font("Dialog", Font.BOLD, 26));
    lAktuelleVeraenderung.setHorizontalAlignment(SwingConstants.LEFT);
    lAktuelleVeraenderung.setVisible(false);
    cp.add(lAktuelleVeraenderung);
    bReset.setBounds(60, 450, 125, 50);
    bReset.setText("Reset");
    bReset.setMargin(new Insets(2, 2, 2, 2));
    bReset.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bReset_ActionPerformed(evt);
      }
    });
    bReset.setBackground(Color.RED);
    bReset.setFont(new Font("Dialog", Font.BOLD, 36));
    bReset.setVisible(false);
    cp.add(bReset);
    lSolldasProgrammwirklichresettetwerden.setBounds(50, 125, 914, 90);
    lSolldasProgrammwirklichresettetwerden.setText("Soll das Programm wirklich resettet werden?");
    lSolldasProgrammwirklichresettetwerden.setForeground(Color.RED);
    lSolldasProgrammwirklichresettetwerden.setHorizontalAlignment(SwingConstants.CENTER);
    lSolldasProgrammwirklichresettetwerden.setFont(new Font("Verdana", Font.BOLD, 36));
    lSolldasProgrammwirklichresettetwerden.setVisible(false);
    cp.add(lSolldasProgrammwirklichresettetwerden);
    bJa.setBounds(350, 325, 100, 50);
    bJa.setText("Ja");
    bJa.setMargin(new Insets(2, 2, 2, 2));
    bJa.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bJa_ActionPerformed(evt);
      }
    });
    bJa.setBackground(Color.RED);
    bJa.setFont(new Font("Dialog", Font.BOLD, 24));
    bJa.setVisible(false);
    cp.add(bJa);
    bNein.setBounds(550, 325, 100, 50);
    bNein.setText("Nein");
    bNein.setMargin(new Insets(2, 2, 2, 2));
    bNein.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bNein_ActionPerformed(evt);
      }
    });
    bNein.setBackground(Color.GREEN);
    bNein.setFont(new Font("Dialog", Font.BOLD, 24));
    bNein.setVisible(false);
    cp.add(bNein);
    lDieswuerdeeinenNeustarterzwingen.setBounds(250, 200, 500, 50);
    lDieswuerdeeinenNeustarterzwingen.setText("Dies würde einen Neustart erzwingen");
    lDieswuerdeeinenNeustarterzwingen.setFont(new Font("Dialog", Font.BOLD, 26));
    lDieswuerdeeinenNeustarterzwingen.setForeground(new Color(0x000080));
    lDieswuerdeeinenNeustarterzwingen.setHorizontalAlignment(SwingConstants.CENTER);
    lDieswuerdeeinenNeustarterzwingen.setVisible(false);
    cp.add(lDieswuerdeeinenNeustarterzwingen);
    lUhrzeit.setBounds(355, 315, 290, 49);
    lUhrzeit.setText("Uhrzeit: "+cTennisstunden.Uhrzeit+"Uhr");
    lUhrzeit.setBackground(new Color(0xFFC800));
    lUhrzeit.setOpaque(true);
    lUhrzeit.setFont(new Font("Dialog", Font.BOLD, 26));
    lUhrzeit.setHorizontalAlignment(SwingConstants.CENTER);
    lUhrzeit.setVisible(false);
    cp.add(lUhrzeit);
    bm1.setBounds(400, 375, 70, 34);
    bm1.setText("-");
    bm1.setMargin(new Insets(2, 2, 2, 2));
    bm1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bm1_ActionPerformed(evt);
      }
    });
    bm1.setBackground(Color.RED);
    bm1.setFont(new Font("Dialog", Font.BOLD, 24));
    bm1.setVisible(false);
    cp.add(bm1);
    bp1.setBounds(530, 375, 70, 34);
    bp1.setText("+");
    bp1.setMargin(new Insets(2, 2, 2, 2));
    bp1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bp1_ActionPerformed(evt);
      }
    });
    bp1.setBackground(Color.BLUE);
    bp1.setFont(new Font("Dialog", Font.BOLD, 24));
    
   
    
    bp1.setVisible(false);
    cp.add(bp1);
    bBackup.setBounds(790, 450, 150, 50);
    bBackup.setText("Backup");
    bBackup.setMargin(new Insets(2, 2, 2, 2));
    bBackup.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bBackup_ActionPerformed(evt);
      }
    });
    bBackup.setBackground(Color.CYAN);
    bBackup.setFont(new Font("Dialog", Font.BOLD, 36));
    bBackup.setVisible(false);
    cp.add(bBackup);
    lSolleinBackuperstelltwerden.setBounds(50, 175, 914, 90);
    lSolleinBackuperstelltwerden.setText("Soll ein Backup erstellt werden?");
    lSolleinBackuperstelltwerden.setForeground(new Color(0x008080));
    lSolleinBackuperstelltwerden.setHorizontalAlignment(SwingConstants.CENTER);
    lSolleinBackuperstelltwerden.setVisible(false);
    lSolleinBackuperstelltwerden.setOpaque(false);
    lSolleinBackuperstelltwerden.setFont(new Font("Verdana", Font.BOLD, 36));
    cp.add(lSolleinBackuperstelltwerden);
    bJa1.setBounds(350, 315, 100, 50);
    bJa1.setText("Ja");
    bJa1.setMargin(new Insets(2, 2, 2, 2));
    bJa1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bJa1_ActionPerformed(evt);
      }
    });
    bJa1.setBackground(Color.GREEN);
    bJa1.setFont(new Font("Dialog", Font.BOLD, 24));
    bJa1.setVisible(false);
    cp.add(bJa1);
    bNein1.setBounds(550, 315, 100, 50);
    bNein1.setText("Nein");
    bNein1.setMargin(new Insets(2, 2, 2, 2));
    bNein1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bNein1_ActionPerformed(evt);
      }
    });
    bNein1.setBackground(Color.RED);
    bNein1.setFont(new Font("Dialog", Font.BOLD, 24));
    bNein1.setVisible(false);
    cp.add(bNein1);
    lBackupwurdeerfolgreicherstellt.setBounds(250, 200, 500, 50);
    lBackupwurdeerfolgreicherstellt.setText("Backup wurde erfolgreich erstellt");
    lBackupwurdeerfolgreicherstellt.setFont(new Font("Dialog", Font.BOLD, 26));
    lBackupwurdeerfolgreicherstellt.setForeground(new Color(0x000080));
    lBackupwurdeerfolgreicherstellt.setHorizontalAlignment(SwingConstants.CENTER);
    lBackupwurdeerfolgreicherstellt.setVisible(false);
    cp.add(lBackupwurdeerfolgreicherstellt);
    bZurueck3.setBounds(865, 500, 75, 40);
    bZurueck3.setText("Zurück");
    bZurueck3.setMargin(new Insets(2, 2, 2, 2));
    bZurueck3.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bZurueck3_ActionPerformed(evt);
      }
    });
    bZurueck3.setBackground(Color.MAGENTA);
    bZurueck3.setFont(new Font("Dialog", Font.BOLD, 18));
    bZurueck3.setVisible(false);
    cp.add(bZurueck3);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public mTennisstunden 

    public static void main(String[] args) {
      
   
       new cTennisstunden();
      
    
    ladeDatei(sTennisstunden);
    
    System.out.println( "Date = " + dt );          // z.B. 'Fri Jan 26 19:03:56 GMT+01:00 2001'
   
   
   
     
    
    
    
     
    
    
      
     
            
  }

   // end of main
  
  public void bGuthaben_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einf�gen
    lUebersicht1.setVisible(false);
        bGuthaben.setVisible(false);
        lUebersicht1.setVisible(false);
        lGuthaben1.setVisible(true);
        bZurueck.setVisible(true);
        lStunden.setVisible(true);
        lAktuelleVeraenderung.setVisible(true);
     lIhreStundenzahl.setVisible(true);
     bm.setVisible(true);
     bp.setVisible(true);
     bm1.setVisible(true);
    bp1.setVisible(true);
    lUhrzeit.setVisible(true);
    bDaten.setVisible(false);
    bReset.setVisible(false);
    bExit.setVisible(false);
    lIhreStundenzahl.setText("Ihre Stundenzahl: "+cTennisstunden.Stunden);
    lUhrzeit.setText("Uhrzeit: "+cTennisstunden.Uhrzeit+"Uhr");
    bBackup.setVisible(false);
  } // end of bGuthaben_ActionPerformed

  public void bZurueck_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einf�gen
        lUebersicht1.setVisible(true);
        bGuthaben.setVisible(true);
        bZurueck.setVisible(false);
        lGuthaben1.setVisible(false);
        lStunden.setVisible(false);
        lIhreStundenzahl.setVisible(false);
        lAktuelleVeraenderung.setVisible(false);
        bp.setVisible(false);
        bm.setVisible(false);
       bDaten.setVisible(true);
    bReset.setVisible(true);
    Zeileaendern(sTennisstunden);
    ZeileaendernU(sTennisstunden);
    bExit.setVisible(true);
    bm1.setVisible(false);
    bp1.setVisible(false);
    lUhrzeit.setVisible(false);
    bBackup.setVisible(true);
  } // end of bZurueck_ActionPerformed

  public void bZurueck1_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einf�gen
     lGuthaben1.setVisible(true);
        lStunden.setVisible(true);
        bZurueck.setVisible(true);
        bZurueck1.setVisible(false);
        lTennisstunden.setVisible(true);
        bReset.setVisible(true);
        bp.setVisible(false);
        bm.setVisible(false);
     Zeileaendern(sTennisstunden);
    ZeileaendernU(sTennisstunden);
     bExit.setVisible(true); 
      bm1.setVisible(false);
    bp1.setVisible(false);
    lUhrzeit.setVisible(false); 
    bBackup.setVisible(true);
  } // end of bZurueck1_ActionPerformed
    public void bZurueck2_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einf�gen
    bZurueck2.setVisible(false);
    lTennisstunden.setVisible(true);
    bGuthaben.setVisible(true);
    bDaten.setVisible(true);
    Zeileaendern(sTennisstunden);
    ZeileaendernU(sTennisstunden);
   bExit.setVisible(true);
    lDaten.setVisible(false);
    bExit.setBounds(437, 450, 125, 50);
    bReset.setVisible(true);
     bm1.setVisible(false);
    bp1.setVisible(false);
    lUhrzeit.setVisible(false);
    bBackup.setVisible(true);
  } // end of bZurueck2_ActionPerformed

  public void bp_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einf�gen
    cTennisstunden.Stunden = cTennisstunden.Stunden+1;
    
    
        cTennisstunden.Guthaben= cTennisstunden.Stunden*7;
        System.out.println(cTennisstunden.Stunden+" Stunden");
        lIhreStundenzahl.setText("Ihre Stundenzahl: "+cTennisstunden.Stunden);
         cTennisstunden.iUstunden=Integer.parseInt(cTennisstunden.UStunden) ; 
        different=cTennisstunden.Stunden-cTennisstunden.iUstunden;
        lAktuelleVeraenderung.setText("Aktuelle Veränderung: "+cTennisstunden.different); 
        lStunden.setText("Stunden: "+cTennisstunden.Stunden);
        lGuthaben1.setText("Guthaben: "+Guthaben+"€");
        bGuthaben.setText("Guthaben: "+Guthaben+"€");
        dt=new Date();
        System.out.println(dt);
         neueZeile(sTennisstunden);
        Datumlesen(sTennisstunden);
    int i =0;
    lDaten.setText("<html><body>"+"01."+Datum[i]+"<br>"+"02."+Datum[i+1]+"<br>"+"03."+Datum[i+2]+"<br>"+"04."+Datum[i+3]+"<br>"+"05."+Datum[i+4]+"<br>"+"06."+Datum[i+5]+"<br>"+"07."+Datum[i+6]+"<br>"+"08."+Datum[i+7]+"<br>"+"09."+Datum[i+8]+"<br>"+"10."+Datum[i+9]+"<br>"+"11."+Datum[i+10]+"<br>"+"12."+Datum[i+11]+"<br>"+"13."+Datum[i+12]+"<br>"+"14."+Datum[i+13]+"<br>"+"15."+Datum[i+14]+"<br>"+"16."+Datum[i+15]+"<br>"+"17."+Datum[i+16]+"<br>"+"18."+Datum[i+17]+"<br>"+"19."+Datum[i+18]+"<br>"+"20."+Datum[i+19]+"</body></html>");

        
    
  } // end of bp_ActionPerformed
  
  private static  void neueZeile(String sTennisstunden) {
    PrintWriter pWriter = null;
   
        try {
            pWriter = new PrintWriter(new FileWriter(sTennisstunden, true), true);
            String sUhrzeit="";
            if (Uhrzeit<10) {
             sUhrzeit= "0"+Uhrzeit+":00:00" ;  
            }else if (Uhrzeit>=10) {
             sUhrzeit= Uhrzeit+":00:00" ;   
             } // end of if
          
           SimpleDateFormat formatter = new SimpleDateFormat();  
           String sDate = formatter.format(dt);
           System.out.println("String: "+sDate);
           sDate = sDate.substring(0,10)+sUhrzeit;
            pWriter.println("Datum: "+sDate+"Uhr"+" Now: "+dt);
            
            } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (pWriter != null){
                pWriter.flush();
                pWriter.close();
            }
        }  
    
    
  }
  
  
  public void bm_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einf�gen
          cTennisstunden.Stunden = cTennisstunden.Stunden-1;
        
        cTennisstunden.Guthaben= cTennisstunden.Stunden*7;
        System.out.println(cTennisstunden.Stunden+" Stunden");
        lIhreStundenzahl.setText("Ihre Stundenzahl: "+cTennisstunden.Stunden);
          cTennisstunden.iUstunden=Integer.parseInt(cTennisstunden.UStunden) ; 
        different=cTennisstunden.Stunden-cTennisstunden.iUstunden;
        lAktuelleVeraenderung.setText("Aktuelle Veränderung: "+cTennisstunden.different);
         
        lStunden.setText("Stunden: "+cTennisstunden.Stunden);
        lGuthaben1.setText("Guthaben: "+Guthaben+"€");
        bGuthaben.setText("Guthaben: "+Guthaben+"€");
         datumloeschen(sTennisstunden);
  } // end of bm_ActionPerformed
  public void datumloeschen(String sTennisstunden){
    if (cTennisstunden.Stunden>=0) {
      
    
    BufferedReader reader = null;
    BufferedWriter writer = null;
    StringBuffer lesepuffer = null;

    
   
    // Lesen
    lesepuffer = new StringBuffer();
    try {
      reader = new BufferedReader(new FileReader(sTennisstunden));
       int o=0;
      String zeile = null;
      String nulle="";
      while((zeile = reader.readLine()) != null) {
        // �ndern
        
          
            if (zeile.contains("Datum:")) {
          System.out.println("Loeschvorgang: Gelesene Zeile: " + zeile);
   
            System.out.println(cTennisstunden.Stunden);
           if (o==cTennisstunden.Stunden) {
            
            System.out.println("Wird geloescht...");
            zeile=zeile.replace(zeile,nulle) ;
             
             Datum[o]=null;
          } // end of if
          o++;     
            } 
         
        

        // Puffern
        lesepuffer.append(zeile + System.getProperty("line.separator"));
      }
    } catch(FileNotFoundException e) {
      e.printStackTrace();
    } catch(IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if(reader != null) reader.close();
      } catch(IOException e) {
      }
    }

    // Lesepuffer speichern
    try {
      writer = new BufferedWriter(new FileWriter(sTennisstunden));

      writer.write(lesepuffer.toString());
      writer.flush();
    } catch(IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if(writer != null) writer.close();
      } catch(IOException e) {
      }
    }
    
    
    

    }
    }
   public void bReload_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einf�gen
    bGuthaben.setVisible(true);
    bDaten.setVisible(true);
     Datenreload(sTennisstunden);
    int i =0;
    lDaten.setText("<html><body>"+"01."+Datum[i]+"<br>"+"02."+Datum[i+1]+"<br>"+"03."+Datum[i+2]+"<br>"+"04."+Datum[i+3]+"<br>"+"05."+Datum[i+4]+"<br>"+"06."+Datum[i+5]+"<br>"+"07."+Datum[i+6]+"<br>"+"08."+Datum[i+7]+"<br>"+"09."+Datum[i+8]+"<br>"+"10."+Datum[i+9]+"<br>"+"11."+Datum[i+10]+"<br>"+"12."+Datum[i+11]+"<br>"+"13."+Datum[i+12]+"<br>"+"14."+Datum[i+13]+"<br>"+"15."+Datum[i+14]+"<br>"+"16."+Datum[i+15]+"<br>"+"17."+Datum[i+16]+"<br>"+"18."+Datum[i+17]+"<br>"+"19."+Datum[i+18]+"<br>"+"20."+Datum[i+19]+"</body></html>");

        lStunden.setText("Stunden: "+cTennisstunden.Stunden);
    cTennisstunden.Guthaben=cTennisstunden.Stunden*7;
        lGuthaben1.setText("Guthaben: "+Guthaben+"€");
         bGuthaben.setText("Guthaben: "+Guthaben+"€");
    bReload.setVisible(false);
    bReset.setVisible(true);
    bExit.setVisible(true);
    lUebersicht1.setVisible(true);
    bBackup.setVisible(true);
  } // end of bReload_ActionPerformed

  private static void Zeileaendern(String sTennisstunden){
    BufferedReader reader = null;
    BufferedWriter writer = null;
    StringBuffer lesepuffer = null;

    String wert = "Stunden: ";
   
    // Lesen
    lesepuffer = new StringBuffer();
    try {
      reader = new BufferedReader(new FileReader(sTennisstunden));
      
      String zeile = null;
      while((zeile = reader.readLine()) != null) {
        // �ndern
        if(zeile.contains(wert)) {
          
            zeile=zeile.replace(cTennisstunden.UStunden,cTennisstunden.NStunden.valueOf(cTennisstunden.Stunden));
            System.out.println("Neue Stundenzahl gespeichert");
            System.out.println(cTennisstunden.Stunden);
          
        }
       
        // Puffern
        lesepuffer.append(zeile + System.getProperty("line.separator"));
      }
    } catch(FileNotFoundException e) {
      e.printStackTrace();
    } catch(IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if(reader != null) reader.close();
      } catch(IOException e) {
      }
    }

    // Lesepuffer speichern
    try {
      writer = new BufferedWriter(new FileWriter(sTennisstunden));

      writer.write(lesepuffer.toString());
      writer.flush();
    } catch(IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if(writer != null) writer.close();
      } catch(IOException e) {
      }
    }
    }
   private static void ZeileaendernU(String sTennisstunden){
    BufferedReader reader = null;
    BufferedWriter writer = null;
    StringBuffer lesepuffer = null;

    String wert = "Uhrzeit: ";
   
    // Lesen
    lesepuffer = new StringBuffer();
    try {
      reader = new BufferedReader(new FileReader(sTennisstunden));
      
      String zeile = null;
      while((zeile = reader.readLine()) != null) {
        // �ndern
       
        if(zeile.contains(wert)) {
          
            zeile=zeile.replace(cTennisstunden.uUhrzeit,cTennisstunden.nUhrzeit.valueOf(cTennisstunden.Uhrzeit));
            System.out.println("Neue Uhrzeit gespeichert");
            System.out.println(cTennisstunden.Uhrzeit+"Uhr");
          
        }
        // Puffern
        lesepuffer.append(zeile + System.getProperty("line.separator"));
      }
    } catch(FileNotFoundException e) {
      e.printStackTrace();
    } catch(IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if(reader != null) reader.close();
      } catch(IOException e) {
      }
    }

    // Lesepuffer speichern
    try {
      writer = new BufferedWriter(new FileWriter(sTennisstunden));

      writer.write(lesepuffer.toString());
      writer.flush();
    } catch(IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if(writer != null) writer.close();
      } catch(IOException e) {
      }
    }
    }
  
  private static void Datenreload(String sTennisstunden) {
    if (cTennisstunden.Stunden>0&&cTennisstunden.Stunden<21) {
      
    
         BufferedReader in = null;
    
        try {
            in = new BufferedReader(new FileReader(sTennisstunden));
            String zeile = null;
            int o=0;
            cTennisstunden.Datecounter= cTennisstunden.Stunden;
            while ((zeile = in.readLine()) != null) {
                System.out.println("2.Gelesene Zeile: " + zeile);
            if (zeile.contains("Datum:")) {
          
            
              
               Datum[o]= zeile;
               o++;
              
            } 
            // end of for
          
           
                
           
         } 
              
             
              
        }    
         catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException e) {
                }
        }
      
      } // end of if
    if (cTennisstunden.Stunden>20) {
      BufferedReader in = null;
    
        try {
            in = new BufferedReader(new FileReader(sTennisstunden));
            String zeile = null;
            int o=0;
        int i=0;
            int Unterschied= cTennisstunden.Stunden-20;
        System.out.println(cTennisstunden.Stunden);
            cTennisstunden.Datecounter= cTennisstunden.Stunden;
            while ((zeile = in.readLine()) != null) {
                System.out.println("2.Gelesene Zeile: " + zeile);
            if (zeile.contains("Datum:")) {
          
            
              if ((o+1)<=Unterschied) {
              o++;
              
                
              } // end of if
              else if(o+1>Unterschied&&i<20) {
                Datum[i]= zeile;
               i++;
              } // end of if-else
               
              
            } 
            // end of for
          
           
                
           
         } 
              
             
              
        }    
         catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException e) {
                }
        }
    } // end of if
  }
  private static void Datumlesen(String sTennisstunden){
            BufferedReader in = null;
    
        try {
            in = new BufferedReader(new FileReader(sTennisstunden));
            String zeile = null;
      
            cTennisstunden.Datecounter= cTennisstunden.Stunden;
            while ((zeile = in.readLine()) != null) {
                System.out.println("2.Gelesene Zeile: " + zeile);
            if (zeile.contains("Datum:")) {
          if ((cTennisstunden.Datecounter-1)>=20) {
            for (int o=0;o<20 ;o++ ) {
              
             
              
              if (o==0) {
                continue;
              } // end of if
               else{
                Datum[o-1]=Datum[o]; 
                }
             if (o==19) {
              
                Datum[o] =zeile;
              
                }
              } // end of if
            } 
            // end of for
           else {
            Datum[cTennisstunden.Datecounter-1]= zeile;
                
            } // end of if-else
         } 
              
            } 
              
        }    
         catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException e) {
                }
        }
    }
  
    
   private static  void ladeDatei(String sTennisstunden) {                                

        File file = new File(sTennisstunden);  
    try {
      
           
        if (file.createNewFile() ) {
      PrintWriter pWriter = null;
        System.out.println("Datei war nicht vorhanden und wurde erstellt.");
        try {
            pWriter = new PrintWriter(new BufferedWriter(new FileWriter("Tennisstunden.txt"))); 
            pWriter.println("Stunden: 0");
            pWriter.println("Uhrzeit: 12");
            pWriter.println("___Datum___");
            } catch (IOException ioe) {
            ioe.printStackTrace();     
        } finally {
            if (pWriter != null){
                pWriter.flush();
                pWriter.close();
            }
        }  
      } // end of if
       } catch(Exception e) {
      System.err.println(e);
    } 
    
    
        if (!file.canRead() || !file.isFile())
            System.exit(0);
      
        BufferedReader in = null;
    
        try {
            in = new BufferedReader(new FileReader(sTennisstunden));
            String zeile = null;
            while ((zeile = in.readLine()) != null) {
                System.out.println("Gelesene Zeile: " + zeile);
            if (zeile.contains("Stunden:")) {
              String index ="";
              String number="";
              int iPos = zeile.indexOf(' ');
              index = zeile.substring(0, iPos).trim();
              number = zeile.substring(iPos, zeile.length()).trim();
              cTennisstunden.Stunden= Integer.parseInt(number) ;
              UStunden=number;
              System.out.println(UStunden+" Ursprungsstunde(n)");
              
            } // end of if
        if (zeile.contains("Uhrzeit: ")) {
          
              String index ="";
              String number="";
              int iPos = zeile.indexOf(' ');
              index = zeile.substring(0, iPos).trim();
              number = zeile.substring(iPos, zeile.length()).trim();
              cTennisstunden.Uhrzeit= Integer.parseInt(number) ;
              cTennisstunden.uUhrzeit=number;
             System.out.println("Letzte Uhrzeit: "+cTennisstunden.Uhrzeit); 
            } // end of if   
            }   
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException e) {
                }
        }
    
    
    
    
    
    
    
    }

 

  public void bExit_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einf�gen
    
    try{

       Thread.sleep(1000);
      } catch(InterruptedException ex){
        //do stuff
        }
    Zeileaendern(sTennisstunden);
    ZeileaendernU(sTennisstunden);
     System.exit(0);
    
  } // end of bExit_ActionPerformed

  public void bDaten_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einf�gen
    
    lTennisstunden.setVisible(false);
    bGuthaben.setVisible(false);
    bDaten.setVisible(false);
    bZurueck2.setVisible(true);
    lDaten.setVisible(true);
     bBackup.setVisible(false);
     int i =0;
    lDaten.setText("<html><body>"+"01."+Datum[i]+"<br>"+"02."+Datum[i+1]+"<br>"+"03."+Datum[i+2]+"<br>"+"04."+Datum[i+3]+"<br>"+"05."+Datum[i+4]+"<br>"+"06."+Datum[i+5]+"<br>"+"07."+Datum[i+6]+"<br>"+"08."+Datum[i+7]+"<br>"+"09."+Datum[i+8]+"<br>"+"10."+Datum[i+9]+"<br>"+"11."+Datum[i+10]+"<br>"+"12."+Datum[i+11]+"<br>"+"13."+Datum[i+12]+"<br>"+"14."+Datum[i+13]+"<br>"+"15."+Datum[i+14]+"<br>"+"16."+Datum[i+15]+"<br>"+"17."+Datum[i+16]+"<br>"+"18."+Datum[i+17]+"<br>"+"19."+Datum[i+18]+"<br>"+"20."+Datum[i+19]+"</body></html>");
    bExit.setBounds(50, 500, 125, 50);
    bReset.setVisible(false);
      } // end of bDaten_ActionPerformed



  public void bReset_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einf�gen
    lSolldasProgrammwirklichresettetwerden.setVisible(true);
    bJa.setVisible(true);
    bNein.setVisible(true);
    bGuthaben.setVisible(false);
    bDaten.setVisible(false);
    lTennisstunden.setVisible(false);
    bExit.setVisible(false);
    lUebersicht1.setVisible(false);
    bReset.setVisible(false);
    lDieswuerdeeinenNeustarterzwingen.setVisible(true);
     bBackup.setVisible(false);
  } // end of bReset_ActionPerformed

  public void bJa_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einf�gen
   Dateiloeschen(sTennisstunden);
    System.exit(0);
  } // end of bJa_ActionPerformed
  
  public static void Dateiloeschen(String sTennisstunden){
   System.out.println("Datei wird geloescht...");
     try{

       Thread.sleep(1000);
      } catch(InterruptedException ex){
        //do stuff
        }
   File file = new File(sTennisstunden);
    
    
    if(file.exists()){
      file.delete();
    }
    
   }
  public void bNein_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einf�gen
    lSolldasProgrammwirklichresettetwerden.setVisible(false);
    bJa.setVisible(false);
    bNein.setVisible(false);
     bGuthaben.setVisible(true);
    bDaten.setVisible(true);
    lTennisstunden.setVisible(true);
    bExit.setVisible(true);
    lUebersicht1.setVisible(true);
    bReset.setVisible(true);
    lDieswuerdeeinenNeustarterzwingen.setVisible(false);
     bBackup.setVisible(true);
  } // end of bNein_ActionPerformed

  public void bm1_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einf�gen
    cTennisstunden.Uhrzeit=cTennisstunden.Uhrzeit-1;
    lUhrzeit.setText("Uhrzeit: "+Uhrzeit+"Uhr");
  } // end of bm1_ActionPerformed

  public void bp1_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einf�gen
    cTennisstunden.Uhrzeit=cTennisstunden.Uhrzeit+1;
    lUhrzeit.setText("Uhrzeit: "+Uhrzeit+"Uhr");
  } // end of bp1_ActionPerformed

  public void bBackup_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einf�gen
     bBackup.setVisible(false);
    bGuthaben.setVisible(false);
    bDaten.setVisible(false);
    lTennisstunden.setVisible(false);
    bExit.setVisible(false);
    lUebersicht1.setVisible(false);
    bReset.setVisible(false);
    lSolleinBackuperstelltwerden.setVisible(true);
    bJa1.setVisible(true);
    bNein1.setVisible(true); 
  } // end of bBackup_ActionPerformed

  public void bJa1_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einf�gen
   
    lSolleinBackuperstelltwerden.setVisible(false);
    bJa1.setVisible(false);
    bNein1.setVisible(false); 
    lBackupwurdeerfolgreicherstellt.setVisible(true);
    bZurueck3.setVisible(true);
    Backup(sBackup);
     Backup(sBackup);
   
    
  } // end of bJa1_ActionPerformed

  public void bNein1_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einf�gen
    lSolleinBackuperstelltwerden.setVisible(false);
    bJa1.setVisible(false);
    bNein1.setVisible(false);
     bGuthaben.setVisible(true);
    bDaten.setVisible(true);
    lTennisstunden.setVisible(true);
    bExit.setVisible(true);
    lUebersicht1.setVisible(true);
    bReset.setVisible(true);
    lDieswuerdeeinenNeustarterzwingen.setVisible(false);
     bBackup.setVisible(true); 
  } // end of bNein1_ActionPerformed

  public void bZurueck3_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einf�gen
     bGuthaben.setVisible(true);
    bDaten.setVisible(true);
    lTennisstunden.setVisible(true);
    bExit.setVisible(true);
    lUebersicht1.setVisible(true);
    bReset.setVisible(true);
    lDieswuerdeeinenNeustarterzwingen.setVisible(false);
     bBackup.setVisible(true);
     bZurueck3.setVisible(false);
    lBackupwurdeerfolgreicherstellt.setVisible(false);
  } // end of bZurueck3_ActionPerformed
  
  public static void  Backup(String sBackup){
  
   File file = new File(sBackup);  
    try {
       if (!file.createNewFile() ){
        file.delete();
        System.out.println("Backup wurde geloescht");
         }
           
        if (file.createNewFile() ) {
      PrintWriter pWriter = null;
        System.out.println("Backup wurde neu angelegt");
        try {
            pWriter = new PrintWriter(new BufferedWriter(new FileWriter("Tennisstunden-Backup.txt"))); 
            pWriter.println("_Backup_");
           try {
 
         BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
 
         System.out.println("*****************");
         System.out.println("***  Kopieren ***");
         System.out.println("*****************");
 
 
 
         String aktline = "";
         BufferedReader inFile = new BufferedReader (new FileReader ("Tennisstunden.txt"));
         
        
         aktline = inFile.readLine();
        
         while (aktline!= null)
         {
          pWriter.println(aktline);
             
            System.out.println(aktline);
            aktline = inFile.readLine();
         }
         inFile.close();
        
 
    }
 
        catch(Exception ex)
         {
      System.out.println("Irgendwas ist schief gelaufen !!!");
 
      System.out.println(ex.getMessage() );
 
       }
            } catch (IOException ioe) {
            ioe.printStackTrace();     
        } finally {
            if (pWriter != null){
                pWriter.flush();
                pWriter.close();
            }
        }  
      } // end of if
       } catch(Exception e) {
      System.err.println(e);
    } 
    
    
    }
  // Ende Methoden
} // end of class cTennisstunden
 

