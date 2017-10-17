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
import katic.ljetnizadatak.model.Restoran;
import katic.ljetnizadatak.model.Tab;
import katic.pomocno.PomagalaIzbornika;
import katic.pomocno.MenuListener;
import katic.pomocno.RestoranListener;

/**
 *
 * @author Valentin
 */
public class PanelIzbornikRestorana extends javax.swing.JPanel {

    private MenuListener menuListener;
    private Restoran restoran;
    private int pressedTab = 0;
    private List<Tab> tabovi = new ArrayList<>();   
    
    private JPanel desniPanel = FormaAplikacije.desniPanel;
    
    public PanelIzbornikRestorana(MenuListener menuListener, Restoran restoran) {
        initComponents();
        
        this.menuListener = menuListener;
        this.restoran = restoran;
        
        ucitajPanelPrijavljenogRestorana();
        
        tabovi.add(new Tab(lblPodaciRestorana, FormaAplikacije.PODACI_RESTORANA));
        tabovi.add(new Tab(lblListaJela, FormaAplikacije.LISTA_KATEGORIJA));
        tabovi.add(new Tab(lblNarudzbe, FormaAplikacije.NARUDZBE));
        tabovi.add(new Tab(lblOdjava, FormaAplikacije.ODJAVA));
        
        lblIme.setText(restoran.getNaziv());
    }
    
    private void ucitajPanelPrijavljenogRestorana(){ 
        RestoranListener restoranListener = new RestoranListener() {
            @Override
            public void updateRestorana(Restoran restoran) {
                lblIme.setText(restoran.getNaziv());
            }
        };
        
        desniPanel.removeAll();
        desniPanel.add(new PanelPodaciRestorana(menuListener, restoran, restoranListener), FormaAplikacije.PODACI_RESTORANA);
        desniPanel.add(new PanelKategorijeJela(menuListener, restoran), FormaAplikacije.LISTA_KATEGORIJA);
        desniPanel.add(new PanelNarudzbe(menuListener, restoran), FormaAplikacije.NARUDZBE);
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

        lblPodaciRestorana = new javax.swing.JLabel();
        lblListaJela = new javax.swing.JLabel();
        lblOdjava = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblDobrodosli = new javax.swing.JLabel();
        lblIme = new javax.swing.JLabel();
        lblNarudzbe = new javax.swing.JLabel();

        setBackground(new java.awt.Color(38, 40, 55));

        lblPodaciRestorana.setBackground(new java.awt.Color(58, 56, 77));
        lblPodaciRestorana.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        lblPodaciRestorana.setForeground(new java.awt.Color(204, 204, 204));
        lblPodaciRestorana.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/home.png"))); // NOI18N
        lblPodaciRestorana.setText("Podaci restorana");
        lblPodaciRestorana.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblPodaciRestorana.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        lblPodaciRestorana.setOpaque(true);
        lblPodaciRestorana.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPodaciRestoranaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblPodaciRestoranaMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPodaciRestoranaMouseEntered(evt);
            }
        });

        lblListaJela.setBackground(new java.awt.Color(38, 40, 55));
        lblListaJela.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        lblListaJela.setForeground(new java.awt.Color(204, 204, 204));
        lblListaJela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/list.png"))); // NOI18N
        lblListaJela.setText("Kategorije jela");
        lblListaJela.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblListaJela.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        lblListaJela.setOpaque(true);
        lblListaJela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblListaJelaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblListaJelaMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblListaJelaMouseEntered(evt);
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
        lblIme.setText("Naziv restorana");
        jPanel1.add(lblIme);

        lblNarudzbe.setBackground(new java.awt.Color(38, 40, 55));
        lblNarudzbe.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        lblNarudzbe.setForeground(new java.awt.Color(204, 204, 204));
        lblNarudzbe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/order_history.png"))); // NOI18N
        lblNarudzbe.setText("Narudžbe");
        lblNarudzbe.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblNarudzbe.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        lblNarudzbe.setOpaque(true);
        lblNarudzbe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNarudzbeMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblNarudzbeMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblNarudzbeMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPodaciRestorana, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblListaJela, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOdjava, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNarudzbe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPodaciRestorana)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblListaJela)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNarudzbe)
                .addGap(195, 195, 195)
                .addComponent(lblOdjava)
                .addContainerGap(37, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblPodaciRestoranaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPodaciRestoranaMouseClicked
        pressedTab = PomagalaIzbornika.setClickedEffect(tabovi, (JLabel)evt.getComponent(), menuListener);
    }//GEN-LAST:event_lblPodaciRestoranaMouseClicked

    private void lblPodaciRestoranaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPodaciRestoranaMouseEntered
        PomagalaIzbornika.setHoverEffect((JLabel)evt.getComponent());
    }//GEN-LAST:event_lblPodaciRestoranaMouseEntered

    private void lblPodaciRestoranaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPodaciRestoranaMouseExited
        PomagalaIzbornika.setUnHoverEffect(tabovi.get(pressedTab), (JLabel)evt.getComponent());
    }//GEN-LAST:event_lblPodaciRestoranaMouseExited

    private void lblListaJelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblListaJelaMouseClicked
        pressedTab = PomagalaIzbornika.setClickedEffect(tabovi, (JLabel)evt.getComponent(), menuListener);
    }//GEN-LAST:event_lblListaJelaMouseClicked

    private void lblListaJelaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblListaJelaMouseEntered
        PomagalaIzbornika.setHoverEffect((JLabel)evt.getComponent());
    }//GEN-LAST:event_lblListaJelaMouseEntered

    private void lblListaJelaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblListaJelaMouseExited
        PomagalaIzbornika.setUnHoverEffect(tabovi.get(pressedTab), (JLabel)evt.getComponent());
    }//GEN-LAST:event_lblListaJelaMouseExited

    private void lblOdjavaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOdjavaMouseClicked
        pressedTab = PomagalaIzbornika.setClickedEffect(tabovi, (JLabel)evt.getComponent(), menuListener);
    }//GEN-LAST:event_lblOdjavaMouseClicked

    private void lblOdjavaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOdjavaMouseEntered
        PomagalaIzbornika.setHoverEffect((JLabel)evt.getComponent());
    }//GEN-LAST:event_lblOdjavaMouseEntered

    private void lblOdjavaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOdjavaMouseExited
        PomagalaIzbornika.setUnHoverEffect(tabovi.get(pressedTab), (JLabel)evt.getComponent());
    }//GEN-LAST:event_lblOdjavaMouseExited

    private void lblNarudzbeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNarudzbeMouseClicked
        pressedTab = PomagalaIzbornika.setClickedEffect(tabovi, (JLabel)evt.getComponent(), menuListener);
    }//GEN-LAST:event_lblNarudzbeMouseClicked

    private void lblNarudzbeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNarudzbeMouseExited
        PomagalaIzbornika.setUnHoverEffect(tabovi.get(pressedTab), (JLabel)evt.getComponent());
    }//GEN-LAST:event_lblNarudzbeMouseExited

    private void lblNarudzbeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNarudzbeMouseEntered
        PomagalaIzbornika.setHoverEffect((JLabel)evt.getComponent());
    }//GEN-LAST:event_lblNarudzbeMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDobrodosli;
    private javax.swing.JLabel lblIme;
    private javax.swing.JLabel lblListaJela;
    private javax.swing.JLabel lblNarudzbe;
    private javax.swing.JLabel lblOdjava;
    private javax.swing.JLabel lblPodaciRestorana;
    // End of variables declaration//GEN-END:variables
}
