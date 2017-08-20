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
public class Jelo extends Entitet{
    
    private String naziv;
    private String sastojci;
    private double cijena;
    private Blob slika;  
    private int kategorija;

    public Jelo(int sifra, String naziv, String sastojci, double cijena) {
        super(sifra);
        this.naziv = naziv;
        this.sastojci = sastojci;
        this.cijena = cijena;
    }

    public Jelo() {
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getSastojci() {
        return sastojci;
    }

    public void setSastojci(String sastojci) {
        this.sastojci = sastojci;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }

    public Blob getSlika() {
        return slika;
    }

    public void setSlika(Blob slika) {
        this.slika = slika;
    }

    public int getKategorija() {
        return kategorija;
    }

    public void setKategorija(int kategorija) {
        this.kategorija = kategorija;
    }         

    @Override
    public String toString() {
        return naziv;
    }       
    
}
