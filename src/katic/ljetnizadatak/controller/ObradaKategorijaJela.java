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
import katic.ljetnizadatak.model.KategorijaJela;

/**
 *
 * @author valentin.katic
 */
public class ObradaKategorijaJela {
    
    private Connection veza;
    private PreparedStatement izraz;
    private ResultSet rs;
    
    public ObradaKategorijaJela(){        
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
    
    public void kreirajKategorijuJela(KategorijaJela k){
        try {
           izraz = veza.prepareStatement("insert into kategorija_jela (naziv) values (?);");
           izraz.setString(1, k.getNaziv());         
           izraz.execute();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void promijeniKategorijuJela(KategorijaJela k){
        try {
           izraz = veza.prepareStatement("update kategorija_jela set naziv=? where sifra=?;");
           izraz.setString(1, k.getNaziv());
           izraz.setInt(2, k.getSifra());
           izraz.execute();
        } catch (Exception e){
            e.printStackTrace();
        }
    }  
    
    public void obrisiKategorijuJela(KategorijaJela k){
        try {
            izraz = veza.prepareStatement("update kategorija_jela set obrisano = true where sifra=?");
            izraz.setInt(1, k.getSifra());
            izraz.execute();
            izraz = veza.prepareStatement("update jelo set obrisano = true where kategorija_jela=?");
            izraz.setInt(1, k.getSifra());
            izraz.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
