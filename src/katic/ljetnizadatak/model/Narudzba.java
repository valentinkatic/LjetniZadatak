/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.ljetnizadatak.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Polaznik
 */
@Entity
public class Narudzba extends Entitet implements Serializable{
    
    @ManyToOne
    private Restoran restoran;
    
    @ManyToOne
    private Korisnik korisnik;    
    
    @OneToMany (mappedBy = "narudzba")
    private List<NarudzbaJelo> narudzbaJela;
    
    @ManyToOne  
    private AdresaDostave adresaDostave;

    private Date vrijemeNarudzbe;

    public Date getVrijemeNarudzbe() {
        return vrijemeNarudzbe;
    }

    public void setVrijemeNarudzbe(Date vrijemeNarudzbe) {
        this.vrijemeNarudzbe = vrijemeNarudzbe;
    }
    
    private boolean nova;       

    public boolean isNova() {
        return nova;
    }

    public void setNova(boolean nova) {
        this.nova = nova;
    }
    
    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public AdresaDostave getAdresaDostave() {
        return adresaDostave;
    }

    public void setAdresaDostave(AdresaDostave adresaDostave) {
        this.adresaDostave = adresaDostave;
    }

    public List<NarudzbaJelo> getNarudzbaJela() {
        return narudzbaJela;
    }

    public void setNarudzbaJela(List<NarudzbaJelo> narudzbaJela) {
        this.narudzbaJela = narudzbaJela;
    }
    
    
    
}
