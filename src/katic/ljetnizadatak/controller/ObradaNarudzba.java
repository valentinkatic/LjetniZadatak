/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.ljetnizadatak.controller;

import java.util.List;
import katic.ljetnizadatak.model.Korisnik;
import katic.ljetnizadatak.model.Narudzba;
import katic.pomocno.HibernateUtil;
import katic.pomocno.Iznimka;

/**
 *
 * @author valentin.katic
 */
public class ObradaNarudzba {
    
    public static final int ENTITET = 0;
    public static final int NAZIV = 1;
    public static final int SASTOJCI = 2;
    public static final int CIJENA = 3;
    public static final int KATEGORIJA = 4;
    
    private HibernateObrada<Narudzba> obrada;
    
    public ObradaNarudzba(){
        this.obrada = new HibernateObrada<>();
    }
    
    public Narudzba getNarudzba(Korisnik k){
        return (Narudzba) HibernateUtil
                .getSession()
                .createQuery("from Narudzba n where "
                        + "n.obrisan=false AND n.korisnik= :korisnik "
                        + "AND n.nova=true")  
                .setLong("korisnik", k.getSifra())
                .uniqueResult();
    }
    
    public List<Narudzba> getSveStareNarudzbe(Korisnik k){
        return HibernateUtil
                .getSession()
                .createQuery("from Narudzba n where "
                        + "n.obrisan=false AND n.korisnik= :korisnik "
                        + "AND n.nova=false")  
                .setLong("korisnik", k.getSifra())
                .list();
    }
    
    public List<Narudzba> getSveNoveNarudzbe(Korisnik k){
        return HibernateUtil
                .getSession()
                .createQuery("from Narudzba n where "
                        + "n.obrisan=false AND n.korisnik= :korisnik "
                        + "AND n.nova=true")  
                .setLong("korisnik", k.getSifra())
                .list();
    }
    
    public Narudzba spremi(Narudzba n) throws Iznimka{
        
        if (n==null){
            throw new Iznimka("Entitet Jelo", "Nije primljen (null)", ENTITET);
        }
        
//        if (n.getNaziv()==null){
//            throw new Iznimka("Naziv", "Nije primljen (null)", NAZIV);
//        }
//        
//        if(n.getNaziv().trim().length()==0){
//            throw new Iznimka("Naziv", "Obavezan unos naziva", NAZIV);
//        }         
//        
//        if (n.getCijena()<=0){
//            throw new Iznimka("Cijena", "Nije unesena cijena ili je manja od 0", CIJENA);
//        }      
//        
//        if (n.getKategorijaJela()==null){
//            throw new Iznimka("Kategorija jela", "Nije označena kategorija", KATEGORIJA);
//        }    
        
        return obrada.save(n);
    }      
    
    public void obrisi(Narudzba n) throws Iznimka{       
        n.setObrisan(true);
        spremi(n);
    }
    
    
}
