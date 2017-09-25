/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.ljetnizadatak.view;

import java.awt.Component;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author valentin.katic
 */
public class Izbornik extends javax.swing.JFrame {

    /**
     * Creates new form Izbornik
     */
    public Izbornik() {
        this.pack();
        this.setLocationRelativeTo(null);
        initComponents();
    }

    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        restoranButton = new javax.swing.JButton();
        korisnikButton = new javax.swing.JButton();
        kategorijeJelaButton = new javax.swing.JButton();
        btnDijagram = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        restoranButton.setText("Restorani");
        restoranButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restoranButtonActionPerformed(evt);
            }
        });

        korisnikButton.setText("Korisnici");
        korisnikButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                korisnikButtonActionPerformed(evt);
            }
        });

        kategorijeJelaButton.setText("Kategorije jela");
        kategorijeJelaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kategorijeJelaButtonActionPerformed(evt);
            }
        });

        btnDijagram.setText("ERA dijagram");
        btnDijagram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDijagramActionPerformed(evt);
            }
        });

        jLabel1.setText("Izvorni kod: https://github.com/valentinkatic/LjetniZadatak");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDijagram)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(restoranButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(korisnikButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(kategorijeJelaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(restoranButton)
                .addGap(18, 18, 18)
                .addComponent(korisnikButton)
                .addGap(18, 18, 18)
                .addComponent(kategorijeJelaButton)
                .addGap(45, 45, 45)
                .addComponent(btnDijagram)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void restoranButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restoranButtonActionPerformed
        new FormaRestoran().setVisible(true);
    }//GEN-LAST:event_restoranButtonActionPerformed

    private void kategorijeJelaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kategorijeJelaButtonActionPerformed
        new FormaKategorijaJela().setVisible(true);
    }//GEN-LAST:event_kategorijeJelaButtonActionPerformed

    private void korisnikButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_korisnikButtonActionPerformed
        new FormaKorisnik().setVisible(true);
    }//GEN-LAST:event_korisnikButtonActionPerformed

    private void btnDijagramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDijagramActionPerformed
       try {
           String fileName = "/res/dijagram.png";
           File f = new File(getClass().getResource(fileName).getFile());
           Desktop dt = Desktop.getDesktop();
           dt.open(f);
           
        } catch (IOException ex) {
            Logger.getLogger(Izbornik.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDijagramActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        try {
            Runtime.getRuntime().exec("cmd /c start https://github.com/valentinkatic/LjetniZadatak ");
        } catch (IOException ex) {
            Logger.getLogger(Izbornik.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDijagram;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton kategorijeJelaButton;
    private javax.swing.JButton korisnikButton;
    private javax.swing.JButton restoranButton;
    // End of variables declaration//GEN-END:variables
}
