package edu.chalmers.melodymaker;

import edu.chalmers.melodymaker.controller.MelodyController;
import edu.chalmers.melodymaker.core.JsoupClass;
import edu.chalmers.melodymaker.gui.MainFrame;

/**
 * This class just starts the program
 *
 * @author: Kristofer
 *
 */
public class Main {

    /**
     *
     * @author Emma
     */
    public Main() {
        MelodyController.getInstance().fillLibrary();
        // Import file, export file
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame melodyUI = MainFrame.getInstance();
                melodyUI.setVisible(true);
                
               
            }
        });
    }

    public static void main(String[] args) {
        Main main = new Main();
        //test
    }
}
