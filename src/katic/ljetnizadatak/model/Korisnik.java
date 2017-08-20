/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.ljetnizadatak.model;

/**
 *
 * @author valentin.katic
 */
public class Korisnik extends KorisnickiPodaci{
    
    private String ime;
    private String prezime;

    public Korisnik() {
    }

    public Korisnik(int sifra, String ime, String prezime, String email, String lozinka, String kontaktBroj) {
        super(sifra, email, lozinka, kontaktBroj);
        this.ime = ime;
        this.prezime = prezime;
    }

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

    @Override
    public String toString() {
        return ime + " " + prezime;
    }        
    
}
