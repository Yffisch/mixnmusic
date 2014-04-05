/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chalmers.melodymaker.core;

/**
 *
 * @author Yff
 */
public class MelodyTheory {

    // Maybe make an own class of this that you can hårdkoda in?
    public static boolean breaksMusicTheory(String currentNote, String next) {
        // Här kanske man ska ha en getTonart och getMeter och så to be able to implement what notes that are allowed
        //does break theory
        
        if (currentNote.equals("C/2") && next.equals("C/2")) {
            return true;
        } //does break theory
        else if (currentNote.equals("D") && next.equals("D")) {
            return true;
        } else if (currentNote.equals("E") && next.equals("E")) {
            return true;
        } else if (currentNote.equals("F") && next.equals("F")) {
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
