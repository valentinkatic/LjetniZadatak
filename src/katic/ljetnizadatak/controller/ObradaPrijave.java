/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.ljetnizadatak.controller;

import katic.ljetnizadatak.model.KorisnickiPodaci;
import katic.ljetnizadatak.model.Korisnik;
import katic.ljetnizadatak.model.Restoran;
import katic.pomocno.HibernateUtil;
import katic.pomocno.Iznimka;

/**
 *
 * @author Valentin
 */
public class ObradaPrijave {
    
    public static final int EMAIL = 1; 
    public static final int LOZINKA = 2; 
    
    public int prijava(String email, String lozinka) throws Iznimka{
        int tipKorisnika = -1;
        
        try {
            tipKorisnika = (int) HibernateUtil
                    .getSession()
                    .createQuery("select k.tip from Korisnik k where k.obrisan=false AND k.email = :email AND k.lozinka = :lozinka")
                    .setString("email", email)
                    .setString("lozinka", lozinka)
                    .uniqueResult();
        } catch (Exception e){}
        
        if (tipKorisnika == -1){
            try {
                tipKorisnika = (int) HibernateUtil
                        .getSession()
                        .createQuery("select r.tip from Restoran r where r.obrisan=false AND r.email = :email AND r.lozinka = :lozinka")
                        .setString("email", email)
                        .setString("lozinka", lozinka)
                        .uniqueResult();
            } catch (Exception e){}
        }
             
        if (tipKorisnika == -1){
            throw new Iznimka("Račun", "Ne postoji račun s tim podacima", 0);
        }
        
        return tipKorisnika;
    }
    
    public Korisnik prijavaKorisnika(String email, String lozinka){
        return (Korisnik) HibernateUtil
                        .getSession()
                        .createQuery("select k from Korisnik k where k.obrisan=false AND k.email = :email AND k.lozinka = :lozinka")
                        .setString("email", email)
                        .setString("lozinka", lozinka)
                        .uniqueResult();
    }
    
    public Restoran prijavaRestorana(String email, String lozinka){
        return (Restoran) HibernateUtil
                        .getSession()
                        .createQuery("select r from Restoran r where r.obrisan=false AND r.email = :email AND r.lozinka = :lozinka")
                        .setString("email", email)
                        .setString("lozinka", lozinka)
                        .uniqueResult();
    }
    
}
