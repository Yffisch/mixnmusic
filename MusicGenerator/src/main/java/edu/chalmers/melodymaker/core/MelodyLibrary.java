/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chalmers.melodymaker.core;

import edu.chalmers.melodymaker.io.MelodyLoader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Emma Nyborg
 */
public class MelodyLibrary {

    private ArrayList<Melody> melObj;
    private static final MelodyLibrary melodyModel = new MelodyLibrary();

    private MelodyLibrary() {
        melObj = new ArrayList<>();
    }

    public static MelodyLibrary getInstance() {
        return melodyModel;
    }

    public void makeMelody(){

        MelodyLoader m = new MelodyLoader();
        m.loadFileList();

        if (!MelodyLoader.files.isEmpty()) {
            //String genre, String signature, String key, String length)
            for (File f : MelodyLoader.files) {
                m.loadMelody(f.getName());
                Melody mel = new Melody(m.getNoteList());
                melObj.add(mel);
            }
            for (Melody melody : melObj) {
                System.out.print(melody);
                System.out.println();
            }
        }
    }

    public ArrayList<Melody> getMelodies() {
        return melObj;
    }

}
