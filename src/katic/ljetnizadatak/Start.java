/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.ljetnizadatak;

import katic.ljetnizadatak.view.Izbornik;
import katic.pomocno.HibernateUtil;

/**
 *
 * @author valentin.katic
 */
public class Start {

    public static void main(String[] args) {
        new Izbornik().setVisible(true);
        HibernateUtil.getSession();
    }
    
}

