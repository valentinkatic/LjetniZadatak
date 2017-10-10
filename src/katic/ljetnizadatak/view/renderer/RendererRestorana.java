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
import katic.ljetnizadatak.model.Restoran;

/**
 *
 * @author Valentin
 */
public class RendererRestorana extends JLabel implements ListCellRenderer{
    
    public RendererRestorana() {
        setOpaque(true);
        setIconTextGap(12);
        setForeground(new java.awt.Color(204, 204, 204));
        setFont(new java.awt.Font("Century Gothic", 0, 28));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 80, 8, 0));
    }
    
    @Override
    public Component getListCellRendererComponent(JList list, Object value,
        int index, boolean isSelected, boolean cellHasFocus) {
       
        Restoran entry = (Restoran) value;
        setText(entry.getNaziv());
//        setIcon(entry.getImage());
        if (isSelected) {
          setBackground(new Color(38,40,55));
        } else {
          setBackground(new Color(58,56,77));
        }
        return this;
  }
    
}
