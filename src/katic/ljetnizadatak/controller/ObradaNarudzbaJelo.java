/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.ljetnizadatak.controller;

import katic.ljetnizadatak.model.NarudzbaJelo;
import katic.pomocno.Iznimka;

/**
 *
 * @author valentin.katic
 */
public class ObradaNarudzbaJelo {
    
    public static final int ENTITET = 0;
    public static final int NAZIV = 1;
    public static final int SASTOJCI = 2;
    public static final int CIJENA = 3;
    public static final int KATEGORIJA = 4;
    
    private HibernateObrada<NarudzbaJelo> obrada;
    
    public ObradaNarudzbaJelo(){
        this.obrada = new HibernateObrada<>();
    }       
    
//    public List<Narudzba> getSveStareNarudzbe(Korisnik k){
//        return HibernateUtil
//                .getSession()
//                .createQuery("from Narudzba n where "
//                        + "n.obrisan=false AND n.korisnik= :korisnik "
//                        + "AND n.nova=false")  
//                .setLong("korisnik", k.getSifra())
//                .list();
//    }
    
    public NarudzbaJelo spremi(NarudzbaJelo nj) throws Iznimka{
        
        if (nj==null){
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
        
        return obrada.save(nj);
    }      
    
    public void obrisi(NarudzbaJelo nj) throws Iznimka{       
        nj.setObrisan(true);
        spremi(nj);
    }
    
    
}
