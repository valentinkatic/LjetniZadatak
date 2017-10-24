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
import javax.persistence.Transient;

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
    
    @Transient
    private Long kategorijaJela_sifra;

    @Transient
    private Long restoran_sifra;
    
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

    public Long getKategorijaJela_sifra() {
        return kategorijaJela_sifra;
    }

    public void setKategorijaJela_sifra(Long kategorijaJela_sifra) {
        this.kategorijaJela_sifra = kategorijaJela_sifra;
    }

    public Long getRestoran_sifra() {
        return restoran_sifra;
    }

    public void setRestoran_sifra(Long restoran_sifra) {
        this.restoran_sifra = restoran_sifra;
    }        

    @Override
    public String toString() {
        return naziv;
    }       
    
}
