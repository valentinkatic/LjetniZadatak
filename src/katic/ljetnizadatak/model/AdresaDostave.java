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
public class AdresaDostave extends Entitet{
    
    private String ulica;
    private String kucniBroj;
    private String grad;

    public AdresaDostave(int sifra, String ulica, String kucniBroj, String grad) {
        super(sifra);
        this.ulica = ulica;
        this.kucniBroj = kucniBroj;
        this.grad = grad;
    }

    public AdresaDostave() {
    }       

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getKucniBroj() {
        return kucniBroj;
    }

    public void setKucniBroj(String kucniBroj) {
        this.kucniBroj = kucniBroj;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    @Override
    public String toString() {
        return ulica + " " + kucniBroj + ", " + grad;
    }
    
    
    
}
