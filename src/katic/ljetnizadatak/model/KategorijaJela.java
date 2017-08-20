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
public class KategorijaJela extends Entitet{
    
    private String naziv;

    public KategorijaJela() {
    }

    public KategorijaJela(int sifra, String naziv) {
        super(sifra);
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
    
    
}
