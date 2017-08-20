/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.ljetnizadatak.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import katic.ljetnizadatak.model.Jelo;
import katic.ljetnizadatak.model.KategorijaJela;

/**
 *
 * @author valentin.katic
 */
public class ObradaJelo {
    
    private Connection veza;
    private PreparedStatement izraz;
    private ResultSet rs;
    
    public ObradaJelo(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            veza = DriverManager.getConnection("jdbc:mysql://127.0.0.1/narucivanje_hrane", "root", "");
        } catch (Exception e){          
            e.printStackTrace();
        } 
    }
    
    public void zatvoriVezu(){
        try {
            veza.close();
        } catch (SQLException ex) {          
        }
    }
    
    public List<Jelo> getJela(int sifraRestorana, int sifraKategorije){
        
        List<Jelo> jela = new ArrayList<>();
        try{
            izraz = veza.prepareStatement("select * from jelo where obrisano = false and restoran = ? and kategorija_jela = ?");
            izraz.setInt(1, sifraRestorana);
            izraz.setInt(2, sifraKategorije);
            rs = izraz.executeQuery();
            Jelo j;
            while (rs.next()){
                j = new Jelo(
                        rs.getInt("sifra"),
                        rs.getString("naziv"),            
                        rs.getString("sastojci"),
                        rs.getDouble("cijena")
                );
                jela.add(j);
            }
            rs.close();
            izraz.close();
        } catch (Exception e){}
        return  jela;       
    }
    
    public List<KategorijaJela> getKategorijeJela(){
        
        List<KategorijaJela> kategorije = new ArrayList<>();
        try{
            izraz = veza.prepareStatement("select * from kategorija_jela where obrisano = false");
            rs = izraz.executeQuery();
            KategorijaJela k;
            while (rs.next()){
                k = new KategorijaJela(
                        rs.getInt("sifra"),
                        rs.getString("naziv")            
                );
                kategorije.add(k);
            }
            rs.close();
            izraz.close();
        } catch (Exception e){}
        return  kategorije;
       
    }
    
    public void kreirajJelo(Jelo j, int sifraRestorana, int sifraKategorije){
        try {
           izraz = veza.prepareStatement("insert into jelo (naziv, sastojci, cijena, restoran, kategorija_jela) values (?,?,?,?,?);");
           izraz.setString(1, j.getNaziv());         
           izraz.setString(2, j.getSastojci());
           izraz.setDouble(3, j.getCijena());
           izraz.setInt(4, sifraRestorana);
           izraz.setInt(5, sifraKategorije);
           izraz.execute();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void kreirajKategorijuJela(String naziv){
        try {
           izraz = veza.prepareStatement("insert into kategorija_jela (naziv) values (?);");
           izraz.setString(1, naziv);         
           izraz.execute();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void promijeniJelo(Jelo j){
        try {
           izraz = veza.prepareStatement("update jelo set naziv=?, sastojci=?, cijena=?, kategorija_jela=? where sifra=?;");
           izraz.setString(1, j.getNaziv());
           izraz.setString(2, j.getSastojci());
           izraz.setDouble(3, j.getCijena());
           izraz.setInt(4, j.getKategorija());
           izraz.setInt(5, j.getSifra());
           izraz.execute();
        } catch (Exception e){
            e.printStackTrace();
        }
    }  
    
    public void obrisiJelo(Jelo j){
        try {
            izraz = veza.prepareStatement("update jelo set obrisano = true where sifra=?");
            izraz.setInt(1, j.getSifra());
            izraz.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
