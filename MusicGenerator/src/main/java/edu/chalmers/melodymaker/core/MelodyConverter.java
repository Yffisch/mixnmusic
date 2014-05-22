/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.chalmers.melodymaker.core;
import java.util.List;
/**
 * Converts a Melody object to a String
 * @author PearlOfNash
 */
public class MelodyConverter {
    

    public String convertMelody(Melody melody){
        List<String> notes = melody.getFilteredNotes();
        StringBuilder sb = new StringBuilder();
        //Build ABC
        sb.append("X:");
        sb.append(melody.getID());
        sb.append("\nT:");
        sb.append(melody.getTitle());
        sb.append("\nR:");
        sb.append(melody.getGenre());
        sb.append("\nM:");
        sb.append(melody.getSignature());
        sb.append("\nL:");
        sb.append(melody.getNoteLength());
        sb.append("\nK:");
        sb.append(melody.getKey());
        sb.append("\n");
        for (String note : notes) {
            sb.append(note);
        }
        return sb.toString();
    }
}