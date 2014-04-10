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
    private List<Note> listNotes;
    
    
    //for test sake
    public Melody(List<Note> alN){
        listNotes = alN;
        genre = "rock";
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
    public List<Note> getNoteList(){
        return listNotes;
    } 
    
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Note note : listNotes){
            sb.append(note.getNote());
        }
        return sb.toString();
    }
}
