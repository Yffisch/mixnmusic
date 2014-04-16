package edu.chalmers.melodymaker;

import edu.chalmers.melodymaker.core.MelodyLibrary;
import edu.chalmers.melodymaker.gui.MelodyMakerUI;
import edu.chalmers.melodymaker.io.MelodyExporter;

/**
 * @author: Kristofer
 *
 */
public class Main {

    MelodyExporter e;

    public static void main(String[] args) {
        Main main = new Main();
    }

    /**
     *
     * @author Emma
     */
    public Main() {
        MelodyLibrary.getInstance().makeMelody();
        // Import file, export file
        e = new MelodyExporter("supermario.abc", "huuuu.txt");
        e.toMIDI(null, "test");
        MelodyMakerUI gui = MelodyMakerUI.getInstance();
        String[] args = {};
        MelodyMakerUI.main(args);
    }
}