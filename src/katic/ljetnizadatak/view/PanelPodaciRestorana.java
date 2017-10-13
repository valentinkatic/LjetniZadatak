/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.ljetnizadatak.view;

import java.awt.Color;
import katic.ljetnizadatak.controller.ObradaKorisnik;
import katic.ljetnizadatak.controller.ObradaRestoran;
import katic.ljetnizadatak.model.Korisnik;
import katic.ljetnizadatak.model.Restoran;
import katic.pomocno.Iznimka;
import katic.pomocno.MenuListener;
import katic.pomocno.Pomagala;

/**
 *
 * @author Valentin
 */
public class PanelPodaciRestorana extends javax.swing.JPanel {

    private MenuListener menuListener;
    private Restoran restoran;
    private ObradaRestoran obrada;
    
    public PanelPodaciRestorana(MenuListener menuListener, Restoran restoran) {
        initComponents();
        this.menuListener = menuListener;
        this.restoran = restoran;
        
        obrada = new ObradaRestoran();
        ucitaj();
    }

    private void ucitaj(){
        txtNaziv.setText(restoran.getNaziv());
        txtAdresa.setText(restoran.getAdresa());
        txtGrad.setText(restoran.getGrad());
        txtKontaktBroj.setText(restoran.getKontaktBroj());
        txtEmail.setText(restoran.getEmail());
        txtLozinka.setText(restoran.getLozinka());
    }
    
    private void spremi(){
        restoran.setNaziv(txtNaziv.getText());
        restoran.setAdresa(txtAdresa.getText());
        restoran.setGrad(txtGrad.getText());
        restoran.setKontaktBroj(txtKontaktBroj.getText());
        restoran.setEmail(txtEmail.getText());
        restoran.setLozinka(String.valueOf(txtLozinka.getPassword()));
        try{
            restoran = obrada.spremi(restoran);
        } catch (Iznimka i){
            provjeraGreske(i);
        }
        ucitaj();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSpremi = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtGrad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        txtLozinka = new javax.swing.JPasswordField();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        txtKontaktBroj = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        txtNaziv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAdresa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(58, 56, 77));
        setForeground(new java.awt.Color(255, 255, 255));

        pnlSpremi.setBackground(new java.awt.Color(0, 163, 0));
        pnlSpremi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSpremiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlSpremiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlSpremiMouseExited(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Spremi");

        javax.swing.GroupLayout pnlSpremiLayout = new javax.swing.GroupLayout(pnlSpremi);
        pnlSpremi.setLayout(pnlSpremiLayout);
        pnlSpremiLayout.setHorizontalGroup(
            pnlSpremiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        pnlSpremiLayout.setVerticalGroup(
            pnlSpremiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSpremiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtGrad.setBackground(new java.awt.Color(58, 56, 77));
        txtGrad.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtGrad.setForeground(new java.awt.Color(255, 255, 255));
        txtGrad.setToolTipText("Unesite grad u kojem se restoran nalazi");
        txtGrad.setBorder(null);
        txtGrad.setCaretColor(new java.awt.Color(255, 255, 255));
        txtGrad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGradActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("ADRESA");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("GRAD");

        jSeparator8.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator13.setForeground(new java.awt.Color(255, 255, 255));

        txtLozinka.setBackground(new java.awt.Color(58, 56, 77));
        txtLozinka.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtLozinka.setForeground(new java.awt.Color(255, 255, 255));
        txtLozinka.setToolTipText("Unesite lozinku koju ćete koristiti");
        txtLozinka.setBorder(null);
        txtLozinka.setCaretColor(new java.awt.Color(255, 255, 255));
        txtLozinka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLozinkaActionPerformed(evt);
            }
        });

        jSeparator14.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator9.setForeground(new java.awt.Color(255, 255, 255));

        txtKontaktBroj.setBackground(new java.awt.Color(58, 56, 77));
        txtKontaktBroj.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtKontaktBroj.setForeground(new java.awt.Color(255, 255, 255));
        txtKontaktBroj.setToolTipText("Unesite kontakt broj restorana");
        txtKontaktBroj.setBorder(null);
        txtKontaktBroj.setCaretColor(new java.awt.Color(255, 255, 255));
        txtKontaktBroj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKontaktBrojActionPerformed(evt);
            }
        });

        jSeparator10.setForeground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("KONTAKT BROJ");

        jSeparator11.setForeground(new java.awt.Color(255, 255, 255));

        txtNaziv.setBackground(new java.awt.Color(58, 56, 77));
        txtNaziv.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtNaziv.setForeground(new java.awt.Color(255, 255, 255));
        txtNaziv.setToolTipText("Unesite naziv restorana");
        txtNaziv.setBorder(null);
        txtNaziv.setCaretColor(new java.awt.Color(255, 255, 255));
        txtNaziv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNazivActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("EMAIL");

        txtEmail.setBackground(new java.awt.Color(58, 56, 77));
        txtEmail.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(255, 255, 255));
        txtEmail.setToolTipText("Unesite email adresu restorana");
        txtEmail.setBorder(null);
        txtEmail.setCaretColor(new java.awt.Color(255, 255, 255));
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("LOZINKA");

        txtAdresa.setBackground(new java.awt.Color(58, 56, 77));
        txtAdresa.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtAdresa.setForeground(new java.awt.Color(255, 255, 255));
        txtAdresa.setToolTipText("Unesite adresu restorana");
        txtAdresa.setBorder(null);
        txtAdresa.setCaretColor(new java.awt.Color(255, 255, 255));
        txtAdresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdresaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("NAZIV");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLozinka, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKontaktBroj, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGrad, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(pnlSpremi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLozinka, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(5, 5, 5)
                .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel5)
                .addGap(3, 3, 3)
                .addComponent(txtAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtGrad, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtKontaktBroj, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSpremi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pnlSpremiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSpremiMouseExited
        pnlSpremi.setBackground(new Color(0,163,0));
    }//GEN-LAST:event_pnlSpremiMouseExited

    private void pnlSpremiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSpremiMouseEntered
        pnlSpremi.setBackground(new Color(103,33,122));
    }//GEN-LAST:event_pnlSpremiMouseEntered

    private void pnlSpremiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSpremiMouseClicked
        spremi();
    }//GEN-LAST:event_pnlSpremiMouseClicked

    private void txtGradActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGradActionPerformed
        txtKontaktBroj.requestFocus();
    }//GEN-LAST:event_txtGradActionPerformed

    private void txtLozinkaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLozinkaActionPerformed
        txtNaziv.requestFocus();
    }//GEN-LAST:event_txtLozinkaActionPerformed

    private void txtKontaktBrojActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKontaktBrojActionPerformed
        spremi();
    }//GEN-LAST:event_txtKontaktBrojActionPerformed

    private void txtNazivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNazivActionPerformed
        txtAdresa.requestFocus();
    }//GEN-LAST:event_txtNazivActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        txtLozinka.requestFocus();
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtAdresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdresaActionPerformed
        txtGrad.requestFocus();
    }//GEN-LAST:event_txtAdresaActionPerformed

    private void provjeraGreske(Iznimka i){
        Pomagala.izbaciDialogSGreskom(this, i);
            switch(i.getGreska()){
                case ObradaRestoran.NAZIV:
                   txtNaziv.requestFocus();
                   break;
                case ObradaRestoran.GRAD:
                   txtGrad.requestFocus();
                   break;
                case ObradaRestoran.KONTAKT_BROJ:
                   txtKontaktBroj.requestFocus();
                   break;
                case ObradaRestoran.EMAIL:
                   txtEmail.requestFocus();
                   break;
                case ObradaRestoran.LOZINKA:
                   txtLozinka.requestFocus();
                   break;
            }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JPanel pnlSpremi;
    private javax.swing.JTextField txtAdresa;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtGrad;
    private javax.swing.JTextField txtKontaktBroj;
    private javax.swing.JPasswordField txtLozinka;
    private javax.swing.JTextField txtNaziv;
    // End of variables declaration//GEN-END:variables
}