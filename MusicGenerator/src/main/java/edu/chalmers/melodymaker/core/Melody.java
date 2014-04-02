/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chalmers.melodymaker.core;

import java.util.ArrayList;


/**
 *
 * @author Emma
 */
public class Melody {
    
    //Classvariables
    public String genre, title, noteLength, signature;
    public ArrayList<Note> listNotes;
    
    
    //for test sake
    public Melody(ArrayList<Note> alN){
        listNotes = alN;
    }
    
    //Our Melody-object

    /**
     *
     * @param g
     * @param t
     * @param n
     * @param s
     * @param alN
     */
        public Melody(String g, String t, String n, String s, ArrayList<Note> alN ){
        genre = g;
        title = t;
        noteLength = n;
        signature = s;
        listNotes = alN;
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
        return listNotes;
    } 
}
