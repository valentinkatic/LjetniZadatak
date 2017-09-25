/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.ljetnizadatak.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author valentin.katic
 */
@Entity 
public class AdresaDostave extends Entitet{
    
    private String ulica;
    private String kucniBroj;
    private String grad;      

    @ManyToOne
    private Korisnik korisnik;
    
    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getKucniBroj() {
        return kucniBroj;
    }

    public void setKucniBroj(String kucniBroj) {
        this.kucniBroj = kucniBroj;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
    
    

    @Override
    public String toString() {
        return ulica + " " + kucniBroj + ", " + grad;
    }
    
    
    
}
