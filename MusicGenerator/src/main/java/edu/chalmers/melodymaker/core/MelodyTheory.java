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
    public static boolean breaksMusicTheory(String prev, String next) {
        // Här kanske man ska ha en getTonart och getMeter och så to be able to implement what notes that are allowed
        //does break theory
        if (prev.charAt(prev.length() - 1) == 'C' && next.equals("C")) {
            return true;
        } //does break theory
        else if (prev.charAt(prev.length() - 1) == 'D' && next.equals("D")) {
            return true;
        } else if (prev.charAt(prev.length() - 1) == 'E' && next.equals("E")) {
            return true;
        } else if (prev.charAt(prev.length() - 1) == 'F' && next.equals("F")) {
            return true;
        } else if (prev.charAt(prev.length() - 1) == 'G' && next.equals("G")) {
            return true;
        } else if (prev.charAt(prev.length() - 1) == 'A' && next.equals("A")) {
            return true;
        } else if (prev.charAt(prev.length() - 1) == 'B' && next.equals("B")) {
            return true;
        } else if (prev.charAt(prev.length() - 1) == '2' && next.equals("2")) {
            return true;
        }

        return false;

    }
}
