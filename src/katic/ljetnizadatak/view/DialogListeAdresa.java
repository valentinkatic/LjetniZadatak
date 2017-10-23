/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.ljetnizadatak.view;

import java.util.List;
import javax.swing.JOptionPane;
import katic.ljetnizadatak.controller.ObradaAdresaDostave;
import katic.ljetnizadatak.model.AdresaDostave;
import katic.ljetnizadatak.model.Korisnik;

/**
 *
 * @author Valentin
 */
public class DialogListeAdresa {
       
    public static AdresaDostave main(AdresaDostave[] choices) {
            
        AdresaDostave input = (AdresaDostave) JOptionPane.showInputDialog(null, "",
            "Odaberite adresu", JOptionPane.INFORMATION_MESSAGE, null, // Use
                                                                            // default
                                                                            // icon
            choices , // Array of choices
            choices[0]); // Initial choice
        return input;
    }
    
}
