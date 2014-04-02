package edu.chalmers.melodymaker;

import edu.chalmers.melodymaker.core.MelodyExporter;
import edu.chalmers.melodymaker.io.MelodyLoader;
import java.io.File;
import java.io.IOException;

/**
 * @author: Kristofer
 *
 */
public class App {

    MelodyExporter e;

    public static void main(String[] args) throws IOException {
        new App();
    }

    public App() throws IOException {
    
                                       // Import file, export file
              e = new MelodyExporter("supermario.abc", "huuuu.txt");
              

       
    }
}
