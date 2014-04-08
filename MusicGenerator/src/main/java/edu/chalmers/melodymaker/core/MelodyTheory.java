/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chalmers.melodymaker.core;

import java.util.ArrayList;

/**
 *
 * @author Yff
 */
public class MelodyTheory {

    
    public static ArrayList<String> applyMusicTheory(ArrayList<String> s){
        ArrayList<String> newlist = new ArrayList<>();
        int i = 0;
         newlist.add(s.get(i));
        for(; i < s.size()-1; i++){
            if(!breaksMusicTheory(s.get(i),s.get(i+1))){
                newlist.add(s.get(i+1));
                
            }

           // breaksMusicTheory(s.get(i),s.get(i+1));
        }
        return newlist;
        
    }
    // Maybe make an own class of this that you can hårdkoda in?
    public static boolean breaksMusicTheory(String currentNote, String next) {
        // Här kanske man ska ha en getTonart och getMeter och så to be able to implement what notes that are allowed
        //does break theory
        
        if (currentNote.equals("C") && next.equals("C")) {
            return true;
        } //does break theory
        else if (currentNote.equals("C") && next.equals("C")) {
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
        }

        return false;

    }
}
