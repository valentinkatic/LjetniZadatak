/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.ljetnizadatak.view.renderer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import katic.ljetnizadatak.model.KategorijaJela;

/**
 *
 * @author Valentin
 */
public class RendererKategorijaComboBox extends JLabel implements ListCellRenderer{

    public RendererKategorijaComboBox() {
        setOpaque(true);
        setFont(new Font("Century Gothic", 0, 14));
        setBackground(Color.BLUE);
        setForeground(Color.YELLOW);
    }
    
    @Override
    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {
        KategorijaJela kategorijaJela = (KategorijaJela) value;
        setText(kategorijaJela.getNaziv());
        return this;
    }
    
}
