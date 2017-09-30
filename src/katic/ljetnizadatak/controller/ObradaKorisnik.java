/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.ljetnizadatak.controller;

import java.util.List;
import katic.ljetnizadatak.model.Korisnik;
import katic.pomocno.HibernateUtil;
import katic.pomocno.Iznimka;

/**
 *
 * @author valentin.katic
 */
public class ObradaKorisnik {
    
    public static final int ENTITET = 0;
    public static final int IME = 1; 
    public static final int PREZIME = 2;
    public static final int KONTAKT_BROJ = 3;
    public static final int EMAIL = 4;
    public static final int LOZINKA = 5;
    public static final int PRETRAZIVAC = 6;
    
    private HibernateObrada<Korisnik> obrada;

    public ObradaKorisnik() {
        obrada = new HibernateObrada<>();
    }
    
    public List<Korisnik> getKorisnike(){
        return HibernateUtil
                .getSession()
                .createQuery("from Korisnik k where k.obrisan=false")
                .list();
    }
    
    public List<Korisnik> getKorisnike(String uvjet) throws Iznimka{
        if (uvjet == null || uvjet.trim().length()==0){
            throw new Iznimka("Polje za pretraživanje", "Nema podataka", PRETRAZIVAC);
        }
        return HibernateUtil
                .getSession()
                .createQuery("from Korisnik k where concat (k.ime, ' ',k.prezime) like :uvjet")
                .setString("uvjet", "%"+uvjet+"%")
                .list();
    }
   
    public Korisnik spremi(Korisnik k) throws Iznimka{
        
        if (k==null){
            throw new Iznimka("Entitet Korisnik", "Nije primljen (null)", ENTITET);
        }
        
        if (k.getIme()==null){
            throw new Iznimka("Ime", "Nije primljen (null)", IME);
        }
        
        if(k.getIme().trim().length()==0){
            throw new Iznimka("Ime", "Obavezan unos imena", IME);
        }         
        
        if (k.getPrezime()==null){
            throw new Iznimka("Prezime", "Nije primljen (null)", PREZIME);
        }
        
        if(k.getPrezime().trim().length()==0){
            throw new Iznimka("Prezime", "Obavezan unos prezimena", PREZIME);
        }
        
        if (k.getKontaktBroj()==null){
            throw new Iznimka("Kontakt broj", "Nije primljen (null)", KONTAKT_BROJ);
        }
        
        if(k.getKontaktBroj().trim().length()==0){
            throw new Iznimka("Kontakt broj", "Obavezan unos kontakt broja", KONTAKT_BROJ);
        }
        
        if (k.getEmail()==null){
            throw new Iznimka("Email", "Nije primljen (null)", EMAIL);
        }
        
        if(k.getEmail().trim().length()==0){
            throw new Iznimka("Email", "Obavezan unos emaila", EMAIL);
        }
        
        if (k.getLozinka()==null){
            throw new Iznimka("Lozinka", "Nije primljen (null)", LOZINKA);
        }
        
        if(k.getLozinka().trim().length()==0){
            throw new Iznimka("Lozinka", "Obavezan unos lozinke", LOZINKA);
        }
        
        return obrada.save(k);
    }
    
    public void obrisi(Korisnik k) throws Iznimka{
        k.setObrisan(true);
        spremi(k);
    }
    
}
