/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.ljetnizadatak.model;

import java.util.List;

/**
 *
 * @author Valentin
 */
public class ImportPodataka {
    
    private List<Restoran> restorani;
    private List<Korisnik> korisnici;
    private List<KategorijaJela> kategorijeJela;
    private List<Jelo> jela;
    private List<AdresaDostave> adreseDostave;
    private List<KategorijaJela_Restoran> kategorijeJela_restorani;

    public ImportPodataka() {
    }

    public List<Restoran> getRestorani() {
        return restorani;
    }

    public void setRestorani(List<Restoran> restorani) {
        this.restorani = restorani;
    }

    public List<Korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(List<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }

    public List<KategorijaJela> getKategorijeJela() {
        return kategorijeJela;
    }

    public void setKategorijeJela(List<KategorijaJela> kategorijeJela) {
        this.kategorijeJela = kategorijeJela;
    }

    public List<Jelo> getJela() {
        return jela;
    }

    public void setJela(List<Jelo> jela) {
        this.jela = jela;
    }

    public List<AdresaDostave> getAdreseDostave() {
        return adreseDostave;
    }

    public void setAdreseDostave(List<AdresaDostave> adreseDostave) {
        this.adreseDostave = adreseDostave;
    }
    
    public List<KategorijaJela_Restoran> getKategorijeJela_restorani() {
        return kategorijeJela_restorani;
    }

    public void setKategorijeJela_restorani(List<KategorijaJela_Restoran> kategorijeJela_restorani) {
        this.kategorijeJela_restorani = kategorijeJela_restorani;
    }

    @Override
    public String toString() {
        return "ImportPodataka{" + "restorani=" + restorani + ", korisnici=" + korisnici + ", kategorijeJela=" + kategorijeJela + ", jela=" + jela + ", adreseDostave=" + adreseDostave + ", kategorijeJela_restorani=" + kategorijeJela_restorani + '}';
    }
    
    
    
}

