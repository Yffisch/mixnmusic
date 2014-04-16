package edu.chalmers.melodymaker;

import edu.chalmers.melodymaker.core.MelodyLibrary;
import edu.chalmers.melodymaker.gui.MelodyMakerUI;

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
        MelodyMakerUI gui = MelodyMakerUI.getInstance();
        String[] args = {};
        MelodyMakerUI.main(args);
    }
}