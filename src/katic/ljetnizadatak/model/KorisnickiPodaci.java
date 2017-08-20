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
public class KorisnickiPodaci extends Entitet{
    
    private String email;
    private String lozinka;
    private String kontaktBroj;

    public KorisnickiPodaci(int sifra, String email, String lozinka, String kontaktBroj) {
        super(sifra);
        this.email = email;
        this.lozinka = lozinka;
        this.kontaktBroj = kontaktBroj;
    }

    public KorisnickiPodaci() {
    }
       
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
       
}
