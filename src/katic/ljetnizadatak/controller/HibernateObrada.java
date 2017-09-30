/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.ljetnizadatak.controller;

import java.util.Date;
import java.util.List;
import katic.ljetnizadatak.model.Entitet;
import katic.pomocno.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Polaznik
 */
public class HibernateObrada<T extends Entitet> {
    
    private final Session session;
    
    public  HibernateObrada(){
        session=HibernateUtil.getSession();
    }
    //Create ili Update ili Delete jer imamo atribut delete
    public T save(T entitet){
       Date d = new Date();
       if(entitet.getSifra()== null){
           entitet.setDatumKreiranja(d);
       }
       entitet.setDatumPromjene(d);
       session.beginTransaction();
       session.saveOrUpdate(entitet);
       session.getTransaction().commit();
        return entitet;
    }
    
    //Delete
    public void delete(T entitet){ 
        entitet.setObrisan(true);
        save(entitet);
    }
    
  
    public List<T> save(List<T> lista){
       session.beginTransaction();
       lista.stream().forEach((entitet)->{
           Date d = new Date();
           if(entitet.getSifra() == null){
                entitet.setDatumKreiranja(d);
            }
            entitet.setDatumPromjene(d);
           session.saveOrUpdate(entitet);
       });
       session.getTransaction().commit();
        return lista;
    }
    
}
