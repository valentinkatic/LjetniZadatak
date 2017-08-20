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
import katic.ljetnizadatak.model.Restoran;

/**
 *
 * @author valentin.katic
 */
public class ObradaRestoran {
    
    private Connection veza;
    private PreparedStatement izraz;
    private ResultSet rs;
    
    public ObradaRestoran(){
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
    
    public List<Restoran> getRestorani(){
        
        List<Restoran> restorani = new ArrayList<>();
        try{
            izraz = veza.prepareStatement("select * from restoran where obrisano = false");
            rs = izraz.executeQuery();
            Restoran r;
            while (rs.next()){
                r = new Restoran(
                        rs.getInt("sifra"),
                        rs.getString("naziv"),
                        rs.getString("adresa"),
                        rs.getString("grad"),
                        rs.getString("kontakt_broj"),
                        rs.getString("email"),
                        rs.getString("lozinka"),
                        rs.getBlob("slika")
                );
                restorani.add(r);
            }
            rs.close();
            izraz.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return  restorani;
    }
    
    public void kreirajRestoran(Restoran r){
        try {
           izraz = veza.prepareStatement("insert into restoran (naziv,adresa,grad,kontakt_broj,email,lozinka) values (?,?,?,?,?,?);");
           izraz.setString(1, r.getNaziv());
           izraz.setString(2, r.getAdresa());
           izraz.setString(3, r.getGrad());
           izraz.setString(4, r.getKontaktBroj());
           izraz.setString(5, r.getEmail());
           izraz.setString(6, r.getLozinka());
           izraz.execute();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void promijeniRestoran(Restoran r){
        try {
           izraz = veza.prepareStatement("update restoran set naziv=?, adresa=?, grad=?, kontakt_broj=?, email=? ,lozinka=? where sifra=?;");
           izraz.setString(1, r.getNaziv());
           izraz.setString(2, r.getAdresa());
           izraz.setString(3, r.getGrad());
           izraz.setString(4, r.getKontaktBroj());
           izraz.setString(5, r.getEmail());
           izraz.setString(6, r.getLozinka());
           izraz.setInt(7, r.getSifra());
           izraz.execute();
        } catch (Exception e){
            e.printStackTrace();
        }
    }   
    
    public void obrisiRestoran(Restoran r){
        try {
            izraz = veza.prepareStatement("update restoran set obrisano = true where sifra=?");
            izraz.setInt(1, r.getSifra());
            izraz.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
