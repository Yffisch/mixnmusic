/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chalmers.melodymaker.controller;

import edu.chalmers.melodymaker.core.Melody;
import edu.chalmers.melodymaker.core.MelodyLibrary;
import edu.chalmers.melodymaker.gui.MelodyMakerUI;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author Emma
 */
public class MelodyController {

  
    public String inputGenre, inputSignature, inputKey, inputLength;
    private ArrayList<Melody> mMelodies;
    public Set<String> genres;
    
    public void sendGenerator(String genre, String signature, String key, String length){
        inputGenre = genre;
        inputSignature = signature;
        inputKey = key;
        inputLength = length;
        
        System.out.print("genre: " + inputGenre + "\nsignature: " + inputSignature);
        System.out.print("\nkey: " + inputKey + "\nlength: " + inputLength);

    }
    public Set<String> getGenres(){
         mMelodies =  MelodyLibrary.getInstance().getMelodies();
         for (Melody m : mMelodies){
             genres.add(m.getGenre());
         }
        
        return genres;
    }
    
    
}
