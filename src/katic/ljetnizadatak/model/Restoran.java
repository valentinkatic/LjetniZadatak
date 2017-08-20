/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.ljetnizadatak.model;

import java.sql.Blob;

/**
 *
 * @author valentin.katic
 */
public class Restoran extends KorisnickiPodaci{
    
    private String naziv;
    private String adresa;
    private String grad;
    private Blob slika;

    public Restoran() {
    }

    public Restoran(int sifra, String naziv, String adresa, String grad, String kontaktBroj, String email, String lozinka, Blob slika) {
        super(sifra, email, lozinka, kontaktBroj);
        this.naziv = naziv;
        this.adresa = adresa;
        this.grad = grad;
        this.slika = slika;
    }    

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }    

    public Blob getSlika() {
        return slika;
    }

    public void setSlika(Blob slika) {
        this.slika = slika;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
    
    
}
