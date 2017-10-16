/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.ljetnizadatak.view;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import katic.ljetnizadatak.controller.ObradaJelo;
import katic.ljetnizadatak.controller.ObradaNarudzba;
import katic.ljetnizadatak.controller.ObradaNarudzbaJelo;
import katic.ljetnizadatak.model.Jelo;
import katic.ljetnizadatak.model.KategorijaJela;
import katic.ljetnizadatak.model.Korisnik;
import katic.ljetnizadatak.model.Narudzba;
import katic.ljetnizadatak.model.NarudzbaJelo;
import katic.ljetnizadatak.model.Restoran;
import katic.ljetnizadatak.view.renderer.RendererJelaUKategoriji;
import katic.pomocno.Iznimka;

/**
 *
 * @author Valentin
 */
public class PanelKosarice extends javax.swing.JPanel {

    private Korisnik korisnik;
    private Restoran restoran;
    private KategorijaJela kategorijaJela;
    private ObradaJelo obradaJelo;
    private ObradaNarudzba obradaNarudzba;
    private ObradaNarudzbaJelo obradaNarudzbaJelo;
    private List<Jelo> jela;
    private Jelo odabranoJelo;
    private Narudzba narudzba;
    private boolean dodanoUNarudzbu = false;
    private boolean triggerPromjena = false;
    
    private int kolicina = 1;
    private int pocetnaKolicina = 1;
    private double suma = 0;
    
    public PanelKosarice(Korisnik korisnik) {
        this.korisnik = korisnik;
        initComponents();
        
        this.obradaJelo = new ObradaJelo();
        this.obradaNarudzba = new ObradaNarudzba();
        this.obradaNarudzbaJelo = new ObradaNarudzbaJelo();
        
        narudzba = obradaNarudzba.getNarudzba(korisnik);
        
        prikaziPodnozje(false);
        
        ucitaj();
        ucitajSumu();
    }
    
    private void ucitaj(){        
        if (narudzba==null){
            return;
        }
        jela = obradaNarudzbaJelo.getJelaIzNarudzbe(narudzba);

        DefaultListModel<Jelo> m = new DefaultListModel<Jelo>();
        lista.setModel(m);

        for (Jelo j: jela){
            m.addElement(j);            
        }  
        
        if (jela.isEmpty()){
            prikaziPodnozje(false);
        } else {            
            prikaziPodnozje(true);
        }
    }

    private void ucitajSumu(){
        suma = 0;
        if (narudzba == null){
            osvjeziSumu();
            return;
        }
        for (NarudzbaJelo nj: narudzba.getNarudzbaJela()){
            if (!nj.isObrisan()){
                suma += nj.getKolicina() * nj.getJelo().getCijena();               
            }
        }
        osvjeziSumu();
    }
    
    private void osvjeziSumu(){        
        lblSumaIznos.setText(String.format("%.2f kn", suma));
    }
    
    public void osvjeziNarudzbu(){
        narudzba = obradaNarudzba.getNarudzba(korisnik);
        ucitaj();
        ucitajSumu();
    }
    
    private void setUkupno(){      
        lblUkupno.setText(String.format("%.2f kn", kolicina*odabranoJelo.getCijena()));
    }
    
    
    private void setZadaneVrijednosti(){
        kolicina = 1;
        lblUkupno.setText(String.format("0.00 kn"));
        lblKolicina.setText("1");
        pocetnaKolicina = 1;
    }
    
    private void prikaziPodnozje(boolean vrijednost ){
        btnMinus.setVisible(vrijednost);
        btnPlus.setVisible(vrijednost);
        lblKolicina.setVisible(vrijednost);
        lblUkupno.setVisible(vrijednost);
        pnlDodajUKosaricu.setVisible(vrijednost);
        lblSuma.setVisible(vrijednost);
        lblSumaIznos.setVisible(vrijednost);
        pnlPosaljiNarudzbu.setVisible(vrijednost);
    }
    
    private void provjeriJelUNarudzbi(){
        dodanoUNarudzbu = false;
        List<Narudzba> narudzbe = obradaNarudzba.getSveNoveNarudzbe(korisnik);
        for (Narudzba n:narudzbe){
           for (NarudzbaJelo nj: n.getNarudzbaJela()){
               if (nj.getJelo().equals(odabranoJelo) && !nj.isObrisan()){
                   dodanoUNarudzbu = true;                        
                   lblKolicina.setText(String.format("%d", nj.getKolicina()));
                   kolicina = nj.getKolicina();
                   pocetnaKolicina = kolicina;                   
                   break;
               }
           }
        }
        setDefaultBackground();
        if (!dodanoUNarudzbu){                                  
            lblKolicina.setText("1");
            lblUkupno.setText("0.00 kn");
            kolicina = 1;
        }
    }
    
    private void dodajUKosaricu(){
        if (odabranoJelo.getRestoran()!=narudzba.getRestoran()){
            JOptionPane.showMessageDialog(this, "Ne možete imati više od jednog restorana u košarici!", "Košarica", JOptionPane.WARNING_MESSAGE); 
            return;
        }
        if (narudzba.getSifra()==null){
            try {
                narudzba = obradaNarudzba.spremi(narudzba);
            } catch (Iznimka i){
                i.printStackTrace();
            }
        }
        
        NarudzbaJelo narudzbaJelo = null;
        boolean jeloVecUNarudzbi = false;
        if (narudzba.getNarudzbaJela()!=null){
            for (NarudzbaJelo nj: narudzba.getNarudzbaJela()){
                if (nj.getJelo()==odabranoJelo){
                    nj.setKolicina(kolicina);
                    nj.setObrisan(false);
                    narudzbaJelo = nj;
                    jeloVecUNarudzbi = true;
                    break;
                }
            }
        }
        
        if (!jeloVecUNarudzbi){
            narudzbaJelo = new NarudzbaJelo();
            narudzbaJelo.setKolicina(kolicina);            
            narudzbaJelo.setNarudzba(narudzba);      
            odabranoJelo.getNarudzbaJela().add(narudzbaJelo); 
            narudzbaJelo.setJelo(odabranoJelo); 
            if (narudzba.getNarudzbaJela()==null){
                narudzba.setNarudzbaJela(new ArrayList<>());
            }
            narudzba.getNarudzbaJela().add(narudzbaJelo);
        }
        try {            
            narudzba = obradaNarudzba.spremi(narudzba);
            narudzbaJelo = obradaNarudzbaJelo.spremi(narudzbaJelo);
            provjeriJelUNarudzbi();
            triggerPromjena = false;
            pocetnaKolicina = kolicina;
            setDefaultBackground();
        } catch (Iznimka i){
            i.printStackTrace();
        }
    }
    
    private void izbrisiIzKosarice(){
        for (Narudzba n: obradaNarudzba.getSveNoveNarudzbe(korisnik)){
            for (NarudzbaJelo nj: n.getNarudzbaJela()){
                if (nj.getJelo().equals(odabranoJelo)){
                    nj.setObrisan(true);
                    ucitajSumu();
                    suma -= nj.getKolicina() * nj.getJelo().getCijena();
                    osvjeziSumu();
                    try {
                        obradaNarudzbaJelo.spremi(nj);
                        provjeriJelUNarudzbi();
                        setZadaneVrijednosti();
                        setDefaultBackground();
                        ucitaj();
                    } catch (Iznimka i){
                        i.printStackTrace();
                    }
                    break;
                }
            }
        }        
        ucitajSumu();
    }
    
    private void setDefaultBackground(){
        if (dodanoUNarudzbu){
            if (triggerPromjena){
                pnlDodajUKosaricu.setBackground(new Color(0,163,0));
                lblDodajUKošaricu.setText("Promijeni");
            } else {
                pnlDodajUKosaricu.setBackground(new Color(238,17,17));
                lblDodajUKošaricu.setText("Izbriši iz košarice");
            }
        } else {
            pnlDodajUKosaricu.setBackground(new Color(125,86,192));
            lblDodajUKošaricu.setText("Dodaj u košaricu");
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

        lblNaziv = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        btnMinus = new javax.swing.JLabel();
        btnPlus = new javax.swing.JLabel();
        lblKolicina = new javax.swing.JLabel();
        lblUkupno = new javax.swing.JLabel();
        pnlDodajUKosaricu = new javax.swing.JPanel();
        lblDodajUKošaricu = new javax.swing.JLabel();
        lblSumaIznos = new javax.swing.JLabel();
        lblSuma = new javax.swing.JLabel();
        pnlPosaljiNarudzbu = new javax.swing.JPanel();
        lblDodajUKošaricu1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(58, 56, 77));

        lblNaziv.setBackground(new java.awt.Color(38, 40, 55));
        lblNaziv.setFont(new java.awt.Font("Century Gothic", 0, 22)); // NOI18N
        lblNaziv.setForeground(new java.awt.Color(204, 204, 204));
        lblNaziv.setText("Košarica");
        lblNaziv.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 1));

        jScrollPane1.setBorder(null);

        lista.setBackground(new java.awt.Color(58, 56, 77));
        lista.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lista.setCellRenderer(new RendererJelaUKategoriji());
        lista.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lista);

        btnMinus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/minus.png"))); // NOI18N
        btnMinus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinusMouseClicked(evt);
            }
        });

        btnPlus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/plus.png"))); // NOI18N
        btnPlus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPlusMouseClicked(evt);
            }
        });

        lblKolicina.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        lblKolicina.setForeground(new java.awt.Color(255, 255, 255));
        lblKolicina.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKolicina.setText("1");

        lblUkupno.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        lblUkupno.setForeground(new java.awt.Color(255, 255, 255));
        lblUkupno.setText("0.00 kn");

        pnlDodajUKosaricu.setBackground(new java.awt.Color(125, 86, 192));
        pnlDodajUKosaricu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlDodajUKosaricuMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlDodajUKosaricuMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlDodajUKosaricuMouseEntered(evt);
            }
        });

        lblDodajUKošaricu.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblDodajUKošaricu.setForeground(new java.awt.Color(255, 255, 255));
        lblDodajUKošaricu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDodajUKošaricu.setText("Dodaj u košaricu");

        javax.swing.GroupLayout pnlDodajUKosaricuLayout = new javax.swing.GroupLayout(pnlDodajUKosaricu);
        pnlDodajUKosaricu.setLayout(pnlDodajUKosaricuLayout);
        pnlDodajUKosaricuLayout.setHorizontalGroup(
            pnlDodajUKosaricuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 128, Short.MAX_VALUE)
            .addGroup(pnlDodajUKosaricuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlDodajUKosaricuLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblDodajUKošaricu, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        pnlDodajUKosaricuLayout.setVerticalGroup(
            pnlDodajUKosaricuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(pnlDodajUKosaricuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlDodajUKosaricuLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblDodajUKošaricu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        lblSumaIznos.setBackground(new java.awt.Color(38, 40, 55));
        lblSumaIznos.setFont(new java.awt.Font("Century Gothic", 1, 22)); // NOI18N
        lblSumaIznos.setForeground(new java.awt.Color(204, 204, 204));
        lblSumaIznos.setText("0.00 kn");

        lblSuma.setBackground(new java.awt.Color(38, 40, 55));
        lblSuma.setFont(new java.awt.Font("Century Gothic", 0, 22)); // NOI18N
        lblSuma.setForeground(new java.awt.Color(204, 204, 204));
        lblSuma.setText("Suma: ");

        pnlPosaljiNarudzbu.setBackground(new java.awt.Color(0, 163, 0));
        pnlPosaljiNarudzbu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlPosaljiNarudzbuMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlPosaljiNarudzbuMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlPosaljiNarudzbuMouseEntered(evt);
            }
        });

        lblDodajUKošaricu1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblDodajUKošaricu1.setForeground(new java.awt.Color(255, 255, 255));
        lblDodajUKošaricu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDodajUKošaricu1.setText("Pošalji narudžbu");

        javax.swing.GroupLayout pnlPosaljiNarudzbuLayout = new javax.swing.GroupLayout(pnlPosaljiNarudzbu);
        pnlPosaljiNarudzbu.setLayout(pnlPosaljiNarudzbuLayout);
        pnlPosaljiNarudzbuLayout.setHorizontalGroup(
            pnlPosaljiNarudzbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 128, Short.MAX_VALUE)
            .addGroup(pnlPosaljiNarudzbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlPosaljiNarudzbuLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblDodajUKošaricu1, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        pnlPosaljiNarudzbuLayout.setVerticalGroup(
            pnlPosaljiNarudzbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(pnlPosaljiNarudzbuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlPosaljiNarudzbuLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblDodajUKošaricu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(btnMinus)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblUkupno, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(pnlDodajUKosaricu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblSuma)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblSumaIznos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(pnlPosaljiNarudzbu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblNaziv)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblNaziv)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblKolicina, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPlus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblUkupno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDodajUKosaricu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblSumaIznos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlPosaljiNarudzbu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSuma, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pnlDodajUKosaricuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDodajUKosaricuMouseClicked
        if (dodanoUNarudzbu){
            if (triggerPromjena){
                dodajUKosaricu();
            } else {
                izbrisiIzKosarice();
            }
        } else {
            dodajUKosaricu();
        }
    }//GEN-LAST:event_pnlDodajUKosaricuMouseClicked

    private void pnlDodajUKosaricuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDodajUKosaricuMouseExited
        setDefaultBackground();
    }//GEN-LAST:event_pnlDodajUKosaricuMouseExited

    private void pnlDodajUKosaricuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDodajUKosaricuMouseEntered
        pnlDodajUKosaricu.setBackground(new Color(103,33,122));
    }//GEN-LAST:event_pnlDodajUKosaricuMouseEntered

    private void btnPlusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlusMouseClicked
        kolicina ++;
        suma += odabranoJelo.getCijena();
        osvjeziSumu();
        if (dodanoUNarudzbu && kolicina!=pocetnaKolicina){
            triggerPromjena = true;
        } else {
            triggerPromjena = false;
        }
        setDefaultBackground();
        lblKolicina.setText(String.format("%d", kolicina));
        setUkupno();
    }//GEN-LAST:event_btnPlusMouseClicked

    private void listaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaValueChanged
        if (lista.getSelectedValue()==null){
            return;
        }
        odabranoJelo = lista.getSelectedValue();       
        provjeriJelUNarudzbi();
        setUkupno();
    }//GEN-LAST:event_listaValueChanged

    private void btnMinusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinusMouseClicked
        if (kolicina>1){
            kolicina --;
            suma -= odabranoJelo.getCijena();
            osvjeziSumu();
            if (dodanoUNarudzbu && kolicina!=pocetnaKolicina){
                triggerPromjena = true;
            } else {
                triggerPromjena = false;
            }
            setDefaultBackground();
            lblKolicina.setText(String.format("%d", kolicina));            
        }
        setUkupno();
    }//GEN-LAST:event_btnMinusMouseClicked

    private void pnlPosaljiNarudzbuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPosaljiNarudzbuMouseClicked
        narudzba.setNova(false);
        try {
            obradaNarudzba.spremi(narudzba);
            narudzba = null;
            ucitaj();
            ucitajSumu();
        } catch (Iznimka i){
            
        }
    }//GEN-LAST:event_pnlPosaljiNarudzbuMouseClicked

    private void pnlPosaljiNarudzbuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPosaljiNarudzbuMouseExited
        pnlPosaljiNarudzbu.setBackground(new Color(0,163,0));
    }//GEN-LAST:event_pnlPosaljiNarudzbuMouseExited

    private void pnlPosaljiNarudzbuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPosaljiNarudzbuMouseEntered
        pnlPosaljiNarudzbu.setBackground(new Color(103,33,122));
    }//GEN-LAST:event_pnlPosaljiNarudzbuMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnMinus;
    private javax.swing.JLabel btnPlus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDodajUKošaricu;
    private javax.swing.JLabel lblDodajUKošaricu1;
    private javax.swing.JLabel lblKolicina;
    private javax.swing.JLabel lblNaziv;
    private javax.swing.JLabel lblSuma;
    private javax.swing.JLabel lblSumaIznos;
    private javax.swing.JLabel lblUkupno;
    private javax.swing.JList<Jelo> lista;
    private javax.swing.JPanel pnlDodajUKosaricu;
    private javax.swing.JPanel pnlPosaljiNarudzbu;
    // End of variables declaration//GEN-END:variables
}
