/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.ljetnizadatak.view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import katic.ljetnizadatak.model.Korisnik;
import katic.ljetnizadatak.model.Tab;
import static katic.ljetnizadatak.view.FormaAplikacije.KOSARICA;
import static katic.ljetnizadatak.view.FormaAplikacije.MOJI_PODACI;
import static katic.ljetnizadatak.view.FormaAplikacije.ODJAVA;
import static katic.ljetnizadatak.view.FormaAplikacije.POVIJEST_NARUDZBI;
import static katic.ljetnizadatak.view.FormaAplikacije.RESTORANI;
import katic.pomocno.KorisnikListener;
import katic.pomocno.PomagalaIzbornika;
import katic.pomocno.MenuListener;

/**
 *
 * @author Valentin
 */
public class PanelIzbornikKorisnika extends javax.swing.JPanel {

    private MenuListener menuListener;
    private Korisnik korisnik;    
    private int pressedTab = 0;
    private List<Tab> tabovi = new ArrayList<>();   
    
    private JPanel desniPanel = FormaAplikacije.desniPanel;
    
    public PanelIzbornikKorisnika(MenuListener menuListener, Korisnik korisnik) {
        initComponents();
        
        this.menuListener = menuListener;
        this.korisnik = korisnik;
        
        ucitajPanelPrijavljenogKorisnika();
        
        tabovi.add(new Tab(lblRestorani, RESTORANI));
        tabovi.add(new Tab(lblKosarica, KOSARICA));
        tabovi.add(new Tab(lblPovijestNarudzbi, POVIJEST_NARUDZBI));
        tabovi.add(new Tab(lblMojiPodaci, MOJI_PODACI));
        tabovi.add(new Tab(lblOdjava, ODJAVA));
        
        lblIme.setText(korisnik.getIme() + " " + korisnik.getPrezime());
    }
    
    private PanelKosarice panelKosarice;
    private PanelPovijestNarudzbi panelPovijestNarudzbi;
        
    private void ucitajPanelPrijavljenogKorisnika(){  
        
        KorisnikListener korisnikListener = new KorisnikListener() {
            @Override
            public void updateKorisnika(Korisnik k) {
                lblIme.setText(k.getIme() + " " + k.getPrezime());
            }
            
            @Override
            public void updateNarudzbe(){                 
                panelKosarice.osvjeziNarudzbu();
                panelPovijestNarudzbi.osvjeziPovijest();                
            }
            
            @Override
            public void dodanaStaraNarudzba(){
                pressedTab = PomagalaIzbornika.setClickedEffect(tabovi, lblKosarica, menuListener);
                updateNarudzbe();
            }
        };
        
        panelKosarice = new PanelKosarice(korisnik, korisnikListener);
        panelPovijestNarudzbi = new PanelPovijestNarudzbi(menuListener, korisnik, korisnikListener);
        
        desniPanel.removeAll();
        desniPanel.add(new PanelRestoran(menuListener, korisnik, korisnikListener), RESTORANI);
        desniPanel.add(panelKosarice, KOSARICA);
        desniPanel.add(panelPovijestNarudzbi, POVIJEST_NARUDZBI);
        desniPanel.add(new PanelMojiPodaci(menuListener, korisnik, korisnikListener), MOJI_PODACI);
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

        lblRestorani = new javax.swing.JLabel();
        lblKosarica = new javax.swing.JLabel();
        lblPovijestNarudzbi = new javax.swing.JLabel();
        lblMojiPodaci = new javax.swing.JLabel();
        lblOdjava = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblDobrodosli = new javax.swing.JLabel();
        lblIme = new javax.swing.JLabel();

        setBackground(new java.awt.Color(38, 40, 55));

        lblRestorani.setBackground(new java.awt.Color(58, 56, 77));
        lblRestorani.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        lblRestorani.setForeground(new java.awt.Color(204, 204, 204));
        lblRestorani.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/restaurant.png"))); // NOI18N
        lblRestorani.setText("Restorani");
        lblRestorani.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblRestorani.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        lblRestorani.setOpaque(true);
        lblRestorani.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRestoraniMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblRestoraniMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblRestoraniMouseExited(evt);
            }
        });

        lblKosarica.setBackground(new java.awt.Color(38, 40, 55));
        lblKosarica.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        lblKosarica.setForeground(new java.awt.Color(204, 204, 204));
        lblKosarica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/cart.png"))); // NOI18N
        lblKosarica.setText("Košarica");
        lblKosarica.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblKosarica.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        lblKosarica.setOpaque(true);
        lblKosarica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKosaricaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblKosaricaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblKosaricaMouseExited(evt);
            }
        });

        lblPovijestNarudzbi.setBackground(new java.awt.Color(38, 40, 55));
        lblPovijestNarudzbi.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        lblPovijestNarudzbi.setForeground(new java.awt.Color(204, 204, 204));
        lblPovijestNarudzbi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/order_history.png"))); // NOI18N
        lblPovijestNarudzbi.setText("Povijest narudžbi");
        lblPovijestNarudzbi.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblPovijestNarudzbi.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        lblPovijestNarudzbi.setOpaque(true);
        lblPovijestNarudzbi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPovijestNarudzbiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPovijestNarudzbiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblPovijestNarudzbiMouseExited(evt);
            }
        });

        lblMojiPodaci.setBackground(new java.awt.Color(38, 40, 55));
        lblMojiPodaci.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        lblMojiPodaci.setForeground(new java.awt.Color(204, 204, 204));
        lblMojiPodaci.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/user.png"))); // NOI18N
        lblMojiPodaci.setText("Moji podaci");
        lblMojiPodaci.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblMojiPodaci.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        lblMojiPodaci.setOpaque(true);
        lblMojiPodaci.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMojiPodaciMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblMojiPodaciMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblMojiPodaciMouseExited(evt);
            }
        });

        lblOdjava.setBackground(new java.awt.Color(38, 40, 55));
        lblOdjava.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        lblOdjava.setForeground(new java.awt.Color(204, 204, 204));
        lblOdjava.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/signout.png"))); // NOI18N
        lblOdjava.setText("Odjava");
        lblOdjava.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblOdjava.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        lblOdjava.setOpaque(true);
        lblOdjava.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOdjavaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblOdjavaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblOdjavaMouseExited(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(38, 40, 55));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.PAGE_AXIS));

        lblDobrodosli.setFont(new java.awt.Font("Century Gothic", 0, 28)); // NOI18N
        lblDobrodosli.setForeground(new java.awt.Color(204, 204, 204));
        lblDobrodosli.setText("Dobrodošli,");
        jPanel1.add(lblDobrodosli);

        lblIme.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        lblIme.setForeground(new java.awt.Color(204, 204, 204));
        lblIme.setText("Ime Prezime");
        jPanel1.add(lblIme);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRestorani, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblKosarica, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPovijestNarudzbi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMojiPodaci, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOdjava, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblRestorani)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblKosarica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPovijestNarudzbi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMojiPodaci)
                .addGap(149, 149, 149)
                .addComponent(lblOdjava)
                .addContainerGap(37, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblRestoraniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRestoraniMouseClicked
        pressedTab = PomagalaIzbornika.setClickedEffect(tabovi, (JLabel)evt.getComponent(), menuListener);
    }//GEN-LAST:event_lblRestoraniMouseClicked

    private void lblRestoraniMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRestoraniMouseEntered
        PomagalaIzbornika.setHoverEffect((JLabel)evt.getComponent());
    }//GEN-LAST:event_lblRestoraniMouseEntered

    private void lblRestoraniMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRestoraniMouseExited
        PomagalaIzbornika.setUnHoverEffect(tabovi.get(pressedTab), (JLabel)evt.getComponent());
    }//GEN-LAST:event_lblRestoraniMouseExited

    private void lblKosaricaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKosaricaMouseClicked
        pressedTab = PomagalaIzbornika.setClickedEffect(tabovi, (JLabel)evt.getComponent(), menuListener);
    }//GEN-LAST:event_lblKosaricaMouseClicked

    private void lblKosaricaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKosaricaMouseEntered
        PomagalaIzbornika.setHoverEffect((JLabel)evt.getComponent());
    }//GEN-LAST:event_lblKosaricaMouseEntered

    private void lblKosaricaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKosaricaMouseExited
        PomagalaIzbornika.setUnHoverEffect(tabovi.get(pressedTab), (JLabel)evt.getComponent());
    }//GEN-LAST:event_lblKosaricaMouseExited

    private void lblPovijestNarudzbiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPovijestNarudzbiMouseClicked
        pressedTab = PomagalaIzbornika.setClickedEffect(tabovi, (JLabel)evt.getComponent(), menuListener);
    }//GEN-LAST:event_lblPovijestNarudzbiMouseClicked

    private void lblPovijestNarudzbiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPovijestNarudzbiMouseEntered
        PomagalaIzbornika.setHoverEffect((JLabel)evt.getComponent());
    }//GEN-LAST:event_lblPovijestNarudzbiMouseEntered

    private void lblPovijestNarudzbiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPovijestNarudzbiMouseExited
        PomagalaIzbornika.setUnHoverEffect(tabovi.get(pressedTab), (JLabel)evt.getComponent());
    }//GEN-LAST:event_lblPovijestNarudzbiMouseExited

    private void lblMojiPodaciMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMojiPodaciMouseClicked
        pressedTab = PomagalaIzbornika.setClickedEffect(tabovi, (JLabel)evt.getComponent(), menuListener);
    }//GEN-LAST:event_lblMojiPodaciMouseClicked

    private void lblMojiPodaciMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMojiPodaciMouseEntered
        PomagalaIzbornika.setHoverEffect((JLabel)evt.getComponent());
    }//GEN-LAST:event_lblMojiPodaciMouseEntered

    private void lblMojiPodaciMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMojiPodaciMouseExited
        PomagalaIzbornika.setUnHoverEffect(tabovi.get(pressedTab), (JLabel)evt.getComponent());
    }//GEN-LAST:event_lblMojiPodaciMouseExited

    private void lblOdjavaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOdjavaMouseClicked
        pressedTab = PomagalaIzbornika.setClickedEffect(tabovi, (JLabel)evt.getComponent(), menuListener);
    }//GEN-LAST:event_lblOdjavaMouseClicked

    private void lblOdjavaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOdjavaMouseEntered
        PomagalaIzbornika.setHoverEffect((JLabel)evt.getComponent());
    }//GEN-LAST:event_lblOdjavaMouseEntered

    private void lblOdjavaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOdjavaMouseExited
        PomagalaIzbornika.setUnHoverEffect(tabovi.get(pressedTab), (JLabel)evt.getComponent());
    }//GEN-LAST:event_lblOdjavaMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDobrodosli;
    private javax.swing.JLabel lblIme;
    private javax.swing.JLabel lblKosarica;
    private javax.swing.JLabel lblMojiPodaci;
    private javax.swing.JLabel lblOdjava;
    private javax.swing.JLabel lblPovijestNarudzbi;
    private javax.swing.JLabel lblRestorani;
    // End of variables declaration//GEN-END:variables
}
