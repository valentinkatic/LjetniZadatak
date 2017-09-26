/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.pomocno;

/**
 *
 * @author valentin.katic
 */

public class Iznimka extends Exception{
    
    private String opis;
    
    private int greska;
    
    public Iznimka(String poruka, String opis,int greska){
        super(poruka);
        this.opis = opis;
        this.greska = greska;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getGreska() {
        return greska;
    }

    public void setGreska(int greska) {
        this.greska = greska;
    }
    
}