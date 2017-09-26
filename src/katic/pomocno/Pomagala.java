/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.pomocno;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author valentin.katic
 */
public class Pomagala {
    
    public static void provjeriJelOznaceno(JList lista, Component rootPane){
        if(lista.getSelectedValue()==null){
            JOptionPane.showMessageDialog(rootPane, "Prvo odaberite stavku");
        } 
    }
    
}
