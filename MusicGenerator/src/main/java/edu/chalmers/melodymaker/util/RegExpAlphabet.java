/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chalmers.melodymaker.util;

/**
 *
 * @author Yff
 */
public class RegExpAlphabet {

    static String[] regexpAlphabet = {"\\w", "\\W", "D", "C"};

    public RegExpAlphabet() {
    }

    public static boolean isLetterInREAlphabet(String s) {
        for (String re : regexpAlphabet) {
            if (re.equals(s)) {
                return true;
            }
        }
        return false;
    }
}
