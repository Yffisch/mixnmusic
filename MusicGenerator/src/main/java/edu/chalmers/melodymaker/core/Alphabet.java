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

    static String[] noteAlphabet = {"c/2", "d/2", "e/2", "f/2", "g/2", "a/2", "b/2", "C/2", "D/2", "E/2", "F/2", "G/2", "A/2", "B/2", "h/2", "H/2",
                                     "c2", "d2", "e2", "f2", "g2", "a2", "b2", "C2", "D2", "E2", "F2", "G2", "A2", "B2", "h2", "H2",
                                     "c’", "d’", "e’", "f’", "g’", "a’", "b’", "C’", "D’", "E’", "F’", "G’", "A’", "B’", "h’", "H’",
                                     "^c", "^d", "^e", "^f", "^g", "^a", "^b", "^C", "^D", "^E", "^F", "^G", "^A", "^B", "^h", "^H",
                                     "_c", "_d", "_e", "_f", "_g", "_a", "_b", "_C", "_D", "_E", "_F", "_G", "_A", "_B", "_h", "_H",
                                     "c", "d", "e", "f", "g", "a", "b", "C", "D", "E", "F", "G", "A", "B", "h", "H"};

    public Alphabet() {
    }

    public static boolean isLetterInAlphabet(String s) {
        for (String note : noteAlphabet) {
            if (note.equals(s)) {
                return true;
            }
        }
        return false;
    }
}
