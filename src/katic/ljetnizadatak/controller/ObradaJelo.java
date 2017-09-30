/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.ljetnizadatak.controller;

import java.util.List;
import katic.ljetnizadatak.model.Jelo;
import katic.ljetnizadatak.model.KategorijaJela;
import katic.ljetnizadatak.model.Restoran;
import katic.pomocno.HibernateUtil;
import katic.pomocno.Iznimka;

/**
 *
 * @author valentin.katic
 */
public class ObradaJelo {
    
    public static final int ENTITET = 0;
    public static final int NAZIV = 1;
    public static final int SASTOJCI = 2;
    public static final int CIJENA = 3;
    public static final int KATEGORIJA = 4;
    
    private HibernateObrada<Jelo> obrada;
    
    public ObradaJelo(){
        this.obrada = new HibernateObrada<>();
    }
    
    public List<Jelo> getJela(KategorijaJela k, Restoran r){
        return HibernateUtil
                .getSession()
                .createQuery("from Jelo j where "
                        + "j.obrisan=false AND j.kategorijaJela= :kategorijaJela "
                        + "AND j.restoran= :restoran")  
                .setLong("kategorijaJela", k.getSifra())
                .setLong("restoran", r.getSifra())
                .list();
    }
    
    public Jelo spremi(Jelo j) throws Iznimka{
        
        if (j==null){
            throw new Iznimka("Entitet Jelo", "Nije primljen (null)", ENTITET);
        }
        
        if (j.getNaziv()==null){
            throw new Iznimka("Naziv", "Nije primljen (null)", NAZIV);
        }
        
        if(j.getNaziv().trim().length()==0){
            throw new Iznimka("Naziv", "Obavezan unos naziva", NAZIV);
        }         
        
        if (j.getCijena()<=0){
            throw new Iznimka("Cijena", "Nije unesena cijena ili je manja od 0", CIJENA);
        }      
        
        if (j.getKategorijaJela()==null){
            throw new Iznimka("Kategorija jela", "Nije označena kategorija", KATEGORIJA);
        }              
        
        return obrada.save(j);
    }
    
    public void obrisi(Jelo j) throws Iznimka{       
        j.setObrisan(true);
        spremi(j);
    }
    
    
}
