/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.ljetnizadatak.controller;

import java.util.List;
import katic.ljetnizadatak.model.Restoran;
import katic.pomocno.HibernateUtil;
import katic.pomocno.Iznimka;

/**
 *
 * @author valentin.katic
 */
public class ObradaRestoran {
    
    public static final int ENTITET = 0;
    public static final int NAZIV = 1;
    public static final int GRAD = 2;
    public static final int KONTAKT_BROJ = 3;
    public static final int EMAIL = 4;
    public static final int LOZINKA = 5;
    
    private HibernateObrada<Restoran> obrada;
    
    public ObradaRestoran(){
        this.obrada = new HibernateObrada<>();
    }
    
    public List<Restoran> getRestorane(){
        return HibernateUtil
                .getSession()
                .createQuery("from Restoran r where r.obrisan=false")
                .list();
    }
    
    public Restoran spremi(Restoran r) throws Iznimka{
        
        if (r==null){
            throw new Iznimka("Entitet Restoran", "Nije primljen (null)", ENTITET);
        }
        
        if (r.getNaziv()==null){
            throw new Iznimka("Naziv", "Nije primljen (null)", NAZIV);
        }
        
        if(r.getNaziv().trim().length()==0){
            throw new Iznimka("Naziv", "Obavezan unos naziva", NAZIV);
        }         
        
        if (r.getGrad()==null){
            throw new Iznimka("Grad", "Nije primljen (null)", GRAD);
        }
        
        if(r.getGrad().trim().length()==0){
            throw new Iznimka("Grad", "Obavezan unos grada", GRAD);
        }
        
        if (r.getKontaktBroj()==null){
            throw new Iznimka("Kontakt broj", "Nije primljen (null)", KONTAKT_BROJ);
        }
        
        if(r.getKontaktBroj().trim().length()==0){
            throw new Iznimka("Kontakt broj", "Obavezan unos kontakt broja", KONTAKT_BROJ);
        }
        
        if (r.getEmail()==null){
            throw new Iznimka("Email", "Nije primljen (null)", EMAIL);
        }
        
        if(r.getEmail().trim().length()==0){
            throw new Iznimka("Email", "Obavezan unos emaila", EMAIL);
        }
        
        if (r.getLozinka()==null){
            throw new Iznimka("Lozinka", "Nije primljen (null)", LOZINKA);
        }
        
        if(r.getLozinka().trim().length()==0){
            throw new Iznimka("Lozinka", "Obavezan unos lozinke", LOZINKA);
        }
        
        return obrada.save(r);
    }
    
    public void obrisi(Restoran r) throws Iznimka{       
        r.setObrisan(true);
        spremi(r);
    }
    
}
