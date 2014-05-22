package edu.chalmers.melodymaker.core;

import java.util.ArrayList;

/**
 * Holds all Melody-objects
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

    public void addMelody(Melody melody) {
        melodies.add(melody);
    }

    /**
     * Returns a list of all melodies in the MelodyLibrary class
     *
     * @return
     */
    public ArrayList<Melody> getMelodies() {
        return melodies;
    }
}
