/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.ljetnizadatak.model;

import java.io.Serializable;
import java.sql.Blob;
import java.util.List;
import javassist.bytecode.ByteArray;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author valentin.katic
 */
@Entity
public class Restoran extends KorisnickiPodaci implements Serializable{
    
    private String naziv;
    private String adresa;
    private String grad;
    private byte[] slika;

    @OneToMany (mappedBy = "restoran")
    private List<Narudzba> narudzbe;
    
    @ManyToMany (mappedBy = "restorani")
    private List<KategorijaJela> kategorijeJela;
    
    @OneToMany (mappedBy = "restoran")
    private List<Jelo> jela;

    public List<Jelo> getJela() {
        return jela;
    }

    public void setJela(List<Jelo> jela) {
        this.jela = jela;
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

    public byte[] getSlika() {
        return slika;
    }

    public void setSlika(byte[] slika) {
        this.slika = slika;
    }

    public List<Narudzba> getNarudzbe() {
        return narudzbe;
    }

    public void setNarudzbe(List<Narudzba> narudzbe) {
        this.narudzbe = narudzbe;
    }

    public List<KategorijaJela> getKategorijeJela() {
        return kategorijeJela;
    }

    public void setKategorijeJela(List<KategorijaJela> kategorijeJela) {
        this.kategorijeJela = kategorijeJela;
    }

    

    @Override
    public String toString() {
        return naziv;
    }
    
    
    
}
