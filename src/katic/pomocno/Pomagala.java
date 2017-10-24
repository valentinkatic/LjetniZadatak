/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katic.pomocno;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import katic.ljetnizadatak.model.Restoran;

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
    
    private static JFileChooser dohvatiPutanju(String naziv,String datotekaOpis, String[] datotekaExtenzija, String naslov) {
        FileNameExtensionFilter filter = new FileNameExtensionFilter(datotekaOpis, datotekaExtenzija);

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(filter);
        fileChooser.setDialogTitle(naslov);
        fileChooser.setSelectedFile(new File(naziv));
        
        return fileChooser;
        
    }
    
    public static void spremiJson(List<Restoran> restorani){
        JFileChooser fileChooser = dohvatiPutanju("restorani.json","JSON datoteka",new String[]{"json"},"Odaberite datoteku");
            int userSelection = fileChooser.showSaveDialog(null);
            String putanja=null;
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                putanja=fileChooser.getSelectedFile().getAbsolutePath();
            }   if(putanja==null){
                return;
            }   Gson gson = new GsonBuilder().disableHtmlEscaping().create();
            String json = gson.toJson(restorani);
            
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(putanja));
                    writer.write(json);

                    writer.close();
        } catch (IOException ex) {
           
        } 
    }

    public static String dohvatiJson(){
        JFileChooser fileChooser = dohvatiPutanju("","JSON datoteka",new String[]{"json"},"Odaberite datoteku");
        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            try (BufferedReader br = new BufferedReader(new FileReader(fileChooser.getSelectedFile()))) 
            {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                return sb.toString();
            } catch (IOException exp) {
                exp.printStackTrace();
            }
        }
        return null;
    }
}
