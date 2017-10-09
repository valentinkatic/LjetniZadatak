/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.ljetnizadatak.model;

import javax.swing.JLabel;

/**
 *
 * @author Valentin
 */
public class Tab {
    
    private JLabel lbl;
    private String key;

    public Tab(JLabel lbl, String key) {
        this.lbl = lbl;
        this.key = key;
    }
    
    public JLabel getLbl() {
        return lbl;
    }

    public void setLbl(JLabel lbl) {
        this.lbl = lbl;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    
    
    
}
