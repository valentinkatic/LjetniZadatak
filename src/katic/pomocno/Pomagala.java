/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.pomocno;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author valentin.katic
 */
public class Pomagala {
    
    public static boolean provjeriJelOznaceno(JList lista, Component rootPane){
        if(lista.getSelectedValue()==null){
            JOptionPane.showMessageDialog(rootPane, "Prvo odaberite stavku");
            return false;
        } 
        return true;
    }
    
    public static void izbaciDialogSGreskom(Component rootPane, Iznimka i){
        JOptionPane.showMessageDialog(rootPane, i.getOpis(), i.getMessage(), JOptionPane.WARNING_MESSAGE);         
    }
    
    public static Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }
    
    public static String ucitajFile(String filename) {
        String result = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            result = sb.toString();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
}
