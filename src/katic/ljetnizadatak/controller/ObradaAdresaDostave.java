/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.ljetnizadatak.controller;

import java.util.List;
import katic.ljetnizadatak.model.AdresaDostave;
import katic.ljetnizadatak.model.Korisnik;
import katic.pomocno.HibernateUtil;
import katic.pomocno.Iznimka;

/**
 *
 * @author valentin.katic
 */
public class ObradaAdresaDostave {
    
    public static final int ENTITET = 0;
    public static final int ULICA = 1; 
    public static final int KUCNIBROJ = 2; 
    public static final int GRAD = 3; 
    
    HibernateObrada<AdresaDostave> obrada;

    public ObradaAdresaDostave() {
        obrada = new HibernateObrada<>();
    }
    
    public List<AdresaDostave> getAdreseDostave(Korisnik korisnik){
        return HibernateUtil
                .getSession()
                .createQuery("from AdresaDostave a where a.obrisan=false AND a.korisnik = :korisnik")
                .setLong("korisnik", korisnik.getSifra())
                .list();
    }
   
    public AdresaDostave spremi(AdresaDostave a) throws Iznimka{
        
        if (a==null){
            throw new Iznimka("Entitet AdresaDostave", "Nije primljen (null)", ENTITET);
        }
        
        if (a.getUlica()==null){
            throw new Iznimka("Ulica", "Nije primljen (null)", ULICA);
        }
        
        if(a.getUlica().trim().length()==0){
            throw new Iznimka("Ulica", "Obavezno unos ulice", ULICA);
        }
           
        if (a.getKucniBroj()==null){
            throw new Iznimka("Kućni broj", "Nije primljen (null)", KUCNIBROJ);
        }
        
        if(a.getKucniBroj().trim().length()==0){
            throw new Iznimka("Kućni broj", "Obavezan unos kućnog broja", KUCNIBROJ);
        }
        
        if (a.getGrad()==null){
            throw new Iznimka("Grad", "Nije primljen (null)", GRAD);
        }
        
        if(a.getGrad().trim().length()==0){
            throw new Iznimka("Grad", "Obavezan unos grada", GRAD);
        }
        
        return obrada.save(a);
    }
    
    public void obrisi(AdresaDostave a) throws Iznimka{
        a.setObrisan(true);
        spremi(a);
    }
    
}
