package edu.chalmers.melodymaker.core;

/**
 * A simple wrapper class that holds a note, represented as a String of various
 * length
 *
 * @author Yff
 */
public class Note {

    private String note;

    public Note(String s) {
        note = s;
    }

    @Override
    public String toString() {
        return note;
    }

    public void setNote(String s) {
        note = s;
    }
}
