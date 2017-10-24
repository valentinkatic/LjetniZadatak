/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.ljetnizadatak.controller;

import java.util.ArrayList;
import java.util.List;
import katic.ljetnizadatak.model.AdresaDostave;
import katic.ljetnizadatak.model.ImportPodataka;
import katic.ljetnizadatak.model.Jelo;
import katic.ljetnizadatak.model.KategorijaJela;
import katic.ljetnizadatak.model.KategorijaJela_Restoran;
import katic.ljetnizadatak.model.Korisnik;
import katic.ljetnizadatak.model.Restoran;

/**
 *
 * @author Valentin
 */
public class ObradaImportPodataka {
    
    private HibernateObrada<Jelo> obradaJelo;
    private HibernateObrada<AdresaDostave> obradaAdresaDostave;
    private HibernateObrada<KategorijaJela> obradaKategorijaJela;
    private HibernateObrada<Korisnik> obradaKorisnik;
    private HibernateObrada<Restoran> obradaRestoran;
    
    private ImportPodataka importPodataka;

    public ObradaImportPodataka(ImportPodataka importPodataka) {
        this.importPodataka = importPodataka;
        
        obradaJelo = new HibernateObrada<>();
        obradaAdresaDostave = new HibernateObrada<>();
        obradaKategorijaJela = new HibernateObrada<>();
        obradaKorisnik = new HibernateObrada<>();
        obradaRestoran = new HibernateObrada<>();
        
        spremiPodatke();
    }
    
    private void spremiPodatke(){
        try {           
            List<KategorijaJela> kategorijeJela = obradaKategorijaJela.saveFromImport(importPodataka.getKategorijeJela());
            List<Jelo> jela = importPodataka.getJela();
            List<Restoran> restorani = obradaRestoran.saveFromImport(importPodataka.getRestorani());
            for (Jelo j: jela){
                for (Restoran r: restorani){
                    if (j.getRestoran_sifra().equals(r.getSifra())){
                        j.setRestoran(r);
                        break;
                    }                          
                }
                for (KategorijaJela kj: kategorijeJela){
                    if (j.getKategorijaJela_sifra().equals(kj.getSifra())){
                        j.setKategorijaJela(kj);
                        break;
                    }
                }
            }
            obradaJelo.saveFromImport(importPodataka.getJela());
            List<Korisnik> korisnici = obradaKorisnik.saveFromImport(importPodataka.getKorisnici());
            List<AdresaDostave> adreseDostave = importPodataka.getAdreseDostave();
            for (AdresaDostave a: adreseDostave){
                for (Korisnik k: korisnici){
                    if (a.getKorisnik_sifra().equals(k.getSifra())){
                        a.setKorisnik(k);
                        break;
                    }
                }
            }
            obradaAdresaDostave.saveFromImport(adreseDostave);            
            for (KategorijaJela k: kategorijeJela){
                if (k.getRestorani()==null){
                    k.setRestorani(new ArrayList<>());
                }
                for (KategorijaJela_Restoran kr: importPodataka.getKategorijeJela_restorani()){
                    for (Restoran r: restorani){          
                        if (r.getSifra().equals(kr.getRestorani_sifra()) && k.getSifra().equals(kr.getKategorijeJela_sifra()) && !k.getRestorani().contains(r)){
                            k.getRestorani().add(r);
                            break;                      
                        }
                    }                      
                }               
            }
            obradaKategorijaJela.saveFromImport(kategorijeJela);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
