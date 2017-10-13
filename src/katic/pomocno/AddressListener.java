/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.pomocno;

import katic.ljetnizadatak.model.AdresaDostave;

/**
 *
 * @author Valentin
 */
public interface AddressListener {
    
    void adresaObrisana();
    
    void adresaSpremljena(AdresaDostave adresaDostave);
    
}
