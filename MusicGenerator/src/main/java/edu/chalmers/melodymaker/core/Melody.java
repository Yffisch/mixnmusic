/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chalmers.melodymaker.core;

/**
 *
 * @author PearlOfNash
 */
public class Melody {
    
    public String genre, title, noteLegnth, signature;
    
    public void Melody(String g, String t, String n, String s){
        genre = g;
        title = t;
        noteLegnth = n;
        signature = s;
    }
    
    public String getGenre(){
        return genre;
    }
    
    public String getTitle(){
        return title;
    }
    
    public String getNoteLegnth(){
        return noteLegnth;
    }
    
    public String getSignature(){
        return signature;
    }
}
