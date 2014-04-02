/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chalmers.melodymaker.core;

/**
 *
 * @author Emma
 */
public class Melody {
    
    public String genre, title, noteLength, signature;
    
    public void Melody(String g, String t, String n, String s){
        genre = g;
        title = t;
        noteLength = n;
        signature = s;
    }
    
    public String getGenre(){
        return genre;
    }
    
    public String getTitle(){
        return title;
    }
    
    public String getNoteLegnth(){
        return noteLength;
    }
    
    public String getSignature(){
        return signature;
    }
}
