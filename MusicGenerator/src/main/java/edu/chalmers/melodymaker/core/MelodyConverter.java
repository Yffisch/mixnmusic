package edu.chalmers.melodymaker.core;

import java.util.List;

/**
 * Converts a Melody object to a String
 * @author PearlOfNash
 */
public class MelodyConverter {

   private static MelodyConverter instance = null;
    
   protected MelodyConverter(){
   }
   
   public static MelodyConverter getInstance(){
       if (instance == null) {
            instance = new MelodyConverter();
        }
        return instance;
   }

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