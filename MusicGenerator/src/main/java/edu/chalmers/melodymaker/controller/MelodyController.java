/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chalmers.melodymaker.controller;

/**
 *
 * @author Yff
 */
public class MelodyController {

  
    public String inputGenre, inputSignature, inputKey, inputLength;
    
    
    public void sendGenerator(String genre, String signature, String key, String length){
        inputGenre = genre;
        inputSignature = signature;
        inputKey = key;
        inputLength = length;
        
        System.out.print("genre: " + inputGenre + "\nsignature: " + inputSignature);
        System.out.print("\nkey: " + inputKey + "\nlength: " + inputLength);
        

    }
    
    
}
