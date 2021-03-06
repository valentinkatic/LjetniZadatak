/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.ljetnizadatak.view.renderer;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import katic.ljetnizadatak.model.KategorijaJela;
import katic.ljetnizadatak.model.Restoran;

/**
 *
 * @author Valentin
 */
public class RendererKategorijaJelaULijevomPanelu extends JLabel implements ListCellRenderer{
    
    public RendererKategorijaJelaULijevomPanelu() {
        setOpaque(true);
        setIconTextGap(12);
        setForeground(new java.awt.Color(204, 204, 204));
        setFont(new java.awt.Font("Century Gothic", 0, 16));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
    }
    
    @Override
    public Component getListCellRendererComponent(JList list, Object value,
        int index, boolean isSelected, boolean cellHasFocus) {
       
        KategorijaJela entry = (KategorijaJela) value;
        setText(entry.getNaziv());
        if (isSelected) {
          setBackground(new Color(58,56,77));
        } else {
          setBackground(new Color(38,40,55));
        }
        return this;
  }
    
}
