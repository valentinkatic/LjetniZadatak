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
import katic.ljetnizadatak.model.AdresaDostave;

/**
 *
 * @author valentin.katic
 */
public class ObradaAdresaZaDostavu {
    
    private Connection veza;
    private PreparedStatement izraz;
    private ResultSet rs;
    
    public ObradaAdresaZaDostavu(){        
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
    
    public List<AdresaDostave> getAdreseDostave(int sifraKorisnika){
        
        List<AdresaDostave> adreseDostave = new ArrayList<>();
        try{
            izraz = veza.prepareStatement("select * from adresa_dostave where obrisano = false and korisnik = ?");
            izraz.setInt(1, sifraKorisnika);
            rs = izraz.executeQuery();
            AdresaDostave a;
            while (rs.next()){
                a = new AdresaDostave(
                        rs.getInt("sifra"),
                        rs.getString("ulica"),            
                        rs.getString("kucni_broj"),
                        rs.getString("grad")
                );
                adreseDostave.add(a);
            }
            rs.close();
            izraz.close();
        } catch (Exception e){}
        return  adreseDostave;       
    }
    
    public void kreirajAdresuDostave(AdresaDostave a, int sifraKorisnika){
        try {
           izraz = veza.prepareStatement("insert into adresa_dostave (ulica, kucni_broj, grad, korisnik) values (?,?,?,?);");
           izraz.setString(1, a.getUlica());         
           izraz.setString(2, a.getKucniBroj());
           izraz.setString(3, a.getGrad());
           izraz.setInt(4, sifraKorisnika);
           izraz.execute();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void promijeniAdresuDostave(AdresaDostave a){
        try {
           izraz = veza.prepareStatement("update adresa_dostave set ulica=?, kucni_broj=?, grad=? where sifra=?;");
           izraz.setString(1, a.getUlica());
           izraz.setString(2, a.getKucniBroj());
           izraz.setString(3, a.getGrad());
           izraz.setInt(4, a.getSifra());
           izraz.execute();
        } catch (Exception e){
            e.printStackTrace();
        }
    }  
    
    public void obrisiAdresuDostave(AdresaDostave a){
        try {
            izraz = veza.prepareStatement("update adresa_dostave set obrisano = true where sifra=?");
            izraz.setInt(1, a.getSifra());
            izraz.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
