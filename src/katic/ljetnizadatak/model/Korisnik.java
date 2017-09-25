/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.ljetnizadatak.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author valentin.katic
 */
@Entity
public class Korisnik extends KorisnickiPodaci implements Serializable{
    
    private String ime;
    private String prezime;

    @OneToMany (mappedBy = "korisnik")
    private List<Narudzba> narudzbe;
    
    @OneToMany (mappedBy = "korisnik")
    private List<AdresaDostave> adreseDostave;
    
    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public List<Narudzba> getNarudzbe() {
        return narudzbe;
    }

    public void setNarudzbe(List<Narudzba> narudzbe) {
        this.narudzbe = narudzbe;
    }

    public List<AdresaDostave> getAdreseDostave() {
        return adreseDostave;
    }

    public void setAdreseDostave(List<AdresaDostave> adreseDostave) {
        this.adreseDostave = adreseDostave;
    }
    
    @Override
    public String toString() {
        return ime + " " + prezime;
    }        
    
}
