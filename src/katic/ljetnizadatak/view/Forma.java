/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.ljetnizadatak.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import katic.ljetnizadatak.controller.HibernateObrada;
import katic.ljetnizadatak.model.Entitet;

/**
 *
 * @author Polaznik
 */
public abstract class Forma<T extends Entitet> extends JFrame{
    
    protected HibernateObrada<T> obrada;
    protected T entitet;

    public Forma() {
//       Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
//       this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
//        this.setLocationRelativeTo(null);
    }
    
    protected abstract void ucitaj();
    
    protected void spremi(){
        entitet = obrada.save(entitet);
        ucitaj();
    }
    
    protected void obrisi(){
        obrada.delete(entitet);
        ucitaj();
    }
    
    protected void provjeriJelOznaceno(JList<T> lista){
        if(lista.getSelectedValue()==null){
            JOptionPane.showMessageDialog(rootPane, "Prvo odaberite stavku");
        } 
    }
    
}
