package edu.chalmers.melodymaker;

import static edu.chalmers.melodymaker.Main.main;
import edu.chalmers.melodymaker.gui.MelodyMakerUI;
import edu.chalmers.melodymaker.io.MelodyExporter;

/**
 * @author: Kristofer
 *
 */
public class Main {

    MelodyExporter e;
    

    public static void main(String[] args){
        Main main = new Main();   
    }

    public Main() {
    
                                       // Import file, export file
              e = new MelodyExporter("supermario.abc", "huuuu.txt");
              MelodyMakerUI kalle = new MelodyMakerUI();
        String[] args = {};
              kalle.main(args);

       
    }
}
