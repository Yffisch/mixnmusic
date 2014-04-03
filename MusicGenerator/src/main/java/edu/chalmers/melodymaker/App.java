package edu.chalmers.melodymaker;

import edu.chalmers.melodymaker.core.MelodyExporter;

/**
 * @author: Kristofer
 *
 */
public class App {

    MelodyExporter e;

    public static void main(String[] args){
        new App();
    }

    public App() {
    
                                       // Import file, export file
              e = new MelodyExporter("supermario.abc", "huuuu.txt");
              

       
    }
}
