package edu.chalmers.melodymaker;

import edu.chalmers.melodymaker.io.MelodyExporter;

/**
 * @author: Kristofer
 *
 */
public class Main {

    MelodyExporter e;

    public static void main(String[] args){
        new Main();
    }

    public Main() {
    
                                       // Import file, export file
              e = new MelodyExporter("supermario.abc", "huuuu.txt");
              

       
    }
}
