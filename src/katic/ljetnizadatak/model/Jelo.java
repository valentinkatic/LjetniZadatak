/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.ljetnizadatak.model;

import java.io.Serializable;
import java.sql.Blob;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author valentin.katic
 */
@Entity
public class Jelo extends Entitet implements Serializable{
    
    private String naziv;
    private String sastojci;
    private double cijena;
    private Blob slika; 
    
    @ManyToOne
    private KategorijaJela kategorijaJela;

    @OneToMany (mappedBy = "jelo")
    private List<NarudzbaJelo> narudzbaJela;
    
    @ManyToOne
    private Restoran restoran;

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
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

    public KategorijaJela getKategorijaJela() {
        return kategorijaJela;
    }

    public void setKategorijaJela(KategorijaJela kategorijaJela) {
        this.kategorijaJela = kategorijaJela;
    }

    public List<NarudzbaJelo> getNarudzbaJela() {
        return narudzbaJela;
    }

    public void setNarudzbaJela(List<NarudzbaJelo> narudzbaJela) {
        this.narudzbaJela = narudzbaJela;
    }

         

    @Override
    public String toString() {
        return naziv;
    }       
    
}
