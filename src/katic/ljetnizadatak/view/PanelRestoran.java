/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.ljetnizadatak.view;

import javax.swing.DefaultListModel;
import katic.ljetnizadatak.controller.ObradaRestoran;
import katic.ljetnizadatak.model.Restoran;
import katic.pomocno.Iznimka;
import katic.pomocno.Pomagala;

/**
 *
 * @author valentin.katic
 */
public class PanelRestoran extends javax.swing.JPanel {

    private ObradaRestoran obrada;
    private Restoran entitet;
    /**
     * Creates new form PanelRestoran
     */
    public PanelRestoran() {
        initComponents();
        
        this.obrada = new ObradaRestoran();      
        ucitaj();
    }

    protected void ucitaj(){
        DefaultListModel<Restoran> m = new DefaultListModel<Restoran>();
        lista.setModel(m);
        for (Restoran r: obrada.getRestorane()){
            m.addElement(r);
        }
        if (entitet!=null){
            lista.setSelectedValue(entitet, true);
        }  
    }

    protected void spremi(){ 
        entitet.setNaziv(txtNaziv.getText());
        entitet.setAdresa(txtAdresa.getText());
        entitet.setGrad(txtGrad.getText());
        entitet.setKontaktBroj(txtKontaktBroj.getText());
        entitet.setEmail(txtEmail.getText());
        entitet.setLozinka(txtLozinka.getText()); 
        try {
            entitet = obrada.spremi(entitet);
        } catch (Iznimka i) {
            provjeraGreske(i);
        }
        ucitaj();
    }
    
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
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtGrad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtKontaktBroj = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtLozinka = new javax.swing.JTextField();
        txtNaziv = new javax.swing.JTextField();
        btnDodaj = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnPromijeni = new javax.swing.JButton();
        txtAdresa = new javax.swing.JTextField();
        btnObrisi = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnListaJela = new javax.swing.JButton();

        jLabel4.setText("Kontakt broj");

        jLabel5.setText("Email");

        lista.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lista);

        jLabel6.setText("Lozinka");

        jLabel1.setText("Naziv");

        btnDodaj.setText("Dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        jLabel2.setText("Adresa");

        btnPromijeni.setText("Promijeni");
        btnPromijeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromijeniActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obriši");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        jLabel3.setText("Grad");

        btnListaJela.setText("Lista jela");
        btnListaJela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaJelaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtGrad, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtKontaktBroj, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(btnDodaj)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnPromijeni))
                                        .addComponent(txtLozinka, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 166, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnListaJela)
                                .addGap(39, 248, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnObrisi)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtGrad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtKontaktBroj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLozinka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodaj)
                    .addComponent(btnPromijeni))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListaJela)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnObrisi)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void listaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaValueChanged
        if (lista.getSelectedValue()==null){
            return;
        }
        try{
            entitet = lista.getSelectedValue();
            txtNaziv.setText(entitet.getNaziv());
            txtAdresa.setText(entitet.getAdresa());
            txtGrad.setText(entitet.getGrad());
            txtKontaktBroj.setText(entitet.getKontaktBroj());
            txtEmail.setText(entitet.getEmail());
            txtLozinka.setText(entitet.getLozinka());
        } catch (Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_listaValueChanged

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        entitet = new Restoran();
        spremi();
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnPromijeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromijeniActionPerformed
        if (!Pomagala.provjeriJelOznaceno(lista, this)){
            return;
        }
        spremi();
    }//GEN-LAST:event_btnPromijeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        if (!Pomagala.provjeriJelOznaceno(lista, this)){
            return;
        }
        try {
            obrada.obrisi(entitet);
            ucitaj();
        } catch (Iznimka ex) {
            provjeraGreske(ex);
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnListaJelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaJelaActionPerformed
        if (!Pomagala.provjeriJelOznaceno(lista, this)){
            return;
        }
        new FormaJelo(entitet).setVisible(true);
    }//GEN-LAST:event_btnListaJelaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnListaJela;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPromijeni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Restoran> lista;
    private javax.swing.JTextField txtAdresa;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtGrad;
    private javax.swing.JTextField txtKontaktBroj;
    private javax.swing.JTextField txtLozinka;
    private javax.swing.JTextField txtNaziv;
    // End of variables declaration//GEN-END:variables
}