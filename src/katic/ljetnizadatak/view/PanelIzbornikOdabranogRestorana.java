/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.ljetnizadatak.view;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import katic.ljetnizadatak.controller.ObradaKategorijaJela;
import katic.ljetnizadatak.model.KategorijaJela;
import katic.ljetnizadatak.model.Korisnik;
import katic.ljetnizadatak.model.Restoran;
import static katic.ljetnizadatak.view.FormaAplikacije.PONUDA_RESTORANA;
import katic.ljetnizadatak.view.renderer.RendererKategorijaJela;
import katic.pomocno.MenuListener;

/**
 *
 * @author Valentin
 */
public class PanelIzbornikOdabranogRestorana extends javax.swing.JPanel {

    private JPanel desniPanel = FormaAplikacije.desniPanel;
    
    private ObradaKategorijaJela obradaKategorijaJela; 
    private Korisnik korisnik;
    private Restoran restoran;
    private MenuListener menuListener;
    protected KategorijaJela entitet;
    
    public PanelIzbornikOdabranogRestorana(Korisnik korisnik, Restoran restoran, MenuListener menuListener) {
        this.korisnik = korisnik;
        this.restoran = restoran;
        this.menuListener = menuListener;
        initComponents();
        
        lblBack.setText(restoran.getNaziv());
        obradaKategorijaJela = new ObradaKategorijaJela();
        ucitaj();
    }
    
     private void ucitaj(){       
        DefaultListModel<KategorijaJela> m = new DefaultListModel<>();
        lista.setModel(m);
        for (KategorijaJela k: restoran.getKategorijeJela()){
            m.addElement(k);
        }
        
        if (entitet!=null){            
            lista.setSelectedValue(entitet, false);
        }
        
        ucitajOdabranuKategoriju(null);
    }
     
    private void ucitajOdabranuKategoriju(KategorijaJela kategorijaJela){
        desniPanel.add(new PanelOdabraneKategorije(korisnik, restoran, kategorijaJela), PONUDA_RESTORANA);
        ((CardLayout) desniPanel.getLayout()).show(desniPanel, PONUDA_RESTORANA);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        lblBack = new javax.swing.JLabel();

        setBackground(new java.awt.Color(38, 40, 55));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        lista.setBackground(new java.awt.Color(38, 40, 55));
        lista.setToolTipText("");
        lista.setCellRenderer(new RendererKategorijaJela());
        lista.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lista);

        lblBack.setBackground(new java.awt.Color(38, 40, 55));
        lblBack.setFont(new java.awt.Font("Century Gothic", 0, 22)); // NOI18N
        lblBack.setForeground(new java.awt.Color(204, 204, 204));
        lblBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/back.png"))); // NOI18N
        lblBack.setText("Restoran");
        lblBack.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 1));
        lblBack.setOpaque(true);
        lblBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBackMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBackMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblBack)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void listaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaValueChanged
        try{
            this.entitet = lista.getSelectedValue();
            ucitajOdabranuKategoriju(entitet);
        } catch (Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_listaValueChanged

    private void lblBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseClicked
        menuListener.onBackPressed(PONUDA_RESTORANA);
    }//GEN-LAST:event_lblBackMouseClicked

    private void lblBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseExited
        lblBack.setBackground(new Color(38,40,55));
    }//GEN-LAST:event_lblBackMouseExited

    private void lblBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseEntered
        lblBack.setBackground(new Color(103,33,122));
    }//GEN-LAST:event_lblBackMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBack;
    private javax.swing.JList<KategorijaJela> lista;
    // End of variables declaration//GEN-END:variables
}
