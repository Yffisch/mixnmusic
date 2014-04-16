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
    private String genre, title, noteLength, signature;
    private int id;
    private final ArrayList<Note> listNotes;

    //for test sake
    public Melody(ArrayList<Note> alN) {
        listNotes = alN;
        genre = "rock";
    }

    //Our Melody-object
    /**
     *
     * @param id
     * @param genre
     * @param title
     * @param noteLength
     * @param signature
     * @param alN
     */
    public Melody(int id, String genre, String title, String noteLength, String signature, ArrayList<Note> alN) {
        this.id = id;
        this.genre = genre;
        this.title = title;
        this.noteLength = noteLength;
        this.signature = signature;
        listNotes = alN;
    }

    public String getGenre() {
        return genre;
    }

    public String getTitle() {
        return title;
    }

    public String getNoteLegnth() {
        return noteLength;
    }

    public String getSignature() {
        return signature;
    }

    public ArrayList<Note> getNoteList() {
        return listNotes;
    }
    
    public int getID(){
        return id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Note note : listNotes) {
            sb.append(note.toString());
        }
        return sb.toString();
    }
}
