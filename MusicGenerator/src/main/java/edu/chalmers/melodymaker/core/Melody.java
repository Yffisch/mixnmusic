package edu.chalmers.melodymaker.core;

import java.util.List;

/**
 * An object of this class stores all information we need for a melody
 * 
 * @author Emma
 */
public class Melody {

    //Classvariables
    private String genre, title, noteLength, signature, key;
    private int id;
    private final List<Note> listNotes;
    private List<String> filteredNotes;

    /**
     * Our Melody-object
     *
     * @param id
     * @param genre
     * @param title
     * @param noteLength
     * @param signature
     * @param key
     * @param alN
     */
    public Melody(int id, String title, String genre, String noteLength, String signature, String key, List<Note> alN) {
        this.id = id;
        this.genre = genre;
        this.title = title;
        this.noteLength = noteLength;
        this.signature = signature;
        this.key = key;
        listNotes = alN;
    }

    public String getGenre() {
        return genre;
    }

    public String getTitle() {
        return title;
    }

    public String getNoteLength() {
        return noteLength;
    }

    public String getSignature() {
        return signature;
    }

    public List<Note> getNoteList() {
        return listNotes;
    }

    public int getID() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public List<String> getFilteredNotes() {
        return filteredNotes;
    }

    public void setFilteredNotes(List<String> notes) {
        filteredNotes = notes;
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
