package edu.chalmers.melodymaker.core;

import edu.chalmers.melodymaker.io.IMelodyIO;
import edu.chalmers.melodymaker.io.MelodyIOFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * Loads all abc-files within the import directory (abc)
     */
    public void fillLibrary() {
        IMelodyIO melodyLoader = MelodyIOFactory.getLoader();
        List<File> files = melodyLoader.loadFileList();

        if (!files.isEmpty()) {
            //String genre, String signature, String key, String length)
            for (File file : files) {
                Melody melody = melodyLoader.loadMelody(file.getName());
                melodies.add(melody);
            }
        }
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
