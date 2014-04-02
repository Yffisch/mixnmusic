/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chalmers.melodymaker.core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Emma
 */
public class Melody {
    
    //Classvariables
    public String genre, title, noteLength, signature;
    public ArrayList<Note> listNodes = new ArrayList<>();
    
    //Our Melody-object
    public void Melody(String g, String t, String n, String s, ArrayList<Note> alN ){
        genre = g;
        title = t;
        noteLength = n;
        signature = s;
        listNodes = alN;
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
    public ArrayList<Note> getNoteList(){
        return listNodes;
    } 
}
