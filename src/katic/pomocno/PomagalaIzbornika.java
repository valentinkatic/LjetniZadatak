/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.pomocno;

import java.awt.Color;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTextField;
import katic.ljetnizadatak.model.Tab;
import katic.ljetnizadatak.FormaAplikacije;

/**
 *
 * @author Valentin
 */
public class PomagalaIzbornika {
    
    public static int setClickedEffect(List<Tab> tabovi, JLabel lbl, MenuListener startPanelListener){
        int i=0, pressedTab = 0;
        for (Tab tab: tabovi){
            if (tab.getLbl().equals(lbl)){
                setPressedTabColor(tab.getLbl());
                pressedTab = i;
                if (tab.getKey().equals(FormaAplikacije.ODJAVA)){
                    setDefaultTabColor(tab.getLbl());
                    startPanelListener.onSignOut();
                    break;
                }
                startPanelListener.promjenaDesnogPanela(tab.getKey());
            } else {
                setDefaultTabColor(tab.getLbl());
            }
            i++;
        }
        return pressedTab;
    }
    
    public static void setHoverEffect(JLabel lbl){
        setHoverTabColor(lbl);
    }
    
    public static void setUnHoverEffect(Tab tab, JLabel lbl){
        if (tab.getLbl().equals(lbl)){
            setPressedTabColor(lbl);
        } else {
            setDefaultTabColor(lbl);
        }
    }
    
    public static void setHoverTabColor(JLabel tab){
        tab.setBackground(new Color(68,23,80));
    }
    
    public static  void setPressedTabColor(JLabel tab){
        tab.setBackground(new Color(58,56,77));
    }
    
    public static  void setDefaultTabColor(JLabel tab){
        tab.setBackground(new Color(38,40,55));
    }
    
    public static void setHoverTabColor(JTextField tab){
        tab.setBackground(new Color(68,23,80));
    }
    
    public static  void setPressedTabColor(JTextField tab){
        tab.setBackground(new Color(58,56,77));
    }
    
    public static  void setDefaultTabColor(JTextField tab){
        tab.setBackground(new Color(38,40,55));
    }
    
}
