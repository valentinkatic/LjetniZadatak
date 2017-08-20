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
import katic.ljetnizadatak.model.Korisnik;

/**
 *
 * @author valentin.katic
 */
public class ObradaKorisnik {
    
    private Connection veza;
    private PreparedStatement izraz;
    private ResultSet rs;
    
    public ObradaKorisnik(){
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
    
    public List<Korisnik> getKorisnici(){
        
        List<Korisnik> korisnici = new ArrayList<>();
        try{
            izraz = veza.prepareStatement("select * from korisnik where obrisano = false");
            rs = izraz.executeQuery();
            Korisnik k;
            while (rs.next()){
                k = new Korisnik(
                        rs.getInt("sifra"),
                        rs.getString("ime"),
                        rs.getString("prezime"),
                        rs.getString("email"),
                        rs.getString("lozinka"),
                        rs.getString("kontakt_broj")
                );
                korisnici.add(k);
            }
            rs.close();
            izraz.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return korisnici;
    }
    
    public void kreirajKorisnika(Korisnik k){
        try {
           izraz = veza.prepareStatement("insert into korisnik (ime,prezime,kontakt_broj,email,lozinka) values (?,?,?,?,?);");
           izraz.setString(1, k.getIme());
           izraz.setString(2, k.getPrezime());
           izraz.setString(3, k.getKontaktBroj());
           izraz.setString(4, k.getEmail());
           izraz.setString(5, k.getLozinka());
           izraz.execute();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void promijeniKorisnika(Korisnik k){
        try {
           izraz = veza.prepareStatement("update korisnik set ime=?, prezime=?, kontakt_broj=?, email=? ,lozinka=? where sifra=?;");
           izraz.setString(1, k.getIme());
           izraz.setString(2, k.getPrezime());
           izraz.setString(3, k.getKontaktBroj());
           izraz.setString(4, k.getEmail());
           izraz.setString(5, k.getLozinka());
           izraz.setInt(6, k.getSifra());
           izraz.execute();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void obrisiKorisnika(Korisnik k){
        try {
            izraz = veza.prepareStatement("update korisnik set obrisano = true where sifra=?");
            izraz.setInt(1, k.getSifra());
            izraz.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
