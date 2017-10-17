/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.ljetnizadatak.view.renderer;

import java.awt.Color;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import katic.ljetnizadatak.model.Jelo;
import katic.ljetnizadatak.model.Narudzba;
import katic.ljetnizadatak.model.NarudzbaJelo;

/**
 *
 * @author Valentin
 */
public class RendererNarudzbi extends javax.swing.JPanel implements ListCellRenderer{

    /**
     * Creates new form Renderer
     */
    public RendererNarudzbi() {
        initComponents();
//        setForeground(new java.awt.Color(204, 204, 204));
//        setFont(new java.awt.Font("Century Gothic", 0, 14));
//        setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
    }
    
    @Override
    public Component getListCellRendererComponent(JList list, Object value,
        int index, boolean isSelected, boolean cellHasFocus) {
       
        Narudzba entry = (Narudzba) value;
        lblIme.setText(entry.getKorisnik().getIme() + " " + entry.getKorisnik().getPrezime());
        String datum = new SimpleDateFormat("dd. MM. yyyy. HH:mm").format(entry.getVrijemeNarudzbe());
        lblDatum.setText(datum);
        double suma = 0;
        for (NarudzbaJelo nj:entry.getNarudzbaJela()){
            suma += nj.getJelo().getCijena() * nj.getKolicina();
        }
        lblCijena.setText(String.format(Locale.getDefault(), "%.2f kn", suma));
       
        if (isSelected) {
          setBackground(new Color(38,40,55));
        } else {
          setBackground(new Color(58,56,77));
        }        
        
        return this;
  }
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lblIme = new javax.swing.JLabel();
        lblDatum = new javax.swing.JLabel();
        lblCijena = new javax.swing.JLabel();

        setBackground(new java.awt.Color(58, 56, 77));
        setLayout(new java.awt.GridBagLayout());

        lblIme.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblIme.setForeground(new java.awt.Color(255, 255, 255));
        lblIme.setText("Ime Prezime");
        lblIme.setPreferredSize(new java.awt.Dimension(310, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        add(lblIme, gridBagConstraints);

        lblDatum.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblDatum.setForeground(new java.awt.Color(255, 255, 255));
        lblDatum.setText("Datum");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        add(lblDatum, gridBagConstraints);

        lblCijena.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblCijena.setForeground(new java.awt.Color(255, 255, 255));
        lblCijena.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCijena.setText("Cijena");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        add(lblCijena, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblCijena;
    private javax.swing.JLabel lblDatum;
    private javax.swing.JLabel lblIme;
    // End of variables declaration//GEN-END:variables
}
