/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.ljetnizadatak.view;

import java.awt.CardLayout;
import java.awt.Component;
import katic.ljetnizadatak.model.AdresaDostave;
import katic.ljetnizadatak.model.Korisnik;
import katic.ljetnizadatak.model.Restoran;
import katic.pomocno.AddressListener;
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
    
    private Korisnik korisnik = null;
    private Restoran restoran = null;
    
    private MenuListener menuListener = null;
    private AddressListener addressListener;
    
    private CardLayout layoutLijevogPanela;
    private CardLayout layoutDesnogPanela;
    
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
                lijeviPanel.add(new PanelIzbornikKorisnika(menuListener, korisnik), USERPANEL);
                layoutLijevogPanela.show(lijeviPanel, panel);
                ucitajPanelPrijavljenogKorisnika();
                
            }
            
            @Override
            public void onRestaurantSignIn(String panel, Restoran rest) {
                restoran = rest;
                layoutLijevogPanela.show(lijeviPanel, panel);
                ucitajPanelPrijavljenogKorisnika();
                
            }
            
            @Override
            public void promjenaLijevogPanela(String lijeviPnl, String desniPnl){
                if (lijeviPnl.equals(ADRESE_DOSTAVE)){
                    lijeviPanel.add(new PanelIzbornikAdresaZaDostavu(korisnik, menuListener, addressListener), lijeviPnl);
                    layoutLijevogPanela.show(lijeviPanel, lijeviPnl);
                    layoutDesnogPanela.show(desniPanel, lijeviPnl);
                } 
                
            }
            
            @Override
            public void onBackPressed(String panel){
                if (panel.equals(ADRESE_DOSTAVE)){                   
                    layoutLijevogPanela.show(lijeviPanel, USERPANEL);
                    layoutDesnogPanela.show(desniPanel, MOJI_PODACI);
                    Component[] components = desniPanel.getComponents();
                    for(int i = 0; i < components.length; i++) {
                        
                            System.out.println(components[i].getName());
                        if(components[i].getName().equals(ADRESE_DOSTAVE)) {
                            layoutDesnogPanela.removeLayoutComponent(components[i]);
                        }                        
                    }
                }
            }
            
            @Override
            public void onSignOut() {
                korisnik = null;
                restoran = null;
                layoutLijevogPanela.show(lijeviPanel, START);
                ucitajPocetniDesniPanel();
            }
        };
        
        lijeviPanel.add(new PanelStart(menuListener), START);
        
        ucitajPocetniDesniPanel();
    }
    
    private void ucitajPocetniDesniPanel(){
        desniPanel.removeAll();
        desniPanel.add(new PanelPrijave(menuListener), PRIJAVA);
        desniPanel.add(new PanelRegistracije(), REGISTRACIJA);
        desniPanel.validate();
        desniPanel.repaint();
    }
    
    private void ucitajPanelPrijavljenogKorisnika(){       
        addressListener = new AddressListener() {
            @Override
            public void izabranaAdresa(AdresaDostave adresaDostave) {
                desniPanel.add(new PanelAdresaZaDostavu(korisnik, adresaDostave), ADRESE_DOSTAVE);
                layoutDesnogPanela.show(desniPanel, ADRESE_DOSTAVE);
            }
        };
        
        desniPanel.removeAll();
        desniPanel.add(new PanelRestoran(menuListener, korisnik), RESTORANI);
        desniPanel.add(new PanelMojiPodaci(menuListener, korisnik), MOJI_PODACI);
        desniPanel.add(new PanelAdresaZaDostavu(korisnik, null), ADRESE_DOSTAVE);
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
        setMaximumSize(new java.awt.Dimension(700, 500));
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
    private javax.swing.JPanel desniPanel;
    private javax.swing.JPanel lijeviPanel;
    // End of variables declaration//GEN-END:variables
}
