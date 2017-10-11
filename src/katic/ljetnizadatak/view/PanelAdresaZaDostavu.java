/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.ljetnizadatak.view;

import java.awt.Color;
import katic.ljetnizadatak.controller.ObradaAdresaDostave;
import katic.ljetnizadatak.model.AdresaDostave;
import katic.ljetnizadatak.model.Korisnik;
import katic.pomocno.Iznimka;
import katic.pomocno.Pomagala;

/**
 *
 * @author Valentin
 */
public class PanelAdresaZaDostavu extends javax.swing.JPanel{
    
    private Korisnik korisnik;
    private AdresaDostave entitet;
    private ObradaAdresaDostave obradaAdresaDostave;
    
    public PanelAdresaZaDostavu(Korisnik korisnik, AdresaDostave entitet) {
        initComponents();
        this.korisnik = korisnik;
        this.entitet = entitet;   
        this.obradaAdresaDostave = new ObradaAdresaDostave();
        
        ucitaj();
    }   
    
    
    
    private void ucitaj(){
        if (entitet!=null){
            txtUlica.setText(entitet.getUlica());
            txtKucniBroj.setText(entitet.getKucniBroj());           
            txtGrad.setText(entitet.getGrad());          
        }
    }   
    
    protected void spremi(){
        entitet.setUlica(txtUlica.getText());
        entitet.setKucniBroj(txtKucniBroj.getText());
        entitet.setGrad(txtGrad.getText());
        entitet.setKorisnik(korisnik);
        
        try {
            obradaAdresaDostave.spremi(entitet);
            ucitaj();
        } catch (Iznimka i){
            provjeraGreske(i);        
        }
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDodaj = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        pnlPromijeni = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtGrad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUlica = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        pnlObrisi = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtKucniBroj = new javax.swing.JTextField();

        setBackground(new java.awt.Color(58, 56, 77));

        pnlDodaj.setBackground(new java.awt.Color(125, 86, 192));
        pnlDodaj.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlDodajMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlDodajMouseEntered(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Dodaj");

        javax.swing.GroupLayout pnlDodajLayout = new javax.swing.GroupLayout(pnlDodaj);
        pnlDodaj.setLayout(pnlDodajLayout);
        pnlDodajLayout.setHorizontalGroup(
            pnlDodajLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        pnlDodajLayout.setVerticalGroup(
            pnlDodajLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDodajLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSeparator9.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator11.setForeground(new java.awt.Color(255, 255, 255));

        pnlPromijeni.setBackground(new java.awt.Color(0, 163, 0));
        pnlPromijeni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlPromijeniMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlPromijeniMouseEntered(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Promijeni");

        javax.swing.GroupLayout pnlPromijeniLayout = new javax.swing.GroupLayout(pnlPromijeni);
        pnlPromijeni.setLayout(pnlPromijeniLayout);
        pnlPromijeniLayout.setHorizontalGroup(
            pnlPromijeniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        pnlPromijeniLayout.setVerticalGroup(
            pnlPromijeniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPromijeniLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtGrad.setBackground(new java.awt.Color(58, 56, 77));
        txtGrad.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtGrad.setForeground(new java.awt.Color(255, 255, 255));
        txtGrad.setToolTipText("Unesite vaš grad/naselje");
        txtGrad.setBorder(null);
        txtGrad.setCaretColor(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("KUĆNI BROJ");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("ULICA");

        txtUlica.setBackground(new java.awt.Color(58, 56, 77));
        txtUlica.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtUlica.setForeground(new java.awt.Color(255, 255, 255));
        txtUlica.setToolTipText("Unesite vašu ulicu");
        txtUlica.setBorder(null);
        txtUlica.setCaretColor(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("GRAD");

        jSeparator8.setForeground(new java.awt.Color(255, 255, 255));

        pnlObrisi.setBackground(new java.awt.Color(218, 83, 44));
        pnlObrisi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlObrisiMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlObrisiMouseEntered(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Obriši");

        javax.swing.GroupLayout pnlObrisiLayout = new javax.swing.GroupLayout(pnlObrisi);
        pnlObrisi.setLayout(pnlObrisiLayout);
        pnlObrisiLayout.setHorizontalGroup(
            pnlObrisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        pnlObrisiLayout.setVerticalGroup(
            pnlObrisiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlObrisiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtKucniBroj.setBackground(new java.awt.Color(58, 56, 77));
        txtKucniBroj.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtKucniBroj.setForeground(new java.awt.Color(255, 255, 255));
        txtKucniBroj.setToolTipText("Unesite vaš kućni broj");
        txtKucniBroj.setBorder(null);
        txtKucniBroj.setCaretColor(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtKucniBroj, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUlica, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtGrad, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlPromijeni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUlica, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(7, 7, 7)
                .addComponent(txtKucniBroj, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(11, 11, 11)
                .addComponent(txtGrad, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlPromijeni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pnlDodajMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDodajMouseExited
        pnlDodaj.setBackground(new Color(125,86,192));
    }//GEN-LAST:event_pnlDodajMouseExited

    private void pnlDodajMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDodajMouseEntered
        pnlDodaj.setBackground(new Color(103,33,122));
    }//GEN-LAST:event_pnlDodajMouseEntered

    private void pnlPromijeniMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPromijeniMouseExited
        pnlPromijeni.setBackground(new Color(0,163,0));
    }//GEN-LAST:event_pnlPromijeniMouseExited

    private void pnlPromijeniMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPromijeniMouseEntered
        pnlPromijeni.setBackground(new Color(103,33,122));
    }//GEN-LAST:event_pnlPromijeniMouseEntered

    private void pnlObrisiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlObrisiMouseExited
        pnlObrisi.setBackground(new Color(218,83,44));
    }//GEN-LAST:event_pnlObrisiMouseExited

    private void pnlObrisiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlObrisiMouseEntered
        pnlObrisi.setBackground(new Color(103,33,122));
    }//GEN-LAST:event_pnlObrisiMouseEntered

    private void provjeraGreske(Iznimka i){
        Pomagala.izbaciDialogSGreskom(this, i);
            switch(i.getGreska()){
                case ObradaAdresaDostave.GRAD:
                   txtGrad.requestFocus();
                   break;
                case ObradaAdresaDostave.ULICA:
                   txtUlica.requestFocus();
                   break;
                case ObradaAdresaDostave.KUCNIBROJ:
                   txtKucniBroj.requestFocus();
                   break;
            }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JPanel pnlDodaj;
    private javax.swing.JPanel pnlObrisi;
    private javax.swing.JPanel pnlPromijeni;
    private javax.swing.JTextField txtGrad;
    private javax.swing.JTextField txtKucniBroj;
    private javax.swing.JTextField txtUlica;
    // End of variables declaration//GEN-END:variables
}
