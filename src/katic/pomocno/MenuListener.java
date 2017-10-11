/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.pomocno;

import katic.ljetnizadatak.model.Korisnik;
import katic.ljetnizadatak.model.Restoran;

/**
 *
 * @author Valentin
 */
public interface MenuListener {
    
    void promjenaDesnogPanela(String panel);
    
    void promjenaLijevogPanela(String lijeviPnl, String desniPnl);
    
    void odabraniRestoran(Restoran restoran);
    
    void onUserSignIn(String panel, Korisnik korisnik);
    
    void onRestaurantSignIn(String panel, Restoran restoran);
      
    void onBackPressed(String panel);
    
    void onSignOut();
    
}
