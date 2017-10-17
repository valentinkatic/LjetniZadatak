/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.ljetnizadatak.view;

import java.awt.CardLayout;
import katic.ljetnizadatak.model.KategorijaJela;
import katic.ljetnizadatak.model.Korisnik;
import katic.ljetnizadatak.model.Narudzba;
import katic.ljetnizadatak.model.Restoran;
import katic.pomocno.KorisnikListener;
import katic.pomocno.MenuListener;

/**
 *
 * @author valentin.katic
 */
public class FormaAplikacije extends javax.swing.JFrame {

    public static String START = "START";
    public static String USERPANEL = "USERPANEL";
    public static String RESTAURANTPANEL = "RESTAURANTPANEL";
    
    public static String PRIJAVA = "PRIJAVA";
    public static String REGISTRACIJA = "REGISTRACIJA";
    
    public static String RESTORANI = "RESTORANI";
    public static String KOSARICA = "KOSARICA";
    public static String POVIJEST_NARUDZBI = "POVIJEST_NARUDZBI";
    public static String MOJI_PODACI = "MOJI_PODACI";
    public static String ODJAVA = "ODJAVA";
    
    public static String ADRESE_DOSTAVE = "ADRESE_DOSTAVE";
    public static String PONUDA_RESTORANA = "PONUDA_RESTORANA";
    
    public static String PODACI_RESTORANA = "PODACI_RESTORANA";
    public static String LISTA_KATEGORIJA = "LISTA_KATEGORIJA";
    public static String NARUDZBE = "NARUDZBE";
    public static String ODABRANA_NARUDZBA = "ODABRANA_NARUDZBA";
    public static String JELO = "JELO";
    
    private Korisnik korisnik = null;
    private Restoran restoran = null;
    
    private MenuListener menuListener = null;
    
    private CardLayout layoutLijevogPanela;
    private CardLayout layoutDesnogPanela;   
    
    private PanelStart panelStart;
    
    public FormaAplikacije() {
        initComponents();
        pocetnoUcitavanje();

        layoutLijevogPanela = (CardLayout) lijeviPanel.getLayout();
        layoutDesnogPanela = (CardLayout) desniPanel.getLayout();
        
    }
    
    private void pocetnoUcitavanje(){
        menuListener = new MenuListener() {
            @Override
            public void promjenaDesnogPanela(String panel) {
                try {
                    layoutDesnogPanela.show(desniPanel, panel);                    
                } catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onUserSignIn(String panel, Korisnik kor) {
                korisnik = kor;
                PanelIzbornikKorisnika panelIzbornikKorisnika = new PanelIzbornikKorisnika(menuListener, korisnik);
                lijeviPanel.add(panelIzbornikKorisnika, USERPANEL);
                layoutLijevogPanela.show(lijeviPanel, panel);                
            }
            
            @Override
            public void onRestaurantSignIn(String panel, Restoran rest) {
                restoran = rest;
                PanelIzbornikRestorana panelIzbornikRestorana = new PanelIzbornikRestorana(menuListener, restoran);
                lijeviPanel.add(panelIzbornikRestorana, RESTAURANTPANEL);
                layoutLijevogPanela.show(lijeviPanel, panel);                
            }
            
            @Override
            public void promjenaLijevogPanela(String lijeviPnl, String desniPnl){
                if (lijeviPnl.equals(ADRESE_DOSTAVE)){
                    lijeviPanel.add(new PanelIzbornikAdresaZaDostavu(korisnik, menuListener), lijeviPnl);
                    layoutLijevogPanela.show(lijeviPanel, lijeviPnl);
                    layoutDesnogPanela.show(desniPanel, lijeviPnl);
                }                
            }
            
            @Override
            public void odabraniRestoran(Restoran restoran, KorisnikListener korisnikListener){
                lijeviPanel.add(new PanelIzbornikOdabranogRestorana(korisnik, restoran, menuListener, korisnikListener), PONUDA_RESTORANA);
                layoutLijevogPanela.show(lijeviPanel, PONUDA_RESTORANA);
            }
            
            @Override
            public void odabranaKategorija(Restoran restoran, KategorijaJela kategorijaJela){
                lijeviPanel.add(new PanelIzbornikOdabraneKategorije(restoran, kategorijaJela, menuListener), LISTA_KATEGORIJA);
                layoutLijevogPanela.show(lijeviPanel, LISTA_KATEGORIJA);
            }
            
            @Override
            public void odabranaNarudzba(Narudzba narudzba, KorisnikListener korisnikListener){
                if (restoran!=null){
                    desniPanel.add(new PanelOtvoreneNarudzbe(narudzba, menuListener), ODABRANA_NARUDZBA);
                    layoutDesnogPanela.show(desniPanel, ODABRANA_NARUDZBA);
                } else if (korisnik!=null){
                    desniPanel.add(new PanelOtvoreneNarudzbe(narudzba, korisnik, menuListener, korisnikListener), ODABRANA_NARUDZBA);
                    layoutDesnogPanela.show(desniPanel, ODABRANA_NARUDZBA);
                }
            }
            
            @Override
            public void onBackPressed(String panel){
                if (korisnik!=null){
                    layoutLijevogPanela.show(lijeviPanel, USERPANEL);
                    if (panel.equals(ADRESE_DOSTAVE)){                   
                        layoutDesnogPanela.show(desniPanel, MOJI_PODACI);
                    }
                    else if (panel.equals(PONUDA_RESTORANA)){            
                        layoutDesnogPanela.show(desniPanel, RESTORANI);
                    } else if (panel.equals(ODABRANA_NARUDZBA)){
                        layoutDesnogPanela.show(desniPanel, POVIJEST_NARUDZBI);
                    }                   
                } else if (restoran!=null){
                    layoutLijevogPanela.show(lijeviPanel, RESTAURANTPANEL);
                    if (panel.equals(LISTA_KATEGORIJA)){            
                        layoutDesnogPanela.show(desniPanel, LISTA_KATEGORIJA);
                    } else if (panel.equals(ODABRANA_NARUDZBA)){
                        layoutDesnogPanela.show(desniPanel, NARUDZBE);
                    }
                }
            }
            
            @Override
            public void onSignOut() {
                korisnik = null;
                restoran = null;
                layoutLijevogPanela.show(lijeviPanel, START);
                panelStart.setTabPrijave();
                ucitajPocetniDesniPanel();
            }
        };
        panelStart = new PanelStart(menuListener);
        lijeviPanel.add(panelStart, START);
        
        ucitajPocetniDesniPanel();
    }
    
    private void ucitajPocetniDesniPanel(){
        desniPanel.removeAll();
        desniPanel.add(new PanelPrijave(menuListener), PRIJAVA);
        desniPanel.add(new PanelRegistracije(menuListener), REGISTRACIJA);
        desniPanel.validate();
        desniPanel.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lijeviPanel = new javax.swing.JPanel();
        desniPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ljetni zadatak");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setMinimumSize(new java.awt.Dimension(700, 500));
        setSize(700,500);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        lijeviPanel.setBackground(new java.awt.Color(38, 40, 55));
        lijeviPanel.setMaximumSize(new java.awt.Dimension(300, 500));
        lijeviPanel.setMinimumSize(new java.awt.Dimension(300, 500));
        lijeviPanel.setPreferredSize(new java.awt.Dimension(300, 500));
        lijeviPanel.setLayout(new java.awt.CardLayout());
        getContentPane().add(lijeviPanel);
        lijeviPanel.getAccessibleContext().setAccessibleName("");

        desniPanel.setBackground(new java.awt.Color(58, 56, 77));
        desniPanel.setMaximumSize(new java.awt.Dimension(400, 500));
        desniPanel.setMinimumSize(new java.awt.Dimension(400, 500));
        desniPanel.setLayout(new java.awt.CardLayout());
        getContentPane().add(desniPanel);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {      
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormaAplikacije().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel desniPanel;
    public static javax.swing.JPanel lijeviPanel;
    // End of variables declaration//GEN-END:variables
}
