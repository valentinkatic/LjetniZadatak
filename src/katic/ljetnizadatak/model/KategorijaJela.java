/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.ljetnizadatak.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author valentin.katic
 */
@Entity
public class KategorijaJela extends Entitet implements Serializable{
    
    private String naziv;
    
    @OneToMany (mappedBy = "kategorijaJela")
    private List<Jelo> jelo;

    @ManyToMany
    private List<Restoran> restorani;
    
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List<Jelo> getJelo() {
        return jelo;
    }

    public void setJelo(List<Jelo> jelo) {
        this.jelo = jelo;
    }

    public List<Restoran> getRestorani() {
        return restorani;
    }

    public void setRestorani(List<Restoran> restorani) {
        this.restorani = restorani;
    }

    
    
    @Override
    public String toString() {
        return naziv;
    }
    
    
    
}
