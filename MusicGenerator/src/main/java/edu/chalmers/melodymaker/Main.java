package edu.chalmers.melodymaker;

import edu.chalmers.melodymaker.core.MelodyLibrary;
import edu.chalmers.melodymaker.gui.MainFrame;

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
        MainFrame gui = MainFrame.getInstance();
        String[] args = {};
        MainFrame.main(args);
    }
}