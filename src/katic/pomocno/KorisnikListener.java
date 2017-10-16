/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.pomocno;

import katic.ljetnizadatak.model.Korisnik;
import katic.ljetnizadatak.model.Narudzba;

/**
 *
 * @author Valentin
 */
public interface KorisnikListener {
    
    void updateKorisnika(Korisnik korisnik);
    
    void updateNarudzbe();
    
}
