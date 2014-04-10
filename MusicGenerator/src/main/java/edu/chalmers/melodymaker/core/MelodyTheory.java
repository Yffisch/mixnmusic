/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chalmers.melodymaker.core;

import edu.chalmers.melodymaker.gui.MelodyMakerUI;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yff
 */
public class MelodyTheory {

       public static ArrayList<String> preRuleList = new ArrayList<>();
    public static ArrayList<String> nextRuleList = new ArrayList<>();

    public static ArrayList<String> getPreRuleList() {
        return preRuleList;
    }

    public static ArrayList<String> getNextRuleList() {
        return nextRuleList;
    }
    
    public static List<Note> applyMusicTheory(List<Note> notes){
        List<Note> newlist = new ArrayList<>();
        int i = 0;
         newlist.add(notes.get(i));
        for(; i < notes.size()-1; i++){
            if(!breaksMusicTheory(notes.get(i).toString(), notes.get(i+1).toString())){
                newlist.add(notes.get(i+1));
                
            }

           // breaksMusicTheory(s.get(i),s.get(i+1));
        }
        return newlist;
        
    }
    // Maybe make an own class of this that you can hårdkoda in?
    public static boolean breaksMusicTheory(String currentNote, String next) {
        // Här kanske man ska ha en getTonart och getMeter och så to be able to implement what notes that are allowed
        //does break theory
       
        for(int i = 0; i < preRuleList.size(); i++){
                  if (currentNote.equals("") && next.equals("")) {
            return true;
        } 
           else if (currentNote.equals(preRuleList.get(i)) && next.equals(preRuleList.get(i))) {
            return true;
        }
        
        }
       
       /* else if (currentNote.equals("C") && next.equals("C")) {
            return true;
        } else if (currentNote.equals("C/2") || next.equals("C/2")) {
            return true;
        } else if (currentNote.equals("h") && next.equals("h")) {
            return true;
        } else if (currentNote.equals("G") && next.equals("G")) {
            return true;
        } else if (currentNote.equals("A") && next.equals("A")) {
            return true;
        } else if (currentNote.equals("B") && next.equals("B")) {
            return true;
        } else if (currentNote.equals("2") && next.equals("2")) {
            return true;
        }*/

        return false;

    }
}
