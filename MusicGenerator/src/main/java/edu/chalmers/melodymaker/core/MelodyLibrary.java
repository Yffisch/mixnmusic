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

    private final ArrayList<Melody> melodies;
    private static final MelodyLibrary melodyModel = new MelodyLibrary();

    private MelodyLibrary() {
        melodies = new ArrayList<>();
    }

    public static MelodyLibrary getInstance() {
        return melodyModel;
    }

    public void makeMelody(){
        MelodyLoader melodyLoader = new MelodyLoader();
        melodyLoader.loadFileList();

        if (!MelodyLoader.files.isEmpty()) {
            //String genre, String signature, String key, String length)
            for (File file : MelodyLoader.files) {
                melodyLoader.loadMelody(file.getName());
                Melody melody = new Melody(melodyLoader.getNoteList());
                melodies.add(melody);
            }
            for (Melody melody : melodies) {
                System.out.print(melody);
                System.out.println();
            }
        }
    }

    public ArrayList<Melody> getMelodies() {
        return melodies;
    }

}
