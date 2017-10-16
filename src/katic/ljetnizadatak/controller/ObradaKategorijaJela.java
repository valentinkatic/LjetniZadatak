/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.ljetnizadatak.controller;

import java.util.List;
import katic.ljetnizadatak.model.KategorijaJela;
import katic.ljetnizadatak.model.Restoran;
import katic.pomocno.HibernateUtil;
import katic.pomocno.Iznimka;

/**
 *
 * @author valentin.katic
 */
public class ObradaKategorijaJela {
    
    public static final int ENTITET = 0;
    public static final int NAZIV = 1; 
    
    private HibernateObrada<KategorijaJela> obrada;

    public ObradaKategorijaJela() {
        obrada = new HibernateObrada<>();
    }
    
    public List<KategorijaJela> getKategorijeJela(){
        return HibernateUtil
                .getSession()
                .createQuery("from KategorijaJela k where k.obrisan=false")
                .list();
    }
   
    public KategorijaJela spremi(KategorijaJela k) throws Iznimka{
        
        if (k==null){
            throw new Iznimka("Entitet KategorijaJela", "Nije primljen (null)", ENTITET);
        }
        
        if (k.getNaziv()==null){
            throw new Iznimka("Naziv", "Nije primljen (null)", NAZIV);
        }
        
        if(k.getNaziv().trim().length()==0){
            throw new Iznimka("Naziv", "Obavezan unos naziva", NAZIV);
        }         
        
        return obrada.save(k);
    }
    
    public void obrisi(KategorijaJela k) throws Iznimka{
        k.setObrisan(true);
        spremi(k);
    }
    
}
