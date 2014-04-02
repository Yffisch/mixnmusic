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
public class Alphabet {

    String[] noteAlphabet = {"c", "d", "e", "f", "g", "a", "b", "C", "D", "E", "F", "G", "A", "B", "h", "H"};

    public Alphabet() {

    }

    public boolean isLetterInAlphabet(String s) {
        for (int i = 0; i < noteAlphabet.length; i++) {
            if (noteAlphabet[i].contains(s)) {
                return true;
            }
        }
        return false;
    }
}
