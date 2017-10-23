/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.ljetnizadatak.view;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListCellRenderer;
import katic.ljetnizadatak.controller.ObradaAdresaDostave;
import katic.ljetnizadatak.controller.ObradaJelo;
import katic.ljetnizadatak.controller.ObradaKategorijaJela;
import katic.ljetnizadatak.model.Jelo;
import katic.ljetnizadatak.model.KategorijaJela;
import katic.ljetnizadatak.model.Restoran;
import katic.ljetnizadatak.view.renderer.RendererKategorijaComboBox;
import katic.pomocno.Iznimka;
import katic.pomocno.JeloListener;
import katic.pomocno.Pomagala;

/**
 *
 * @author Valentin
 */
public class PanelJelo extends javax.swing.JPanel{
    
    private Restoran restoran;
    private Jelo entitet;
    private KategorijaJela kategorijaJela;
    private List<KategorijaJela> kategorijeJela;
    private ObradaJelo obradaJelo;
    private ObradaKategorijaJela obradaKategorijaJela;
    private JeloListener jeloListener;
    
    public PanelJelo(Restoran restoran, Jelo jelo, KategorijaJela kategorijaJela, JeloListener jeloListener) {
        initComponents();
        this.restoran = restoran;
        this.entitet = jelo;   
        this.kategorijaJela = kategorijaJela;
        this.jeloListener = jeloListener;
        this.obradaJelo = new ObradaJelo();
        this.obradaKategorijaJela = new ObradaKategorijaJela();
        ucitaj();
        ucitajKategorije();
    }   
    
    public void setJelo(Jelo jelo){
        this.entitet = jelo;
        ucitaj();
    }
    
    private void ucitajKategorije(){
        kategorijeJela = obradaKategorijaJela.getKategorijeJela();
        DefaultComboBoxModel<KategorijaJela> cbm = new DefaultComboBoxModel<>();
        cmbKategorije.setModel(cbm);
        
        for (KategorijaJela k: kategorijeJela){
            cbm.addElement(k);
        }
        
        cmbKategorije.setSelectedItem(kategorijaJela);
    }
    
    private void ucitaj(){
        if (entitet!=null){
            txtNaziv.setText(entitet.getNaziv());
            txtSastojci.setText(entitet.getSastojci());           
            txtCijena.setText(Double.toString(entitet.getCijena()));
            cmbKategorije.setSelectedItem(entitet.getKategorijaJela());
        } else {
            txtNaziv.setText("");
            txtSastojci.setText("");           
            txtCijena.setText("");
        }
    }   
    
    protected void spremi(){
        entitet.setNaziv(txtNaziv.getText());
        entitet.setSastojci(txtSastojci.getText());
        entitet.setCijena(Double.parseDouble(txtCijena.getText()));
        KategorijaJela k = (KategorijaJela) cmbKategorije.getSelectedItem();
        entitet.setKategorijaJela(k);
        if (k.getRestorani()==null){
            k.setRestorani(new ArrayList<>());
        }
        k.getRestorani().add(restoran);
        entitet.setRestoran(restoran);        
        try {
            entitet = obradaJelo.spremi(entitet);
            k = obradaKategorijaJela.spremi(k);
        } catch (Iznimka i) {
            provjeraGreske(i);
            i.printStackTrace();
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

        pnlDodaj = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        pnlPromijeni = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtCijena = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        pnlObrisi = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtSastojci = new javax.swing.JTextField();
        cmbKategorije = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(58, 56, 77));

        pnlDodaj.setBackground(new java.awt.Color(125, 86, 192));
        pnlDodaj.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlDodajMouseClicked(evt);
            }
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlPromijeniMouseClicked(evt);
            }
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

        txtCijena.setBackground(new java.awt.Color(58, 56, 77));
        txtCijena.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtCijena.setForeground(new java.awt.Color(255, 255, 255));
        txtCijena.setToolTipText("Unesite vaš grad/naselje");
        txtCijena.setBorder(null);
        txtCijena.setCaretColor(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("SASTOJCI");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("NAZIV");

        txtNaziv.setBackground(new java.awt.Color(58, 56, 77));
        txtNaziv.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtNaziv.setForeground(new java.awt.Color(255, 255, 255));
        txtNaziv.setToolTipText("Unesite vašu ulicu");
        txtNaziv.setBorder(null);
        txtNaziv.setCaretColor(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("CIJENA");

        jSeparator8.setForeground(new java.awt.Color(255, 255, 255));

        pnlObrisi.setBackground(new java.awt.Color(218, 83, 44));
        pnlObrisi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlObrisiMouseClicked(evt);
            }
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

        txtSastojci.setBackground(new java.awt.Color(58, 56, 77));
        txtSastojci.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtSastojci.setForeground(new java.awt.Color(255, 255, 255));
        txtSastojci.setToolTipText("Unesite vaš kućni broj");
        txtSastojci.setBorder(null);
        txtSastojci.setCaretColor(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("KATEGORIJA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cmbKategorije, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSastojci, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(pnlObrisi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlDodaj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNaziv, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addComponent(txtCijena, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(jSeparator11, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(jSeparator9, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(pnlPromijeni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(7, 7, 7)
                .addComponent(txtSastojci, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(11, 11, 11)
                .addComponent(txtCijena, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbKategorije, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlPromijeni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
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

    private void pnlObrisiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlObrisiMouseClicked
        try {
            obradaJelo.obrisi(entitet);
            jeloListener.jeloObrisano();
            ucitaj();
        } catch (Iznimka i){
            provjeraGreske(i);
        }
    }//GEN-LAST:event_pnlObrisiMouseClicked

    private void pnlPromijeniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPromijeniMouseClicked
        spremi();
        jeloListener.jeloSpremljeno(entitet);
    }//GEN-LAST:event_pnlPromijeniMouseClicked

    private void pnlDodajMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDodajMouseClicked
        this.entitet = new Jelo();
        spremi();        
        jeloListener.jeloSpremljeno(entitet);
    }//GEN-LAST:event_pnlDodajMouseClicked

    private void provjeraGreske(Iznimka i){
        Pomagala.izbaciDialogSGreskom(this, i);
            switch(i.getGreska()){
                case ObradaAdresaDostave.GRAD:
                   txtCijena.requestFocus();
                   break;
                case ObradaAdresaDostave.ULICA:
                   txtNaziv.requestFocus();
                   break;
                case ObradaAdresaDostave.KUCNIBROJ:
                   txtSastojci.requestFocus();
                   break;
            }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<KategorijaJela> cmbKategorije;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JPanel pnlDodaj;
    private javax.swing.JPanel pnlObrisi;
    private javax.swing.JPanel pnlPromijeni;
    private javax.swing.JTextField txtCijena;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtSastojci;
    // End of variables declaration//GEN-END:variables

    private ListCellRenderer<? super KategorijaJela> RendererKategorijaComboBox() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}