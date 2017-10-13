/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.ljetnizadatak.model;

import java.io.Serializable;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author valentin.katic
 */
@MappedSuperclass
public abstract class KorisnickiPodaci extends Entitet implements Serializable{
    
    private String email;
    private String lozinka;
    private String kontaktBroj;
    private int tip;    //0 korisnik, 1 restoran
       
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getKontaktBroj() {
        return kontaktBroj;
    }

    public void setKontaktBroj(String kontaktBroj) {
        this.kontaktBroj = kontaktBroj;
    }

    public int getTip() {
        return tip;
    }

    public void setTip(int tip) {
        this.tip = tip;
    }
    
    
       
}
