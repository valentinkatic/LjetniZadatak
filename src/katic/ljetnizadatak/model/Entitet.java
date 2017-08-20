/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.ljetnizadatak.model;

/**
 *
 * @author valentin.katic
 */
public class Entitet {
    private int sifra;

    public Entitet(int sifra) {
        this.sifra = sifra;
    }

    public Entitet(){}
    
    public int getSifra() {
        return sifra;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
    }
    
    
}
