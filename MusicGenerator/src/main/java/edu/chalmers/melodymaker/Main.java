package edu.chalmers.melodymaker;

import edu.chalmers.melodymaker.core.MelodyLibrary;
import edu.chalmers.melodymaker.gui.MelodyMakerUI;
import edu.chalmers.melodymaker.io.MelodyExporter;

/**
 * @author: Kristofer
 *
 */
public class Main {

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
        new MelodyExporter().exportTune("temp.abc");
        MelodyMakerUI gui = MelodyMakerUI.getInstance();
        String[] args = {};
        MelodyMakerUI.main(args);
    }
}